package com.cota.after_corona_api.domain.account.service;

public interface PasswordEncodeService {
    String encodePassword(String password);

    boolean match(String rawPassword, String encodedPassword);
}
