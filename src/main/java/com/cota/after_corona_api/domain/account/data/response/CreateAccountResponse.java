package com.cota.after_corona_api.domain.account.data.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CreateAccountResponse(
        @JsonProperty("id") String id,
        @JsonProperty("name") String name,
        @JsonProperty("phoneNumber") String phoneNumber
) {}
