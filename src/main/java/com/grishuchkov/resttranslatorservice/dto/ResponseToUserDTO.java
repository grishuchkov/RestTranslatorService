package com.grishuchkov.resttranslatorservice.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@Component
public class ResponseToUserDTO {
    private String translatedText;
}