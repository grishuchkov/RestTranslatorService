package com.grishuchkov.resttranslatorservice.utils;

import com.grishuchkov.resttranslatorservice.dto.ResponseFromYandexDTO;
import com.grishuchkov.resttranslatorservice.dto.Translations;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class Parser {

    public String [] stringToList(String stringFromRequest){
        String withoutTrash = stringFromRequest.replaceAll("\\pP","");

        return withoutTrash.split(" ");
    }

    public String responseFromYandexToString(ResponseFromYandexDTO responseFromYandexDTO){

        return responseFromYandexDTO.getTranslations()
                .stream()
                .map(Translations::getText)
                .collect(Collectors.toList()).toString()
                .replaceAll("\\pP", "");
    }

    public String [] responseFromYandexToStringArray(ResponseFromYandexDTO responseFromYandexDTO){

        return responseFromYandexDTO.getTranslations()
                .stream()
                .map(Translations::getText)
                .toArray(String[]::new);
    }
}
