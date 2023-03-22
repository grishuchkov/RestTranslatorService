package com.grishuchkov.resttranslatorservice.service;

import com.grishuchkov.resttranslatorservice.client.TestClient;
import com.grishuchkov.resttranslatorservice.dto.RequestDTO;
import com.grishuchkov.resttranslatorservice.dto.ResponseDTO;
import com.grishuchkov.resttranslatorservice.dto.ResponseFromYandex;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class TranslateService {
    private final TestClient testClient;
    private final ResponseDTO responseDTO;

    public ResponseDTO getTranslateFromYandex(RequestDTO requestDTO){

        ResponseFromYandex responseFromYandex = testClient.translator(requestDTO);

        responseDTO.setTranslatedText(responseFromYandex.getTranslations().get(0).getText());
       return responseDTO;
    }
}

