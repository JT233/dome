package org.lisen.scdemo.feignconsumer.controller;

import org.lisen.scdemo.feignconsumer.service.IFeignTestService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author Administrator
 * @create 2020-01-0122:41
 */
@RestController
public class FeignTestController {

    @Resource
    private IFeignTestService feignTestService;

    @GetMapping("/sayHello")
    public Map<String,Object> sayHello() {

        System.out.println("feign 调用服务提供者提供的服务 。。。 ");
        Map<String,Object> map = feignTestService.sayHello();

        return map;

    }

}
