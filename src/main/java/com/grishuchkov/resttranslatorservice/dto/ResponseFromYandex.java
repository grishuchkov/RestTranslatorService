package com.grishuchkov.resttranslatorservice.dto;

import lombok.Data;

import javax.swing.plaf.LabelUI;
import java.util.ArrayList;
import java.util.List;

@Data
public class ResponseFromYandex {
    private final ArrayList<TextTranslation> translations;
}
