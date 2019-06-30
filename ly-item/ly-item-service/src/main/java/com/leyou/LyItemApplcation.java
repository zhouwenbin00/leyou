package com.leyou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author: zwb
 * @Date: 2019-07-01 0:20
 */

@SpringBootApplication
@EnableDiscoveryClient
public class LyItemApplcation {

    public static void main(String[] args) {
        SpringApplication.run(LyItemApplcation.class);
    }
}
