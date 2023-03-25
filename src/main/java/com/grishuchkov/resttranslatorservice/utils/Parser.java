package com.grishuchkov.resttranslatorservice.utils;

import com.grishuchkov.resttranslatorservice.dto.ResponseFromYandex;
import com.grishuchkov.resttranslatorservice.dto.Translations;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class Parser {

    public String [] stringToArray(String stringFromRequest){
        String withoutTrash = stringFromRequest.replaceAll("\\pP","");

        return withoutTrash.split(" ");
    }

    public String responseFromYandexToString(ResponseFromYandex responseFromYandex){

        return responseFromYandex.getTranslations()
                .stream()
                .map(Translations::getText)
                .collect(Collectors.toList()).toString()
                .replaceAll("\\pP", "");
    }

    public String [] responseFromYandexToStringArray(ResponseFromYandex responseFromYandex){

        return responseFromYandex.getTranslations()
                .stream()
                .map(Translations::getText)
                .toArray(String[]::new);
    }
}
