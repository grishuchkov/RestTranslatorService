package com.grishuchkov.resttranslatorservice.dto;

import lombok.*;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.util.LinkedList;

@Getter
@Setter
@NoArgsConstructor
@Component
public class RequestToYandex {

    private String sourceLanguageCode;
    private String targetLanguageCode;
    private String[] texts;

    @Override
    public String toString() {
        return "[" + texts + "]";
    }
}
