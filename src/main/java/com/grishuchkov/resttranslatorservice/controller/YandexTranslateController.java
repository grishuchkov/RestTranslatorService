package com.grishuchkov.resttranslatorservice.controller;

import com.grishuchkov.resttranslatorservice.dto.RequestFromUserDTO;
import com.grishuchkov.resttranslatorservice.dto.ResponseToUserDTO;
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
    public ResponseToUserDTO getTranslateFromYandex(@RequestBody RequestFromUserDTO requestFromUserDTO, HttpServletRequest request){

        String ip = request.getRemoteAddr();

        return translateService.getTranslateFromYandex(requestFromUserDTO, ip);
    }
}
