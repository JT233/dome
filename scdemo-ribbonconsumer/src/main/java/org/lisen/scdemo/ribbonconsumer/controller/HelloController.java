package org.lisen.scdemo.ribbonconsumer.controller;

import org.lisen.scdemo.ribbonconsumer.service.IHelloService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author Administrator
 * @create 2020-01-0119:11
 */
@RestController
public class HelloController {

    @Resource
    private IHelloService helloService;

    @GetMapping("/sayHello")
    public Object sayHello(String name) {
        System.out.println("调用服务提供者的sayHello方法 。。。 ");
        Map<String,Object> map = helloService.sayHello(name);
        return map;
    }

}
