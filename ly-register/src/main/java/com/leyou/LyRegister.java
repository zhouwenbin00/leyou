package com.leyou;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Author: zwb
 * @Date: 2019-06-30 23:26
 */

@EnableEurekaServer
@SpringCloudApplication
public class LyRegister {

    public static void main(String[] args) {
        SpringApplication.run(LyRegister.class);
    }
}
