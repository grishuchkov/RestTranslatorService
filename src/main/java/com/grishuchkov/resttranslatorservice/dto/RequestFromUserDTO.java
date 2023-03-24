package com.grishuchkov.resttranslatorservice.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class RequestFromUserDTO {

    private final String text;
    private final String languageFrom;
    private final String languageTo;
}
