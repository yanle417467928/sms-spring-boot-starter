package com.sms.smsspringbootstarter.core.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Description TODO
 * @Author 14571
 * @Date 2019/4/23 10:19
 */
@Data
@ConfigurationProperties(prefix = "sms-config")
public class SmsProperties {
    private String appId;
    private String accountSid;
    private String authToken;
}
