

## <center>

REST Yandex API Translator

</center>

#### <center> Данный проект является тестовым (учебным) проектом. </center>
___
<br>
<center>

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=java&logoColor=white)
![Spring](https://img.shields.io/badge/spring%20boot-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![H2 Memory base](https://img.shields.io/badge/-H2%20IN%20Memory%20base-blue?style=for-the-badge&logo=&logoColor=white)
![YANDEX API](https://img.shields.io/badge/-YANDEX%20API-red?style=for-the-badge&logo=&logoColor=white)


</center>

____

Приложение является REST сервисом для получения пословного перевода текстовой строки с помощью Yandex API.  
Во время работы происходит запись в базу данных следующих данных:  
1. ID запроса (PRIMARY KEY AUTO_INCREMENT)
2. Входную строку
3. Строку с переводом
4. Язык, с которого осуществляется перевод
5. Языка, на который осуществляется перевод
6. Время запроса
7. IP клиента, который выполняет запрос

В дополнительную таблицу записываются пары **слово-перевод**, которые связаны с индификатором запроса посредством **FOREIGN KEY** к основной таблице.

___
<br>
