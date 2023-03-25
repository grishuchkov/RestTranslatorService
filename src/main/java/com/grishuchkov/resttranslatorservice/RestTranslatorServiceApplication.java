package com.grishuchkov.resttranslatorservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class RestTranslatorServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestTranslatorServiceApplication.class, args);
    }

    @Bean
    public HttpHeaders httpHeaders(){
        return new HttpHeaders();
    }

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

}
