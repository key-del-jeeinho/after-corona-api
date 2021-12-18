package com.cota.after_corona_api.global.util.jwt.decoder;

public interface DecoderStrategy {
    JwtDecoder getInstance(String token);
}
