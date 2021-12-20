package com.cota.after_corona_api.domain.account.register.advice;

import com.cota.after_corona_api.domain.account.exception.DuplicateAccountException;
import com.cota.after_corona_api.domain.account.register.annotation.Register;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice(annotations = Register.class)
public class RegisterAdvice {
    @ExceptionHandler(DuplicateAccountException.class)
    public String handleException(DuplicateAccountException e) {
        return "error/duplicate-account";
    }
}
