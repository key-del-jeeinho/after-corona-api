package com.cota.after_corona_api.domain.account.register.service;

import com.cota.after_corona_api.domain.account.api.data.dto.AccountDto;
import com.cota.after_corona_api.domain.account.register.data.dto.RawAccountDto;

public interface AuthorizeService {
    String generateAuthorizeLink(RawAccountDto rawAccountDto, long linkDuration, String callbackUrl);

    void sendAuthorizeLink(String link, String phoneNumber);

    String getCallbackUrlByToken(String token);

    AccountDto getAccountByToken(String token);
}
