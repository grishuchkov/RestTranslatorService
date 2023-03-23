package com.grishuchkov.resttranslatorservice.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class RequestFromUser {

    private final String text;
    private final String languageFrom;
    private final String languageTo;
}
