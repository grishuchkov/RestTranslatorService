package com.grishuchkov.resttranslatorservice.client;

import com.google.gson.Gson;
import com.grishuchkov.resttranslatorservice.dto.RequestToYandexDTO;
import com.grishuchkov.resttranslatorservice.dto.ResponseFromYandexDTO;
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

    @Value("${spring.yandex.url}")
    private String URL;

    @Value("${spring.yandex.token}")
    private String TOKEN;

    public ResponseFromYandexDTO translate(RequestToYandexDTO requestToYandexDTO){
        return requestToYandex(requestToYandexDTO);
    }

    private ResponseFromYandexDTO requestToYandex(RequestToYandexDTO requestToYandexDTO){

        HttpHeaders headers = new HttpHeaders();
        RestTemplate restTemplate = new RestTemplate();

        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("Authorization", TOKEN);

        String json = gson.toJson(requestToYandexDTO);

        HttpEntity<String> request = new HttpEntity<>(json, headers);

        return restTemplate.postForObject(URL, request, ResponseFromYandexDTO.class);
    }
}
