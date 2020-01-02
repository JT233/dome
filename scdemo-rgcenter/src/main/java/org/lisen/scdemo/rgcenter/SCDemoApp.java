package org.lisen.scdemo.rgcenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author Administrator
 * @create 2019-12-3119:57
 */
@SpringBootApplication
@EnableEurekaServer
public class SCDemoApp {

    public static void main(String[] args) {
        SpringApplication.run(SCDemoApp.class,args);
    }

}
