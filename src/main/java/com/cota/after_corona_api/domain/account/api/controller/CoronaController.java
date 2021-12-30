package com.cota.after_corona_api.domain.account.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/api/v1/corona")
public class CoronaController {
    boolean isCoronaEnd = false;

    @GetMapping
    public ResponseEntity<?> isCoronaEnd() {
        if(isCoronaEnd) return ResponseEntity.ok().build();
        else return ResponseEntity.badRequest().build();
    }

    @PostMapping
    public ResponseEntity<?> setCoronaEnd(@RequestParam boolean isCoronaEnd) {
        this.isCoronaEnd = isCoronaEnd;
        return ResponseEntity.ok().build();
    }
}
