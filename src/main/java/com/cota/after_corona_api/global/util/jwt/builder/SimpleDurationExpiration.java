package com.cota.after_corona_api.global.util.jwt.builder;

import java.util.Date;
import java.util.function.Function;

public record SimpleDurationExpiration(long duration) implements Function<Date, Date> {
    @Override
    public Date apply(Date date) {
        return new Date(date.getTime() + duration);
    }
}
