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
    private final RequestToYandexDTO requestToYandexDTO;
    private final RequestToRepositoryDTO requestToRepositoryDTO;
    private final YandexRepository yandexRepository;
    private ResponseFromYandexDTO responseFromYandexDTO;

    public ResponseToUserDTO getTranslateFromYandex(RequestFromUserDTO requestFromUserDTO, String userIp){

        String[] wordsArray = parser.stringToArray(requestFromUserDTO.getText());

        requestToYandexDTO.setFields(requestFromUserDTO.getLanguageFrom(),
                                    requestFromUserDTO.getLanguageTo(),
                                    wordsArray);

        responseFromYandexDTO = yandexClient.translate(requestToYandexDTO);

        String[] translatedWordsArray = parser.responseFromYandexToStringArray(responseFromYandexDTO);
        String translatedText = parser.responseFromYandexToString(responseFromYandexDTO);

        requestToRepositoryDTO.setFields(requestFromUserDTO.getText(),
                                        translatedText,
                                        requestFromUserDTO.getLanguageFrom(),
                                        requestFromUserDTO.getLanguageTo(),
                                        userIp,
                                        wordsArray,
                                        translatedWordsArray);

        yandexRepository.save(requestToRepositoryDTO);

        responseToUserDTO.setTranslatedText(translatedText);

        return responseToUserDTO;
    }
}

