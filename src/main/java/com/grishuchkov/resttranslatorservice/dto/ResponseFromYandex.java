package com.grishuchkov.resttranslatorservice.dto;

import lombok.*;
import java.util.ArrayList;

@NoArgsConstructor
@Getter
@Setter
public class ResponseFromYandex {
    private ArrayList<Translations> translations;
}
