package com.lf.mimall.oauth2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MimallOauth2AuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(MimallOauth2AuthApplication.class, args);
    }

}
