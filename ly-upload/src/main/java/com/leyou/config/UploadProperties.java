package com.leyou.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

/**
 * @Author: zwb
 * @Date: 2019-07-02 19:57
 */

@Data
@ConfigurationProperties(prefix = "ly.upload")
public class UploadProperties {

    private String basrUrl;
    private List<String> allowsTypes;

}
