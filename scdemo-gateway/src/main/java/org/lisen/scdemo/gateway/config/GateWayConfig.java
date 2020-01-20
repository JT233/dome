package org.lisen.scdemo.gateway.config;

import org.lisen.scdemo.gateway.filter.AuthFilter;
import org.springframework.cloud.netflix.zuul.filters.discovery.PatternServiceRouteMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Administrator
 * @create 2020-01-1921:30
 */
@Configuration
public class GateWayConfig {

    /**
     * 该配置是自定义的路由配置规则。
     *
     * <p>
     * 可以用来支持微服务的多版本发布。例如有一个微服务名为userService需要同时发布v1.0和v2.0版本，
     * 我们可以将v1.0版本的服务命名为userService-v1.0，将v2.0版本的服务命名为userService-v2.0，
     * 在通过zuul网关访问时，如果访问v1.0版本，则可以使用类似于如下方式进行访问：
     * http://localhost:8090/v1.0/userService/sayHello?name=qq
     * 如果需要访问v2.0则可以使用类似于一下方式：
     * http://localhost:8090/v2.0/userService/sayHello?name=qq
     * </p>
     *
     * <p>
     * 利用这种方式还可为请求加上统一的前缀，例如：希望在通过网关调用服务时同时加上api前缀，
     * 则可以将第二个参数修改为("/api/${version}/${name}")，这时如果需要调用服务，则需要使用类似如下方式：
     * http://localhost:8090/api/v2.0/userService/sayHello?name=qq
     * </p>
     *
     * @return PatternServiceRouteMapper
     */
    @Bean
    public PatternServiceRouteMapper serviceRouteMapper() {
        return new PatternServiceRouteMapper(
                "(?<name>^.+)-(?<version>v.+$)",
                "${version}/${name}");
    }


    /**
     * 该过滤器用于验证Token令牌，令牌有效后才会由网关转发请求，有了这个过滤器后，运行与网关后面的微服务就不用
     * 进行Token验证了。
     *
     * @return AuthFilter 自定义安全验证过滤器
     */
    @Bean
    public AuthFilter getAuthFilter() {
        return new AuthFilter();
    }

}
