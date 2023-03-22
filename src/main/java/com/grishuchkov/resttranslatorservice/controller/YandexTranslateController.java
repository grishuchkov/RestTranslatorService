package com.grishuchkov.resttranslatorservice.controller;

import com.grishuchkov.resttranslatorservice.dto.RequestDTO;
import com.grishuchkov.resttranslatorservice.dto.ResponseDTO;
import com.grishuchkov.resttranslatorservice.service.TranslateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/translate")
public class YandexTranslateController {

    private final TranslateService translateService;

    @PostMapping("")
    public String getTranslateFromYandex(@RequestBody RequestDTO requestDTO){

        return translateService.getTranslateFromYandex(requestDTO);
    }
}
