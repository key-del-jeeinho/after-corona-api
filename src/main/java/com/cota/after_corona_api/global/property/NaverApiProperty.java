package com.cota.after_corona_api.global.property;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "naver-api")
@Getter
@Setter
public class NaverApiProperty {
    private String clientId;
    private String clientSecret;
}
