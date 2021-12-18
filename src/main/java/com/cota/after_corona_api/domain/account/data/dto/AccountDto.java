package com.cota.after_corona_api.domain.account.data.dto;

public record AccountDto(
        String id,
        String name,
        String encodedPassword,
        String phoneNumber
) {}
