package com.cota.after_corona_api.global.util.jwt.builder;

import com.cota.after_corona_api.global.property.JwtProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.function.Function;

@Component //static 변수들을 spring boot property 로 초기화 하기 위해 사용한다.
public class BuilderStrategyImpl implements BuilderStrategy {
    private static String secret = "secret"; //default value
    private static String issuer = "issuer"; //default value

    @Autowired
    private JwtProperty jwtProperty;

    @PostConstruct //jwt property 를 통해 secret, issuer 를 초기화한다.
    private void init() {
        secret = jwtProperty.getSecret();
        issuer = jwtProperty.getIssuer();
    }

    @Override
    public JwtBuilder getInstance(Function<Date, Date> expiration) {
        return new JwtBuilder(expiration, secret, issuer);
    }
}