package org.lisen.scdemo.ribbonconsumer.service;

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

    @Override
    public Map<String,Object> sayHello() {
        Map<String,Object> rv = restTemplate.getForEntity("http://scdemo-provider/sayHello", HashMap.class).getBody();
        for(Map.Entry entry: rv.entrySet()) {
            System.out.println(entry.getKey() + ":  " + entry.getValue());
        }
        return rv;
    }

}
