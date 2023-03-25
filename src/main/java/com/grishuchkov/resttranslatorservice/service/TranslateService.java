package com.grishuchkov.resttranslatorservice.service;

import com.grishuchkov.resttranslatorservice.client.YandexClient;
import com.grishuchkov.resttranslatorservice.dto.*;
import com.grishuchkov.resttranslatorservice.repo.YandexRepository;
import com.grishuchkov.resttranslatorservice.utils.Parser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class TranslateService {
    private final YandexClient yandexClient;
    private final ResponseToUserDTO responseToUserDTO;
    private final Parser parser;
    private final RequestToYandex requestToYandex;
    private final RequestToRepository requestToRepository;
    private final YandexRepository yandexRepository;
    private ResponseFromYandex responseFromYandex;

    public ResponseToUserDTO getTranslateFromYandex(RequestFromUserDTO requestFromUserDTO, String userIp){

        String[] wordsArray = parser.stringToArray(requestFromUserDTO.getText());

        requestToYandex.setFields(requestFromUserDTO.getLanguageFrom(),
                                    requestFromUserDTO.getLanguageTo(),
                                    wordsArray);

        responseFromYandex = yandexClient.translate(requestToYandex);

        String[] translatedWordsArray = parser.responseFromYandexToStringArray(responseFromYandex);
        String translatedText = parser.responseFromYandexToString(responseFromYandex);

        requestToRepository.setFields(requestFromUserDTO.getText(),
                                        translatedText,
                                        requestFromUserDTO.getLanguageFrom(),
                                        requestFromUserDTO.getLanguageTo(),
                                        userIp,
                                        wordsArray,
                                        translatedWordsArray);

        yandexRepository.save(requestToRepository);

        responseToUserDTO.setTranslatedText(translatedText);

        return responseToUserDTO;
    }
}

