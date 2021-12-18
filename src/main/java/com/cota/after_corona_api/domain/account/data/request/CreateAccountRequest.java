package com.cota.after_corona_api.domain.account.data.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CreateAccountRequest(
        @JsonProperty("token") String token
) {}
