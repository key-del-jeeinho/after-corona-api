package com.cota.after_corona_api.domain.account.register.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public record SendAuthorizeLinkRequest(
        @JsonProperty("id") String id,
        @JsonProperty("name") String name,
        @JsonProperty("password") String rawPassword,
        @JsonProperty("phoneNumber") String phoneNumber,
        @JsonProperty("duration") long linkDuration,
        @JsonProperty("callbackUrl") String callbackUrl
) {}
