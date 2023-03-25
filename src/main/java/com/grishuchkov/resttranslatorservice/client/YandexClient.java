package com.grishuchkov.resttranslatorservice.client;

import com.google.gson.Gson;
import com.grishuchkov.resttranslatorservice.dto.RequestToYandex;
import com.grishuchkov.resttranslatorservice.dto.ResponseFromYandex;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component
@RequiredArgsConstructor
public class YandexClient {
    private final Gson gson;
    private final RestTemplate restTemplate;
    private final HttpHeaders headers;

    @Value("${spring.yandex.url}")
    private String URL;

    @Value("${spring.yandex.token}")
    private String TOKEN;


    public ResponseFromYandex translate(RequestToYandex requestToYandex){
        return requestToYandex(requestToYandex);
    }

    private ResponseFromYandex requestToYandex(RequestToYandex requestToYandex){

        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("Authorization", TOKEN);

        String json = gson.toJson(requestToYandex);

        HttpEntity<String> request = new HttpEntity<>(json, headers);

        return restTemplate.postForObject(URL, request, ResponseFromYandex.class);
    }
}
