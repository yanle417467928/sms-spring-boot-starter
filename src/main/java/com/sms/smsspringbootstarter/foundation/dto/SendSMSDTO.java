package com.sms.smsspringbootstarter.foundation.dto;

import lombok.Data;

/**
 * @Description 消息参数
 * @Author 14571
 * @Date 2019/4/23 10:04
 */
@Data
public class SendSMSDTO {

    /**
     * 模板ID
     */
    private String templateId;
    /**
     * 参数
     */
    private String param;
    /**
     * 手机号
     */
    private String mobile;
    /**
     * 用户穿透ID，可以为空
     */
    private String uid;

}
