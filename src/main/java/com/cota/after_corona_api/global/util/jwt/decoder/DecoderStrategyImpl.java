package com.cota.after_corona_api.global.util.jwt.decoder;

import com.cota.after_corona_api.global.property.JwtProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component //static 변수들을 spring boot property 로 초기화 하기 위해 사용한다.
public class DecoderStrategyImpl implements DecoderStrategy {
    private static String secret = "secret";//default value

    @Autowired
    private JwtProperty jwtProperty;

    @PostConstruct //jwt property 를 통해 secret, issuer 를 초기화한다.
    private void init() {
        secret = jwtProperty.getSecret();
    }

    @Override
    public JwtDecoder getInstance(String token) {
        return new JwtDecoder(token, secret);
    }
}
