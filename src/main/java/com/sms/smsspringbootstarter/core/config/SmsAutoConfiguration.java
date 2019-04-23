package com.sms.smsspringbootstarter.core.config;

import com.sms.smsspringbootstarter.foundation.service.SmsService;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description TODO
 * @Author 14571
 * @Date 2019/4/23 10:25
 */
@Configuration
@EnableConfigurationProperties(SmsProperties.class)
public class SmsAutoConfiguration {

    @Bean
    public SmsService getBean(SmsProperties smsProperties) {
        return new SmsService(smsProperties);
    }
}
