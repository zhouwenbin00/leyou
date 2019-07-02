package com.leyou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author: zwb
 * @Date: 2019-07-02 9:44
 */
@EnableDiscoveryClient
@SpringBootApplication
public class LyUploadApplication {

    public static void main(String[] args) {
        SpringApplication.run(LyUploadApplication.class);
    }
}
