package com.cota.after_corona_api.domain.account.register.controller;

import com.cota.after_corona_api.domain.account.register.data.dto.RawAccountDto;
import com.cota.after_corona_api.domain.account.register.request.SendAuthorizeLinkRequest;
import com.cota.after_corona_api.domain.account.register.service.AuthorizeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/register-api")
public class RegisterController {
    private final AuthorizeService authorizeService;

    @PostMapping("/register")
    public ResponseEntity<?> sendAuthorizeLink(@RequestBody SendAuthorizeLinkRequest request) {
        RawAccountDto rawAccountDto = new RawAccountDto(request.id(), request.name(), request.rawPassword(), request.phoneNumber());
        String link = authorizeService.generateAuthorizeLink(rawAccountDto, request.linkDuration(), request.callbackUrl());
        //authorizeService.sendAuthorizeLink(link, rawAccountDto.phoneNumber());

        return ResponseEntity.ok(link);
    }
}
