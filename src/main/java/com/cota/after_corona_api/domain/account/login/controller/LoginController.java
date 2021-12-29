package com.cota.after_corona_api.domain.account.login.controller;

import com.cota.after_corona_api.domain.account.api.data.dto.AccountDto;
import com.cota.after_corona_api.domain.account.login.annotation.Login;
import com.cota.after_corona_api.domain.account.login.data.request.LoginRequest;
import com.cota.after_corona_api.domain.account.service.AccountService;
import com.cota.after_corona_api.domain.account.service.PasswordEncodeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/login-api/login")
@RequiredArgsConstructor
@Login
public class LoginController {
    private final AccountService accountService;
    private final PasswordEncodeService passwordEncodeService;

    @PostMapping
    public ResponseEntity<AccountDto> login(@RequestBody LoginRequest request) {
        if(passwordEncodeService.match(request.rawPassword(), accountService.getAccount(request.id()).encodedPassword()))
            return ResponseEntity.ok(accountService.getAccount(request.id()));
        else return ResponseEntity.badRequest().build();
    }
}
