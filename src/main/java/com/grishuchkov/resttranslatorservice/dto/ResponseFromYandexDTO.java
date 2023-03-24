package com.grishuchkov.resttranslatorservice.dto;

import lombok.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor
@Component
public class ResponseFromYandexDTO {
    private ArrayList<Translations> translations;
}
