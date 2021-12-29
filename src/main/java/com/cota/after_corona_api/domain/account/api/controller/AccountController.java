package com.cota.after_corona_api.domain.account.api.controller;

import com.cota.after_corona_api.domain.account.api.data.dto.*;
import com.cota.after_corona_api.domain.account.api.data.request.*;
import com.cota.after_corona_api.domain.account.api.data.response.*;
import com.cota.after_corona_api.domain.account.service.AccountService;
import com.cota.after_corona_api.domain.account.service.PasswordEncodeService;
import com.cota.after_corona_api.global.annotation.WithJwtAdvice;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.Random;

@WithJwtAdvice
@RestController
@RequestMapping("/api/v1/account-api")
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;
    private final PasswordEncodeService passwordEncodeService;

    @GetMapping("/account/phone-number/{phone-number}")
    public ResponseEntity<?> isExistAccount(@PathVariable(name = "phone-number") String phoneNumber) {
        boolean exist = accountService.isExistAccount(phoneNumber);
        String[] people = new String[]{"J.K 롤링", "알베르트 아인슈타인", "엠마 왓슨", "아리아나 그란데", "홍길동", "똥철이", "모차르트", "당신의 그녀(혹시 없나요?)"};
        String person = people[new Random().nextInt(people.length)];
        if(exist) return ResponseEntity.status(HttpStatus.CONFLICT).build();
        else return ResponseEntity.ok(person + " 도 감탄할 독창적인 아이디군요!");
    }

    @GetMapping("/account/{id}")
    public ResponseEntity<GetAccountResponse> getAccount(@PathVariable String id) {
        AccountDto data = accountService.getAccount(id);

        GetAccountResponse res = new GetAccountResponse(data.id(), data.name(), data.phoneNumber());
        return ResponseEntity.ok(res);
    }

    @PutMapping("/account/{id}")
    public ResponseEntity<UpdateAccountResponse> updateAccount(@PathVariable String id, @RequestBody UpdateAccountRequest request) {
        String encodedPassword = passwordEncodeService.encodePassword(request.password());
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
