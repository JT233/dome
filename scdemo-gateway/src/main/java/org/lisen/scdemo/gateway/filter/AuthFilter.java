package org.lisen.scdemo.gateway.filter;

import com.alibaba.fastjson.JSONObject;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import io.jsonwebtoken.Claims;
import org.lisen.scdemo.gateway.util.JwtTokenUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * 认证过滤器，用于对请求的令牌进行校验，如果没有合法的令牌则不允许访问接口服务。
 *
 * @author Administrator
 * @create 2020-01-2000:25
 */
public class AuthFilter extends ZuulFilter {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private static String LOGIN_URI = "/user/login";

    private static String REGISTER_URI = "/user/register";

    private static String TOKEN_PREFIX = "Bearer ";


    @Override
    public String filterType() {
        return "pre";
    }


    @Override
    public int filterOrder() {
        return 0;
    }


    @Override
    public boolean shouldFilter() {
        RequestContext ctx = RequestContext.getCurrentContext();
        String requestURI = ctx.getRequest().getRequestURI();

        //登录和注册是不需要验证令牌的
        if(requestURI.endsWith(LOGIN_URI) || requestURI.endsWith(REGISTER_URI)) {
            logger.info("登录或注册不用进行令牌验证");
            return false;
        }

        return true;
    }


    @Override
    public Object run() throws ZuulException {

        RequestContext ctx = RequestContext.getCurrentContext();
        String authorization = ctx.getRequest().getHeader("Authorization");

        ctx.getResponse().setHeader("content-type","application/json;charset=utf-8");

        Map<String,Object> info = new HashMap<>();
        info.put("code", -1);
        info.put("msg", "该请求没有包含有效的令牌");

        if(StringUtils.isEmpty(authorization)) {
            //终止请求转发
            ctx.setSendZuulResponse(false);
            //设置返回码，401 Unauthorized当前请求需要用户验证
            ctx.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
            ctx.setResponseBody(JSONObject.toJSONString(info));
        } else {
            String token = authorization.replaceAll(TOKEN_PREFIX, "");
            try {
                Claims claims = JwtTokenUtils.parseToken(token);
                //刷新
                String newToken = JwtTokenUtils.reflushToken(token, JwtTokenUtils.JWT_WEB_TTL);
                ctx.getResponse().setHeader("Authorization", newToken);
            } catch (Exception e) {
                ctx.setSendZuulResponse(false);
                ctx.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
                ctx.setResponseBody(JSONObject.toJSONString(info));
            }
        }

        return null;
    }

}
