package com.cota.after_corona_api.domain.account.service;

import com.cota.after_corona_api.domain.account.data.dto.AccountDto;

public interface AccountService {
    AccountDto createAccount(AccountDto account);

    AccountDto getAccount(String id);

    AccountDto updateAccount(String id, AccountDto account);

    void deleteAccount(String id);
}