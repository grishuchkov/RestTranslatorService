package com.grishuchkov.resttranslatorservice.utils;

import com.grishuchkov.resttranslatorservice.dto.ResponseFromYandex;
import com.grishuchkov.resttranslatorservice.dto.Translations;
import org.apache.coyote.Response;
import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ParserTest {


    @Autowired
    private Parser parser;
    @Autowired
    private ResponseFromYandex responseFromYandex;

    @Test
    void stringToArray() {
        String testString = "Привет, как_ твои# дела&, что делаешь; а?";
        String[] rightStringArray = {"Привет", "как", "твои", "дела", "что", "делаешь", "а"};

        String[] arrayAfterParser = parser.stringToArray(testString);

        System.out.println(Arrays.toString(rightStringArray));
        System.out.println(Arrays.toString(arrayAfterParser));

        Assertions.assertArrayEquals(rightStringArray,arrayAfterParser);
    }

    @Test
    void responseFromYandexToString() {
        String rightString = "Hi how Are You";

        ResponseFromYandex responseFromYandex = getTestResponseFromYandex();
        String afterParser = parser.responseFromYandexToString(responseFromYandex);

        System.out.println(rightString);
        System.out.println(afterParser);

        Assertions.assertEquals(rightString,afterParser);
    }

    @Test
    void responseFromYandexToStringArray(){
        String [] rightStringArray = {"Hi", "how", "Are", "You"};

        ResponseFromYandex responseFromYandex = getTestResponseFromYandex();
        String[] arrayAfterParser = parser.responseFromYandexToStringArray(responseFromYandex);

        System.out.println(Arrays.toString(rightStringArray));
        System.out.println(Arrays.toString(arrayAfterParser));

        Assertions.assertArrayEquals(rightStringArray,arrayAfterParser);
    }

    private ResponseFromYandex getTestResponseFromYandex(){
        Translations word1 = new Translations();
        word1.setText("Hi");
        Translations word2 = new Translations();
        word2.setText("how");
        Translations word3 = new Translations();
        word3.setText("Are");
        Translations word4 = new Translations();
        word4.setText("You");

        ArrayList<Translations> translations = new ArrayList<>(){{
            add(word1);
            add(word2);
            add(word3);
            add(word4);
        }};

        responseFromYandex.setTranslations(translations);
        return responseFromYandex;
    }
}