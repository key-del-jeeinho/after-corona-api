package com.cota.after_corona_api.domain.account.exception;

public class DuplicateAccountException extends RuntimeException {
    private final String id;

    public DuplicateAccountException(String id) {
        super("이미 존재하는 계정입니다.\n계정 아이디: " + id);
        this.id = id;
    }
}
