package com.cota.after_corona_api.domain.account.controller;

import com.cota.after_corona_api.domain.account.data.dto.*;
import com.cota.after_corona_api.domain.account.data.request.*;
import com.cota.after_corona_api.domain.account.data.response.*;
import com.cota.after_corona_api.domain.account.service.AccountService;
import com.cota.after_corona_api.domain.account.service.RegisterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/account-api")
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;
    private final RegisterService registerService;

    @PostMapping("/account")
    public ResponseEntity<CreateAccountResponse> addAccount(@RequestBody CreateAccountRequest request) {
        RawAccountDto rawAccount = registerService.decodeToken(request.token());
        String encodedPassword = registerService.encodePassword(rawAccount.rawPassword());

        AccountDto account = accountService.createAccount(
                new AccountDto(rawAccount.id(), rawAccount.name(), encodedPassword, rawAccount.phoneNumber())
        );

        CreateAccountResponse res = new CreateAccountResponse(account.id(), account.name(), account.phoneNumber());
        return ResponseEntity.ok(res);
    }

    @GetMapping("/account/{id}")
    public ResponseEntity<GetAccountResponse> getAccount(@PathVariable String id) {
        AccountDto data = accountService.getAccount(id);

        GetAccountResponse res = new GetAccountResponse(data.id(), data.name(), data.phoneNumber());
        return ResponseEntity.ok(res);
    }

    @PutMapping("/account/{id}")
    public ResponseEntity<UpdateAccountResponse> updateAccount(@PathVariable String id, @RequestBody UpdateAccountRequest request) {
        String encodedPassword = registerService.encodePassword(request.password());
        AccountDto account = new AccountDto(id, request.name(), encodedPassword, request.phoneNumber());

        AccountDto data = accountService.updateAccount(id, account);

        UpdateAccountResponse res = new UpdateAccountResponse(data.id(), data.name(), data.phoneNumber());
        return ResponseEntity.ok(res);
    }

    @DeleteMapping("/account/{id}")
    public ResponseEntity<?> deleteAccount(@PathVariable String id) {
        accountService.deleteAccount(id);

        return ResponseEntity.noContent().build();
    }
}
