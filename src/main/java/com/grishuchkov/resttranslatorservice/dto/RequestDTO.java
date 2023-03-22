package com.grishuchkov.resttranslatorservice.dto;

import com.grishuchkov.resttranslatorservice.service.TranslateService;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Data
@RequiredArgsConstructor
public class RequestDTO {

    private final String text;
    private final String languageFrom;
    private final String languageTo;
}
