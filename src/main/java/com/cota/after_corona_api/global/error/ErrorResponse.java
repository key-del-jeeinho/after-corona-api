package com.cota.after_corona_api.global.error;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ErrorResponse(
        @JsonProperty("code") ErrorCode code,
        @JsonProperty("message") String message,
        @JsonProperty("details") String details
) {}
