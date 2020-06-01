package com.wang.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Created by Administrator on 2020/5/23 14:40
 */
@SpringBootApplication
@EnableEurekaClient//在服务启动后自动注册到Eureka中
@EnableDiscoveryClient
public class DeptProviderConfig_8001 {
    public static void main(String[] args) {
        SpringApplication.run(DeptProviderConfig_8001.class,args);
    }
}
