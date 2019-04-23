package com.sms.smsspringbootstarter.foundation.service;

import com.alibaba.fastjson.JSONObject;
import com.sms.smsspringbootstarter.core.config.SmsProperties;
import com.sms.smsspringbootstarter.core.enums.SMSApiUrlEnum;
import com.sms.smsspringbootstarter.foundation.dto.SendSMSDTO;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Description TODO
 * @Author 14571
 * @Date 2019/4/23 10:15
 */
public class SmsService {

    @Resource
    private RestTemplate restTemplate;

    private String appId;
    private String accountSid;
    private String authToken;

    /**
     * 初始化
     */
    public SmsService(SmsProperties smsProperties) {
        this.appId = smsProperties.getAppId();
        this.accountSid = smsProperties.getAccountSid();
        this.authToken = smsProperties.getAuthToken();
    }

    /**
     * 单独发送
     */
    public String sendSMS(SendSMSDTO sendSMSDTO) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("sid", accountSid);
        jsonObject.put("token", authToken);
        jsonObject.put("appId", appId);
        jsonObject.put("templateid", sendSMSDTO.getTemplateId());
        jsonObject.put("param", sendSMSDTO.getParam());
        jsonObject.put("mobile", sendSMSDTO.getMobile());
        if (sendSMSDTO.getUid() != null) {
            jsonObject.put("uid", sendSMSDTO.getUid());
        } else {
            jsonObject.put("uid", "");
        }
        String json = JSONObject.toJSONString(jsonObject);
        //使用restTemplate进行访问远程Http服务
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        HttpEntity<String> httpEntity = new HttpEntity<String>(json, headers);
        return restTemplate.postForObject(SMSApiUrlEnum.SENDSMS.getUrl(), httpEntity, String.class);
    }

    /**
     * 群体发送
     */
    public String sendBatchSMS(SendSMSDTO sendSMSDTO) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("sid", accountSid);
        jsonObject.put("token", authToken);
        jsonObject.put("appId", appId);
        jsonObject.put("templateid", sendSMSDTO.getTemplateId());
        jsonObject.put("param", sendSMSDTO.getParam());
        jsonObject.put("mobile", sendSMSDTO.getMobile());
        if (sendSMSDTO.getUid() != null) {
            jsonObject.put("uid", sendSMSDTO.getUid());
        } else {
            jsonObject.put("uid", "");
        }
        String json = JSONObject.toJSONString(jsonObject);
        //使用restTemplate进行访问远程Http服务
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        HttpEntity<String> httpEntity = new HttpEntity<String>(json, headers);
        return restTemplate.postForObject(SMSApiUrlEnum.SENDBATCHSMS.getUrl(), httpEntity, String.class);
    }


}
