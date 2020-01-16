package org.lisen.scdemo.ribbonconsumer.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Administrator
 * @create 2020-01-0118:16
 */
@Service
public class HelloServiceImpl implements IHelloService {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "sayHelloFallback")
    @Override
    public Map<String,Object> sayHello(String name) {
        Map<String,Object> rv = restTemplate.getForEntity("http://scdemo-provider/sayHello", HashMap.class, name).getBody();
        for(Map.Entry entry: rv.entrySet()) {
            System.out.println(entry.getKey() + ":  " + entry.getValue());
        }
        return rv;
    }

    public Map<String, Object> sayHelloFallback(String name) {
        Map<String,Object> map = new HashMap<>();
        map.put("code", 2);
        map.put("msg", "服务熔断（ribbon）name = " + name);
        return map;
    }

}
