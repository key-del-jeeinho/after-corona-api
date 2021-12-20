package com.cota.after_corona_api.global.service;

import com.cota.after_corona_api.global.data.response.ShortUrlResponse;
import com.cota.after_corona_api.global.property.NaverApiProperty;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class NaverShortUrlService implements ShortUrlService{
    private static final String API_URL = "https://openapi.naver.com/v1/util/shorturl";

    private final WebClient client;
    public NaverShortUrlService(NaverApiProperty naverApiProperty) {
        client = WebClient.builder()
                .baseUrl(API_URL)
                .defaultHeaders(headers -> {
                    headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
                    headers.add("X-Naver-Client-Id", naverApiProperty.getClientId());
                    headers.add("X-Naver-Client-Secret", naverApiProperty.getClientSecret());
                }).build();
    }

    @Override
    public String convertToShortUrl(String url) {
        ShortUrlResponse response = client.get()
                .uri(uriBuilder -> uriBuilder.queryParam("url", url).build())
                .retrieve()
                .bodyToMono(ShortUrlResponse.class)
                .block();
        assert response != null;
        return response.getResult().getShortUrl();
    }
}
