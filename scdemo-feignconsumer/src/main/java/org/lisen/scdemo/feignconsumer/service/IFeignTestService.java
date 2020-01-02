package org.lisen.scdemo.feignconsumer.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

/**
 * @author Administrator
 * @create 2020-01-0122:37
 */
@FeignClient(name="scdemo-provider")
public interface IFeignTestService {

    @RequestMapping(value = "/sayHello", method = RequestMethod.GET)
    Map<String, Object> sayHello();

}
