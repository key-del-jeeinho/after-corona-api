package com.cota.after_corona_api.domain.account.service;

import com.cota.after_corona_api.domain.account.data.dto.AccountDto;

public interface RegisterService {
    AccountDto decodeToken(String token);

    String encodePassword(String password);
}
