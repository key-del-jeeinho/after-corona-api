package com.cota.after_corona_api.domain.account.register.service;

import com.cota.after_corona_api.domain.account.register.data.dto.RawAccountDto;
import com.cota.after_corona_api.domain.account.service.PasswordEncodeService;
import com.cota.after_corona_api.global.service.ShortUrlService;
import com.cota.after_corona_api.infra.service.MessageService;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.stereotype.Service;

@Service
public class ShortUrlAuthorizeService extends AuthorizeServiceImpl {
    private final ShortUrlService shortUrlService;
    public ShortUrlAuthorizeService(ServerProperties serverProperties, MessageService messageService, ShortUrlService shortUrlService, PasswordEncodeService passwordEncodeService) {
        super(serverProperties, messageService, passwordEncodeService);
        this.shortUrlService = shortUrlService;
    }

    @Override
    public String generateAuthorizeLink(RawAccountDto rawAccountDto, long linkDuration, String callbackUrl) {
        String originUrl = super.generateAuthorizeLink(rawAccountDto, linkDuration, callbackUrl);
        return shortUrlService.convertToShortUrl(originUrl);
    }
}
