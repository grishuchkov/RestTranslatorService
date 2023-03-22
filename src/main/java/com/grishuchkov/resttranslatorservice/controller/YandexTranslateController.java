package com.grishuchkov.resttranslatorservice.controller;

import com.grishuchkov.resttranslatorservice.dto.RequestDTO;
import com.grishuchkov.resttranslatorservice.dto.ResponseDTO;
import com.grishuchkov.resttranslatorservice.repo.RequestRepository;
import com.grishuchkov.resttranslatorservice.service.TranslateService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;

@RestController
@RequiredArgsConstructor
@RequestMapping("/translate")
public class YandexTranslateController {

    private final TranslateService translateService;
    private final RequestRepository requestRepository;
    private final HttpServletRequest request;

    @PostMapping("")
    public ResponseDTO getTranslateFromYandex(@RequestBody RequestDTO requestDTO){
        String ip = request.getRemoteAddr();
        System.out.println(ip);

        //TO-DO передать IP внутрь сервиса.
        return translateService.getTranslateFromYandex(requestDTO);
    }

   @PostMapping("/db")
    public void postToBase(@RequestBody RequestDTO requestDTO){
        requestRepository.save(requestDTO);
   }
}
