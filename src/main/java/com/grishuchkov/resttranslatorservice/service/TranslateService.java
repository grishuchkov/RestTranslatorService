package com.grishuchkov.resttranslatorservice.service;

import com.grishuchkov.resttranslatorservice.client.YandexClient;
import com.grishuchkov.resttranslatorservice.dto.*;
import com.grishuchkov.resttranslatorservice.repo.RequestRepository;
import com.grishuchkov.resttranslatorservice.utils.Parser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class TranslateService {
    private final YandexClient yandexClient;
    private final ResponseToUser responseToUser;
    private final Parser parser;
    private final RequestToYandex requestToYandex;
    private final RequestToRepository requestToRepository;
    private final RequestRepository requestRepository;
    private ResponseFromYandex responseFromYandex;

    public ResponseToUser getTranslateFromYandex(RequestFromUser requestFromUser, String userIp){

        String[] wordsArray = parser.stringToList(requestFromUser.getText());

        requestToYandex.setFields(requestFromUser.getLanguageFrom(),
                                    requestFromUser.getLanguageTo(),
                                    wordsArray);

        responseFromYandex = yandexClient.translator(requestToYandex);

        String[] translatedWordsArray = parser.responseFromYandexToStringArray(responseFromYandex);
        String translatedText = parser.responseFromYandexToString(responseFromYandex);

        requestToRepository.setFields(requestFromUser.getText(),
                                        translatedText,
                                        requestFromUser.getLanguageFrom(),
                                        requestFromUser.getLanguageTo(),
                                        userIp,
                                        wordsArray,
                                        translatedWordsArray);

        requestRepository.save(requestToRepository);

        responseToUser.setTranslatedText(translatedText);

        return responseToUser;
    }
}

