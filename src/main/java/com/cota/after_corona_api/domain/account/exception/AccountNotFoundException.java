package com.cota.after_corona_api.domain.account.exception;

public class AccountNotFoundException extends RuntimeException {
    private final String id;

    public AccountNotFoundException(String id) {
        super("계정의 아이디를 찾을 수 없습니다!\n계정 아이디: " + id);
        this.id = id;
    }
}
