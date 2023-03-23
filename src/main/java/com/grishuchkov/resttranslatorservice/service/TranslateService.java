package com.grishuchkov.resttranslatorservice.service;

import com.grishuchkov.resttranslatorservice.client.YandexClient;
import com.grishuchkov.resttranslatorservice.dto.RequestDTO;
import com.grishuchkov.resttranslatorservice.dto.RequestToYandex;
import com.grishuchkov.resttranslatorservice.dto.ResponseDTO;
import com.grishuchkov.resttranslatorservice.dto.ResponseFromYandex;
import com.grishuchkov.resttranslatorservice.utils.Parser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class TranslateService {
    private final YandexClient yandexClient;
    private final ResponseDTO responseDTO;
    private final Parser parser;
    private final RequestToYandex requestToYandex;

    public ResponseDTO getTranslateFromYandex(RequestDTO requestDTO){

        String[] wordsArray = parser.stringToList(requestDTO.getText());

        requestToYandex.setSourceLanguageCode(requestDTO.getLanguageFrom());
        requestToYandex.setTargetLanguageCode(requestDTO.getLanguageTo());
        requestToYandex.setTexts(wordsArray);

        ResponseFromYandex responseFromYandex = yandexClient.translator(requestToYandex);

        responseDTO.setTranslatedText(parser.responseFromYandexToString(responseFromYandex));

        return responseDTO;
    }
}

