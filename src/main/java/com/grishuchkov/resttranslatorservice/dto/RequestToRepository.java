package com.grishuchkov.resttranslatorservice.dto;

import lombok.*;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@Getter
@Setter
@Component
public class RequestToRepository {

    private String inputText;

    private String outputText;
    private String languageFrom;
    private String languageTo;
    private String ip;
    private String[] inputWords;

    private String[] outputWords;

    public void setFields(String inputText, String outputText, String languageFrom,
                          String languageTo, String ip, String[] inputWords, String[] outputWords) {
        this.inputText = inputText;
        this.outputText = outputText;
        this.languageFrom = languageFrom;
        this.languageTo = languageTo;
        this.ip = ip;
        this.inputWords = inputWords;
        this.outputWords = outputWords;
    }

    public String getInputWordByIndex(int index) {
        return inputWords[index];
    }

    public String getOutputWordByIndex(int index) {
        return outputWords[index];
    }
}
