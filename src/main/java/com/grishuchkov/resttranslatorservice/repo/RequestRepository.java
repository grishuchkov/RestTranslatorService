package com.grishuchkov.resttranslatorservice.repo;

import com.grishuchkov.resttranslatorservice.dto.RequestDTO;
import org.springframework.stereotype.Repository;

import java.sql.*;

@Repository
public class RequestRepository {

//    @Value("${spring.datasource.url}")
    private static String URL = "jdbc:h2:mem:maindb";

//    @Value("${spring.datasource.username}")
    private static String USERNAME = "root";

//    @Value("${spring.datasource.password}")
    private static String PASSWORD = "root";

    private static Connection connection;

    static {
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void save(RequestDTO requestDTO){
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
