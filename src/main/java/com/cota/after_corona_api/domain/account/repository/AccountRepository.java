package com.cota.after_corona_api.domain.account.repository;

import com.cota.after_corona_api.domain.account.data.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<AccountEntity, String> {
    boolean existsById(String id);
}
