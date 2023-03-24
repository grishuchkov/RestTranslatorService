package com.grishuchkov.resttranslatorservice.repo;

import com.grishuchkov.resttranslatorservice.dto.RequestToRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.sql.*;

@Repository
@RequiredArgsConstructor
public class RequestRepository {
    private Connection connection;
    private final InsertToBase insertToBase;

    @Value("${spring.datasource.url}")
    private String URL;

    @Value("${spring.datasource.username}")
    private String USERNAME;

    @Value("${spring.datasource.password}")
    private String PASSWORD;

    public void save(RequestToRepository requestToRepository){
        setConnection();

        int returnedRequestId = insertToBase.addTranslateRequestInfo(connection, requestToRepository);

        insertToBase.addTranslatedWordsToBase(connection, requestToRepository, returnedRequestId);

    }

   private void setConnection(){
       try {
           connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
       } catch (SQLException throwables) {
           throwables.printStackTrace();
       }
   }
}
