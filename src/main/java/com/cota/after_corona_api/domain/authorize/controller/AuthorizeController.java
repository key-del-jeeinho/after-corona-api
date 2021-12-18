package com.cota.after_corona_api.domain.authorize.controller;

import com.cota.after_corona_api.domain.authorize.data.dto.RawAccountDto;
import com.cota.after_corona_api.domain.authorize.request.SendAuthorizeLinkRequest;
import com.cota.after_corona_api.domain.authorize.service.AuthorizeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthorizeController {
    private final AuthorizeService authorizeService;

    @PostMapping
    public ResponseEntity<?> sendAuthorizeLink(@RequestBody SendAuthorizeLinkRequest request) {
        RawAccountDto rawAccountDto = new RawAccountDto(request.id(), request.name(), request.rawPassword(), request.phoneNumber());
        String link = authorizeService.generateAuthorizeLink(rawAccountDto, request.linkDuration(), request.callbackUrl());
        authorizeService.sendAuthorizeLink(link);

        return ResponseEntity.noContent().build();
    }
}
