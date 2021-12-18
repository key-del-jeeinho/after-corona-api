package com.cota.after_corona_api.domain.account.policy;

import com.cota.after_corona_api.domain.account.data.dto.AccountDto;
import com.cota.after_corona_api.domain.account.exception.AccountNotFoundException;
import com.cota.after_corona_api.domain.account.exception.DuplicateAccountException;
import com.cota.after_corona_api.domain.account.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StandardAccountPolicy implements AccountPolicy {
    private final AccountRepository accountRepository;

    @Override
    public void validateCreatePolicy(AccountDto account) {
        if(accountRepository.existsById(account.id()))
            throw new DuplicateAccountException(account.id());
    }

    @Override
    public void validateUpdatePolicy(AccountDto account) {
        if(!accountRepository.existsById(account.id()))
            throw new AccountNotFoundException(account.id());
    }

    @Override
    public void validateDeletePolicy(String id) {
        if(!accountRepository.existsById(id))
            throw new AccountNotFoundException(id);
    }
}
