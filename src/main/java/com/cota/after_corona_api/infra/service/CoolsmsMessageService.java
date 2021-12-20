package com.cota.after_corona_api.infra.service;

import com.cota.after_corona_api.global.property.ApplicationProperty;
import com.cota.after_corona_api.global.property.CoolsmsProperty;
import com.cota.after_corona_api.infra.builder.SmsParameterBuilder;
import com.cota.after_corona_api.infra.exception.SmsException;
import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;

@Service
public class CoolsmsMessageService implements MessageService {
    private final CoolsmsProperty coolsmsProperty;
    private final ApplicationProperty applicationProperty;
    private final Message coolsms;

    public CoolsmsMessageService(CoolsmsProperty coolsmsProperty, ApplicationProperty applicationProperty) {
        this.coolsmsProperty = coolsmsProperty;
        this.applicationProperty = applicationProperty;
        coolsms = new Message(coolsmsProperty.getApiKey(), coolsmsProperty.getApiSecret());
    }

    @Override
    public void sendSms(String phoneNumber, String message) {
        try {
            JSONObject obj = coolsms.send(
                    new SmsParameterBuilder()
                            .to(phoneNumber)
                            .from(coolsmsProperty.getSenderPhoneNumber())
                            .text(coolsmsProperty.getMessagePrefix() + " " + message)
                            .appVersion(applicationProperty.getVersion() + " " + applicationProperty.getName())
                            .build()
            );
            System.out.println(obj.toJSONString());
        } catch (CoolsmsException e) {
            throw new SmsException(e);
        }
        System.out.printf("메세지 송신이 완료되었습니다!\n전화번호 : %s\n메세지 : %s", phoneNumber, coolsmsProperty.getMessagePrefix() + " " + message);
    }
}
