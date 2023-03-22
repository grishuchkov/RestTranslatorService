package com.grishuchkov.resttranslatorservice.service;


import com.grishuchkov.resttranslatorservice.client.YandexClient;
import com.grishuchkov.resttranslatorservice.dto.RequestDTO;
import com.grishuchkov.resttranslatorservice.dto.ResponseDTO;
import com.grishuchkov.resttranslatorservice.dto.ResponseFromYandex;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TranslateService {
    private final YandexClient yandexClient;

    public ResponseDTO getTranslateFromYandex(RequestDTO requestDTO){

    }

    public List<ResponseFromYandex> getTranslateFromYandexClient(){
        String json = yandexClient.translations();

    }
}
