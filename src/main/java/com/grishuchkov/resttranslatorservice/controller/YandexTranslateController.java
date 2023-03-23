package com.grishuchkov.resttranslatorservice.controller;

import com.grishuchkov.resttranslatorservice.dto.RequestFromUser;
import com.grishuchkov.resttranslatorservice.dto.ResponseToUser;
import com.grishuchkov.resttranslatorservice.service.TranslateService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/translate")
public class YandexTranslateController {

    private final TranslateService translateService;

    @PostMapping("")
    public ResponseToUser getTranslateFromYandex(@RequestBody RequestFromUser requestFromUser, HttpServletRequest request){

        String ip = request.getRemoteAddr();

        return translateService.getTranslateFromYandex(requestFromUser, ip);
    }
}
