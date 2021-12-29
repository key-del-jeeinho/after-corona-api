package com.cota.after_corona_api.domain.account.login.data.request;

public record LoginRequest(
        String id,
        String rawPassword
) {}
