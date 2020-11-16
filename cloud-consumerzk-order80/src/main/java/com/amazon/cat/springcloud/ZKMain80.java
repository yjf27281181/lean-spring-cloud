package com.amazon.cat.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author yanjuefei
 * @date 2020/11/15 0015
 * @Description
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ZKMain80 {
    public static void main(String[] args) {
        SpringApplication.run(ZKMain80.class, args);
    }
}
