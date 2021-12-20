package com.cota.after_corona_api.domain.account.api.data.entity;

import com.cota.after_corona_api.domain.account.api.data.dto.AccountDto;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "account")
@Getter @Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AccountEntity {
    @Id
    private String id;
    private String name;
    private String encodedPassword;
    private String phoneNumber;

    public static AccountEntity of(AccountDto account) {
        return AccountEntity.builder()
                .id(account.id())
                .name(account.name())
                .encodedPassword(account.encodedPassword())
                .phoneNumber(account.phoneNumber())
                .build();
    }

    public AccountDto toDto() {
        return new AccountDto(id, name, encodedPassword, phoneNumber);
    }
}
