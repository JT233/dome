package org.lisen.scdemo.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author Administrator
 * @create 2020-01-0114:34
 */
@EnableEurekaClient
@SpringBootApplication
public class SCDemoProviderApp {

    public static void main(String[] args) {
        SpringApplication.run(SCDemoProviderApp.class,args);
    }

}
