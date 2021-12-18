package com.cota.after_corona_api.domain.account.service;

import com.cota.after_corona_api.domain.account.data.dto.AccountDto;
import com.cota.after_corona_api.domain.account.data.entity.AccountEntity;
import com.cota.after_corona_api.domain.account.policy.AccountPolicy;
import com.cota.after_corona_api.domain.account.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;
    private final AccountPolicy accountPolicy;

    @Override
    public AccountDto createAccount(AccountDto account) {
        accountPolicy.validateCreatePolicy(account);

        AccountEntity data = AccountEntity.of(account);
        data = accountRepository.save(data);

        return data.toDto();
    }

    @Override
    public AccountDto getAccount(String id) {
        AccountEntity data = accountRepository.getById(id);
        return data.toDto();
    }

    @Override
    public AccountDto updateAccount(String id, AccountDto account) {
        accountPolicy.validateUpdatePolicy(account);

        AccountEntity data = AccountEntity.of(account);
        data = accountRepository.save(data);

        return data.toDto();
    }

    @Override
    public void deleteAccount(String id) {
        accountPolicy.validateDeletePolicy(id);

        accountRepository.deleteById(id);
    }
}
