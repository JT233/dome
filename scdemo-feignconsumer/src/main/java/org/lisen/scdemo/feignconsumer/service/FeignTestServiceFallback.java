package org.lisen.scdemo.feignconsumer.service;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * 该类定义熔断发生时的回调方法
 * @author Administrator
 * @create 2020-01-0719:35
 */
@Component
public class FeignTestServiceFallback implements IFeignTestService {

    @Override
    public Map<String, Object> sayHello(String name) {
        Map<String,Object> map = new HashMap<>();
        map.put("code", 2);
        map.put("msg", "服务提供者熔断 name =" + name);
        return map;
    }

}
