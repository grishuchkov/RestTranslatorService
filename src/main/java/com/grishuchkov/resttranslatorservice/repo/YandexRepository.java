package com.grishuchkov.resttranslatorservice.repo;

import com.grishuchkov.resttranslatorservice.dto.RequestToRepositoryDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.sql.*;

@Repository
@RequiredArgsConstructor
public class YandexRepository {
    private Connection connection;
    private final InsertToBase insertToBase;

    @Value("${spring.datasource.url}")
    private String URL;

    @Value("${spring.datasource.username}")
    private String USERNAME;

    @Value("${spring.datasource.password}")
    private String PASSWORD;

    public void save(RequestToRepositoryDTO requestToRepositoryDTO){
        setConnection();

        int returnedRequestId = insertToBase.addTranslateRequestInfo(connection, requestToRepositoryDTO);

        insertToBase.addTranslatedWordsToBase(connection, requestToRepositoryDTO, returnedRequestId);

    }

   private void setConnection(){
       try {
           connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
       } catch (SQLException throwables) {
           throwables.printStackTrace();
       }
   }
}
