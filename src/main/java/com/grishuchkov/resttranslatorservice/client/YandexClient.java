package com.grishuchkov.resttranslatorservice.client;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "yandextranslate", url = "https://translate.api.cloud.yandex.net/translate/v2/translate")
public interface YandexClient {

    @PostMapping()
    String translations();
}
