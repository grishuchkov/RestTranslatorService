package com.grishuchkov.resttranslatorservice.client;

import com.google.gson.Gson;
import com.grishuchkov.resttranslatorservice.dto.RequestToYandex;
import com.grishuchkov.resttranslatorservice.dto.ResponseFromYandex;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component
@RequiredArgsConstructor
public class YandexClient {
    private final Gson gson;

    public ResponseFromYandex translator(RequestToYandex requestToYandex){

        String url = "https://translate.api.cloud.yandex.net/translate/v2/translate";
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("Authorization", "Api-Key AQVNyjKkGZaGRfXIkQVZymFY6QJVCvfCHjgB-IiI");

        String json = gson.toJson(requestToYandex);

        HttpEntity<String> request = new HttpEntity<>(json, headers);

        return restTemplate.postForObject(url, request, ResponseFromYandex.class);
    }
}
