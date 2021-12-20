package com.cota.after_corona_api.domain.account.api.data.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public record UpdateAccountRequest(
        @JsonProperty("name") String name,
        @JsonProperty("password") String password,
        @JsonProperty("phoneNumber") String phoneNumber
) {}
