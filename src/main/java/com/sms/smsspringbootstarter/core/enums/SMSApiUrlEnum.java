package com.sms.smsspringbootstarter.core.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @Description TODO
 * @Author 14571
 * @Date 2019/4/23 10:12
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum SMSApiUrlEnum {
    SENDSMS("https://open.ucpaas.com/ol/sms/sendsms"),
    SENDBATCHSMS("https://open.ucpaas.com/ol/sms/sendsms_batch");

    private String url;
}
