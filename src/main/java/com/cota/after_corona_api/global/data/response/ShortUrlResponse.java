package com.cota.after_corona_api.global.data.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@NoArgsConstructor
@Builder
@AllArgsConstructor
@Getter @Setter
public final class ShortUrlResponse {
    @JsonProperty("result")
    private ShortUrlResult result;
    @JsonProperty("message")
    private String message;
    @JsonProperty("code")
    private String code;

    @NoArgsConstructor
    @Builder
    @AllArgsConstructor
    @Getter
    @Setter
    public static final class ShortUrlResult {
        @JsonProperty("url")
        private String shortUrl;
        @JsonProperty("hash")
        private String hash;
        @JsonProperty("orgUrl")
        private String originUrl;
    }
}
