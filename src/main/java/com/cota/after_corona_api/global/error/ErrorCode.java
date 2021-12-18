package com.cota.after_corona_api.global.error;

public enum ErrorCode {
    //잘못된 요청으로 인하여 발생하는 오류
    DUPLICATE_ACCOUNT, ACCOUNT_NOT_FOUND,
    JWT_TOKEN_NOT_FOUND, WRONG_SIGNATURE_JWT, EXPIRED_JWT_TOKEN, MALFORMED_JWT, UNSUPPORTED_JWT
}
