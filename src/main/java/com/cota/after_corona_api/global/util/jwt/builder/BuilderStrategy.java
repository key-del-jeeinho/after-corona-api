package com.cota.after_corona_api.global.util.jwt.builder;


import java.util.Date;
import java.util.function.Function;

public interface BuilderStrategy {
    JwtBuilder getInstance(Function<Date, Date> expiration);
}