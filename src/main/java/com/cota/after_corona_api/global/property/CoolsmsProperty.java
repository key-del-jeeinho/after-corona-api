package com.cota.after_corona_api.global.property;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "cool-sms")
@Getter
@Setter
public class CoolsmsProperty {
    private String apiKey;
    private String apiSecret;
    private String senderPhoneNumber;
    private String messagePrefix;
}
