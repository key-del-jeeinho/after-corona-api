package com.cota.after_corona_api.domain.account.service;

import com.cota.after_corona_api.domain.account.data.dto.RawAccountDto;

public interface RegisterService {
    RawAccountDto decodeToken(String token);

    String encodePassword(String password);
}
