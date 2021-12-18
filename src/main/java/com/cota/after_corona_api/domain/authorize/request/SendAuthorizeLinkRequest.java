package com.cota.after_corona_api.domain.authorize.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.net.URI;

public record SendAuthorizeLinkRequest(
        @JsonProperty("id") String id,
        @JsonProperty("name") String name,
        @JsonProperty("password") String rawPassword,
        @JsonProperty("phoneNumber") String phoneNumber,
        @JsonProperty("duration") long linkDuration,
        @JsonProperty("callbackUrl") URI callbackUrl
) {}
