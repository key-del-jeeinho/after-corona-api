package com.cota.after_corona_api.global.util;
import com.cota.after_corona_api.global.util.jwt.builder.BuilderStrategy;
import com.cota.after_corona_api.global.util.jwt.builder.BuilderStrategyImpl;
import com.cota.after_corona_api.global.util.jwt.builder.JwtBuilder;
import com.cota.after_corona_api.global.util.jwt.decoder.DecoderStrategy;
import com.cota.after_corona_api.global.util.jwt.decoder.DecoderStrategyImpl;
import com.cota.after_corona_api.global.util.jwt.decoder.JwtDecoder;
import lombok.Setter;

import java.util.Date;
import java.util.function.Function;

public class JwtUtil {
    @Setter
    private static BuilderStrategy builderStrategy = new BuilderStrategyImpl(); //default strategy
    @Setter
    private static DecoderStrategy decoderStrategy = new DecoderStrategyImpl(); //default strategy

    public static JwtBuilder getBuilder(Function<Date, Date> expiration) {
        return builderStrategy.getInstance(expiration);
    }

    public static JwtDecoder getDecoder(String token) {
        return decoderStrategy.getInstance(token);
    }
}
