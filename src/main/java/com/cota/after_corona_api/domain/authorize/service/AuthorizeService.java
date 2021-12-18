package com.cota.after_corona_api.domain.authorize.service;

import com.cota.after_corona_api.domain.authorize.data.dto.RawAccountDto;

import java.net.URI;

public interface AuthorizeService {
    String generateAuthorizeLink(RawAccountDto rawAccountDto, long linkDuration, URI callbackUrl);

    void sendAuthorizeLink(String link);
}
