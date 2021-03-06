package org.lisen.scdemo.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author Administrator
 * @create 2020-01-1820:44
 */
@SpringBootApplication
@EnableZuulProxy
@EnableEurekaClient
@EnableHystrix
@EnableCircuitBreaker
public class GateWayApp {

    public static void main(String[] args) {
        SpringApplication.run(GateWayApp.class, args);
    }

}
