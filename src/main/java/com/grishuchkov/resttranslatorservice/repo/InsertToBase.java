package com.grishuchkov.resttranslatorservice.repo;

import com.grishuchkov.resttranslatorservice.dto.RequestToRepository;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class InsertToBase {

    public int addTranslateRequestInfo(Connection con, RequestToRepository requestToRepository) {
        try {
            int requestId = -1;

            PreparedStatement preparedStatement = con.prepareStatement("INSERT INTO REQUEST (INPUT_TEXT, OUTPUT_TEXT, LANGUAGE_TO, LANGUAGE_FROM, IP)" +
                    " VALUES (?,?,?,?,?)", new String[]{"ID"});

            preparedStatement.setString(1, requestToRepository.getInputText());
            preparedStatement.setString(2, requestToRepository.getOutputText());
            preparedStatement.setString(3, requestToRepository.getLanguageTo());
            preparedStatement.setString(4, requestToRepository.getLanguageFrom());
            preparedStatement.setString(5, requestToRepository.getIp());
            preparedStatement.executeUpdate();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                requestId = resultSet.getInt("ID");
                return requestId;
            }
            preparedStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public void addTranslatedWordsToBase(Connection con, RequestToRepository requestToRepository, int requestId){
        try (PreparedStatement preparedStatement = con.prepareStatement(
                "INSERT INTO WORDS_REQUEST_TABLE (INPUT_WORD, OUTPUT_WORD, REQUEST_ID) "
                        + "VALUES (?, ?, ?)", new String[] {"ID"})) {

            for (int i = 0; i < requestToRepository.getInputWords().length; i++) {
                preparedStatement.setString(1, requestToRepository.getInputWordByIndex(i));
                preparedStatement.setString(2, requestToRepository.getOutputWordByIndex(i));
                preparedStatement.setInt(3, requestId);

                preparedStatement.addBatch();
            }
            preparedStatement.executeBatch();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            while(resultSet.next()) {
                System.out.println("Inserted:" + resultSet.getString(1));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
