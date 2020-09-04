package com.lf.mimallnacos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MimallNacosApplication {

    public static void main(String[] args) {
        SpringApplication.run(MimallNacosApplication.class, args);
    }

}
