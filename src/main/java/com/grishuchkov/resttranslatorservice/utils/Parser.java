package com.grishuchkov.resttranslatorservice.utils;

import com.grishuchkov.resttranslatorservice.dto.ResponseFromYandex;
import com.grishuchkov.resttranslatorservice.dto.Translations;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class Parser {

    public String [] stringToList(String stringFromRequest){
        return stringFromRequest.split(" ");
    }

    public String responseFromYandexToString(ResponseFromYandex responseFromYandex){

        return responseFromYandex.getTranslations()
                .stream()
                .map(Translations::getText)
                .collect(Collectors.toList()).toString()
                .replaceAll("\\pP", "");
    }
}
