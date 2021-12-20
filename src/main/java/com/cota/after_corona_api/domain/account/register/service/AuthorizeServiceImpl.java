package com.cota.after_corona_api.domain.account.register.service;

import com.cota.after_corona_api.domain.account.api.data.dto.AccountDto;
import com.cota.after_corona_api.domain.account.register.data.dto.RawAccountDto;
import com.cota.after_corona_api.domain.account.service.PasswordEncodeService;
import com.cota.after_corona_api.global.util.JwtUtil;
import com.cota.after_corona_api.global.util.jwt.builder.SimpleDurationExpiration;
import com.cota.after_corona_api.global.util.jwt.decoder.JwtDecoder;
import com.cota.after_corona_api.infra.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.web.ServerProperties;

@RequiredArgsConstructor
public class AuthorizeServiceImpl implements AuthorizeService {
    private final ServerProperties serverProperties;
    private final MessageService messageService;
    private final PasswordEncodeService passwordEncodeService;

    @Override
    public String generateAuthorizeLink(RawAccountDto rawAccountDto, long linkDuration, String callbackUrl) {
        String token = JwtUtil.getBuilder(new SimpleDurationExpiration(linkDuration))
                .addClaim("id", rawAccountDto.id())
                .addClaim("name", rawAccountDto.name())
                .addClaim("rawPassword", rawAccountDto.rawPassword())
                .addClaim("callbackUrl", callbackUrl)
                .addClaim("phoneNumber", rawAccountDto.phoneNumber())
                .build();
        String baseUrl = "http:/" + serverProperties.getAddress() + ":" + serverProperties.getPort();
        return baseUrl + "/register?token=" + token;
    }

    @Override
    public void sendAuthorizeLink(String link, String phoneNumber) {
        String message = "아래 링크를 클릭하여 인증하세요.\n" + link;
        messageService.sendSms(phoneNumber, message);
    }

    @Override
    public String getCallbackUrlByToken(String token) {
        JwtDecoder decoder = JwtUtil.getDecoder(token);

        return decoder.get("callbackUrl", String.class);
    }

    @Override
    public AccountDto getAccountByToken(String token) {
        JwtDecoder decoder = JwtUtil.getDecoder(token);

        String encodedPassword = passwordEncodeService.encodePassword(decoder.get("rawPassword", String.class));

        return new AccountDto(
                decoder.get("id", String.class),
                decoder.get("name", String.class),
                encodedPassword,
                decoder.get("phoneNumber", String.class)
        );
    }
}
