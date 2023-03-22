package com.grishuchkov.resttranslatorservice.client;

import com.grishuchkov.resttranslatorservice.dto.RequestDTO;
import com.grishuchkov.resttranslatorservice.dto.ResponseFromYandex;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class TestClient {

    public ResponseFromYandex translator(RequestDTO requestDTO){
        String url = "https://translate.api.cloud.yandex.net/translate/v2/translate";
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();

        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("Authorization", "Api-Key AQVNyjKkGZaGRfXIkQVZymFY6QJVCvfCHjgB-IiI");

        Map<String, String> jsonData = new HashMap<>();
        jsonData.put("sourceLanguageCode",requestDTO.getLanguageFrom());
        jsonData.put("targetLanguageCode",requestDTO.getLanguageTo());
        jsonData.put("texts",requestDTO.getText());

        HttpEntity<Map<String, String>> request = new HttpEntity<>(jsonData, headers);

        return restTemplate.postForObject(url, request, ResponseFromYandex.class);
    }
}
