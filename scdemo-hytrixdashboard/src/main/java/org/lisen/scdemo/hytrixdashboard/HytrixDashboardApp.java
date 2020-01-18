package org.lisen.scdemo.hytrixdashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

/**
 * @author Administrator
 * @create 2020-01-0723:09
 */
@EnableEurekaClient
@SpringBootApplication
@EnableHystrixDashboard
@EnableTurbine
public class HytrixDashboardApp {

    public static void main(String[] args) {
        SpringApplication.run(HytrixDashboardApp.class, args);
    }

}
