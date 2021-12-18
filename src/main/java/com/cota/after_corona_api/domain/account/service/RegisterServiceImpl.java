package com.cota.after_corona_api.domain.account.service;

import com.cota.after_corona_api.domain.account.data.dto.RawAccountDto;
import com.cota.after_corona_api.global.util.JwtUtil;
import com.cota.after_corona_api.global.util.jwt.decoder.JwtDecoder;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegisterServiceImpl implements RegisterService {
    private final PasswordEncoder passwordEncoder;

    @Override
    public RawAccountDto decodeToken(String token) {
        JwtDecoder decoder = JwtUtil.getDecoder(token);

        String id = decoder.get("id", String.class);
        String password = decoder.get("password", String.class);
        String name = decoder.get("name", String.class);
        String phoneNumber = decoder.get("phoneNumber", String.class);

        return new RawAccountDto(id, password, name, phoneNumber);
    }

    @Override
    public String encodePassword(String password) {
        return passwordEncoder.encode(password);
    }

}
