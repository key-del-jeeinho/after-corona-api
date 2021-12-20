package com.cota.after_corona_api.domain.account.register.controller;

import com.cota.after_corona_api.domain.account.api.data.dto.AccountDto;
import com.cota.after_corona_api.domain.account.register.annotation.Register;
import com.cota.after_corona_api.domain.account.service.AccountService;
import com.cota.after_corona_api.domain.account.register.service.AuthorizeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/register")
@RequiredArgsConstructor
@Register
public class RegisterCallbackController {
    private final AuthorizeService authorizeService;
    private final AccountService accountService;

    @GetMapping
    public String authorizeCallback(@RequestParam String token) {
        AccountDto account = authorizeService.getAccountByToken(token);
        accountService.createAccount(account);

        return "redirect:" + authorizeService.getCallbackUrlByToken(token);
    }
}