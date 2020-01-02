package org.lisen.scdemo.feignconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author Administrator
 * @create 2020-01-0122:15
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class SCDemoFeignConsumberApp {

    public static void main(String[] args) {
        SpringApplication.run(SCDemoFeignConsumberApp.class, args);
    }

}
