package com.cota.after_corona_api.domain.account.data.dto;

public record RawAccountDto(
        String id,
        String name,
        String rawPassword,
        String phoneNumber
) {}
