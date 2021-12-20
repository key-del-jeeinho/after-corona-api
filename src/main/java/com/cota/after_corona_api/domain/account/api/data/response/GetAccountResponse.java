package com.cota.after_corona_api.domain.account.api.data.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public record GetAccountResponse(
        @JsonProperty("id") String id,
        @JsonProperty("name") String name,
        @JsonProperty("phoneNumber") String phoneNumber
) {}
