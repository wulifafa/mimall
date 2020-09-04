package com.lf.mimallgenerator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MimallGeneratorApplication {

    public static void main(String[] args) {
        SpringApplication.run(MimallGeneratorApplication.class, args);
    }

}
