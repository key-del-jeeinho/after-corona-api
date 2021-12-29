package com.cota.after_corona_api.domain.account.login.advice;

import com.cota.after_corona_api.domain.account.exception.AccountNotFoundException;
import com.cota.after_corona_api.domain.account.login.annotation.Login;
import com.cota.after_corona_api.global.error.ErrorCode;
import com.cota.after_corona_api.global.error.ErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(annotations = Login.class)
public class LoginAdvice {
    @ExceptionHandler(AccountNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleException(AccountNotFoundException e) {
        return ResponseEntity.badRequest().body(new ErrorResponse(ErrorCode.ACCOUNT_NOT_FOUND, "id 가 잘못되었습니다!", e.getMessage()));
    }
}
