package com.grishuchkov.resttranslatorservice.repo;

import com.grishuchkov.resttranslatorservice.dto.RequestDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.sql.*;

@Repository
public class RequestRepository {

    @Value("${spring.datasource.url}")
    private String URL;

    @Value("${spring.datasource.username}")
    private String USERNAME;

    @Value("${spring.datasource.password}")
    private String PASSWORD;

    private Connection connection;

   private void setConnection(){
       try {
           connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
       } catch (SQLException throwables) {
           throwables.printStackTrace();
       }
   }

    public void save(RequestDTO requestDTO){
       setConnection();
       try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("INSERT INTO REQUEST (INPUT_TEXT, OUTPUT_TEXT, LANGUAGE_TO, LANGUAGE_FROM, IP) VALUES (?,?,?,?,?)");

            preparedStatement.setString(1,requestDTO.getText());
            preparedStatement.setString(2,"Output text");
            preparedStatement.setString(3,requestDTO.getLanguageFrom());
            preparedStatement.setString(4,requestDTO.getLanguageTo());
            preparedStatement.setString(5,"some ip");

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
