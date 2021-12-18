package com.cota.after_corona_api.domain.account.policy;


import com.cota.after_corona_api.domain.account.data.dto.AccountDto;

public interface AccountPolicy {
  void validateCreatePolicy(AccountDto account);

  void validateUpdatePolicy(AccountDto account);

  void validateDeletePolicy(String id);
}
