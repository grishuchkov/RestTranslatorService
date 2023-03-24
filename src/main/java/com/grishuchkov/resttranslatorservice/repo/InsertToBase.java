package com.grishuchkov.resttranslatorservice.repo;

import com.grishuchkov.resttranslatorservice.dto.RequestToRepositoryDTO;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class InsertToBase {

    public int addTranslateRequestInfo(Connection con, RequestToRepositoryDTO requestToRepositoryDTO) {
        try {
            int requestId = -1;

            PreparedStatement preparedStatement = con.prepareStatement("INSERT INTO REQUEST (INPUT_TEXT, OUTPUT_TEXT, LANGUAGE_TO, LANGUAGE_FROM, IP)" +
                    " VALUES (?,?,?,?,?)", new String[]{"ID"});

            preparedStatement.setString(1, requestToRepositoryDTO.getInputText());
            preparedStatement.setString(2, requestToRepositoryDTO.getOutputText());
            preparedStatement.setString(3, requestToRepositoryDTO.getLanguageTo());
            preparedStatement.setString(4, requestToRepositoryDTO.getLanguageFrom());
            preparedStatement.setString(5, requestToRepositoryDTO.getIp());
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

    public void addTranslatedWordsToBase(Connection con, RequestToRepositoryDTO requestToRepositoryDTO, int requestId){
        try (PreparedStatement preparedStatement = con.prepareStatement(
                "INSERT INTO WORDS_REQUEST_TABLE (INPUT_WORD, OUTPUT_WORD, REQUEST_ID) "
                        + "VALUES (?, ?, ?)", new String[] {"ID"})) {

            for (int i = 0; i < requestToRepositoryDTO.getInputWords().length; i++) {
                preparedStatement.setString(1, requestToRepositoryDTO.getInputWordByIndex(i));
                preparedStatement.setString(2, requestToRepositoryDTO.getOutputWordByIndex(i));
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
