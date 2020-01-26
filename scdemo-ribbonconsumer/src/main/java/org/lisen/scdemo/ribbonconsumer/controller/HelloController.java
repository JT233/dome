package org.lisen.scdemo.ribbonconsumer.controller;

import org.lisen.scdemo.ribbonconsumer.service.IHelloService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Administrator
 * @create 2020-01-0119:11
 */
@RestController
@RefreshScope
public class HelloController {

    @Value("${env}")
    private String env;

    @Resource
    private IHelloService helloService;

    @GetMapping("/sayHello")
    public Object sayHello(String name) {
        System.out.println("调用服务提供者的sayHello方法 。。。 ");
        Map<String,Object> map = helloService.sayHello(name);
        return map;
    }

    @GetMapping("/env")
    public Object printEnv() {
        Map<String, Object> map = new HashMap<>();
        map.put("env", env);
        return map;
    }
}
