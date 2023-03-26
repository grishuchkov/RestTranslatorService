

## <center> REST Yandex API Translator </center>

#### <center> Данный проект является тестовым (учебным) проектом. </center>
___
<br>

![cover](https://github.com/grishuchkov/RestTranslatorService/blob/master/gitsrc/logo.png)
___


### Навигация:
[1. Описание](#описание)  
[2. Сборка и старт](#Старт)  
[3. Взаимодействие с приложением](#Взаимодействие)   
[4. Автор](#Автор)
___
<center>

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=java&logoColor=white)
![Spring](https://img.shields.io/badge/spring%20boot-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![H2 Memory base](https://img.shields.io/badge/-H2%20IN%20Memory%20base-blue?style=for-the-badge&logo=&logoColor=white)
![YANDEX API](https://img.shields.io/badge/-YANDEX%20API-red?style=for-the-badge&logo=&logoColor=white)


</center>

____
<a name="Описание"></a> 

Приложение является REST сервисом для получения пословного перевода текстовой строки с помощью Yandex API.  
Реализация написана на JAVA + Spring Boot. Взаимодействие с базой данных осуществляется с помощью низкоуровневого JDBC API. Hibernate не используется.  

**Во время работы происходит запись в базу следующих данных:**
1. ID запроса (PRIMARY KEY AUTO_INCREMENT)
2. Входную строку
3. Строку с переводом
4. Язык, с которого осуществляется перевод
5. Языка, на который осуществляется перевод
6. Время запроса
7. IP клиента, который выполняет запрос

В дополнительную таблицу записываются пары **слово-перевод**, которые связаны с индификатором запроса посредством **FOREIGN KEY** к основной таблице.
___
<a name="Старт"></a>
### Сборка и старт. 

1. Клонируйте репозиторий:  
   `git clone https://github.com/grishuchkov/RestTranslatorService.git`

2. Введите свои настройки в: `application.yml`  
   Необходимо ввести свой `Token` для Yandex Cloud API.  
   Внести изменения в настройки БД, если необходимо.

3. Для сборки проекта используйте: `./mvnw clean package`.  
   <br>
   Это создает `RestTranslatorService-0.0.1-SNAPSHOT.jar` файл в каталоге `./targer`  
   Приложение теперь доступно для запуска с использованием `java -jar target/RestTranslatorService-0.0.1-SNAPSHOT.jar`

4. В проекте присутствует **Dockerfile**, благодаря которому можно создать Docker Image.  
   Для этого используйте команду: `docker build -t rest-yandex-translator:0.0.1 .`  

   **Если у вас MacOS в этот момент в обязательном порядке должен быть запущен Docker Desktop**

5. Чтобы запустить контейнер, необходимо прописать: `docker run -p 8500:9000 rest-yandex-translator:0.0.1` 
   Обратите внимание на порты. В `application.yml` порт по умолчанию стоит как: `9000`
   
6. Все должно работать.

___
<a name="Взаимодействие"></a> 

**Взаимодействие с приложением** осуществляется путём HTTP запроса. На данный момент реализован один POST запрос, в тело которого нужно передать JSON c необходимыми данными (строка для перевода, язык строки, язык, на который нужно перевести). В ответе приходит JSON с пословно переведенной строкой.
<br>  

<center>

| Тип запроса | Путь | Примечание|
|:----:|:----:|:----------:|
| `POST` | `./translate` | На вход JSON, на выход JSON |  

</center>

<br>  

### Пример запроса `./translate`:  

В тело передаем:  
```json
{
    "text" : "Тестовый перевод для README, спасибо, что читаете это",
    "languageFrom" : "ru",
    "languageTo" : "en"
}
```
В ответ получаем:  
```json
{
    "translatedText": "Test translation for README thanks what reading this"
}
```  
Для проверки корректной записи в базу можно воспользоваться встроенной консолью, доступ к которой огранизуется по адресу: `./h2-console`

Для вохода нужно прописать значения из конфиг-файла `application.yml`. По умолчанию поля следующие:  

| Поле | Значение |
|:----:|:----:|
| `URL` | `jdbc:h2:mem:maindb` |
| `username` | `root` |
| `password` | `root` |

___
<a name="Автор"></a>

### Автор: [Grishuchkov Danila](https://github.com/grishuchkov)
Проект создан при поддержке зеленого чая, Яндекс.Музыки и мотивации что-то сделать.  
Срок выполнения: 4 дня.  
Тинькофф, :yellow_heart::yellow_heart::yellow_heart::exclamation:
