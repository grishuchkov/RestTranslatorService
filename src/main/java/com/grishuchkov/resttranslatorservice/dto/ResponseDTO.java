package com.grishuchkov.resttranslatorservice.dto;

import jdk.jfr.Category;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@Component
public class ResponseDTO {
    private String translatedText;
}
