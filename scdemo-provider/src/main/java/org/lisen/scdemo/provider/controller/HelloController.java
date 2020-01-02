package org.lisen.scdemo.provider.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Administrator
 * @create 2020-01-0112:37
 */
@RestController
public class HelloController {

    @GetMapping("/sayHello")
    public Map<String,Object> sayHello() {
        System.out.println("------ provider sayHello -------");
        Map<String,Object> map = new HashMap<>();
        map.put("code",1);
        map.put("msg", "操作成功");
        return map;
    }

}
