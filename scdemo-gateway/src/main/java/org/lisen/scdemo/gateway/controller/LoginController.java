package org.lisen.scdemo.gateway.controller;

import org.lisen.scdemo.gateway.util.JwtTokenUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Administrator
 * @create 2020-01-2011:46
 */
@RestController
public class LoginController {

    @PostMapping("/user/login")
    public Object login(String uname, String pwd) {

        //演示用户名和密码的验证。
        if("admin".equals(uname) && "123456".equals(pwd)) {
            Map<String,Object> claims = new HashMap<>();
            claims.put("uname", uname);
            claims.put("pwd",pwd);
            String jwt = JwtTokenUtils.createToken(claims, JwtTokenUtils.JWT_WEB_TTL);
            Map<String,Object> data = new HashMap<>();
            data.put("code", 1);
            data.put("token", jwt);
            return data;
        } else {
            Map<String,Object> data = new HashMap<>();
            data.put("code", -1);
            data.put("token", "");
            return data;
        }

    }

}
