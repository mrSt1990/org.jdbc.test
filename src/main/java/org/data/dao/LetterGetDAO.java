package org.data.dao;

import org.data.subject.Letter;
import org.data.subject.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mr_St on 19.01.17.
 */
public class LetterGetDAO extends AbstractGetDAO<Letter> {

    public static final String SQL_SELECT_ALL_LETTERS = "SELECT * FROM letter";
    public static final String SQL_SELECT_LETTER_BY_ID = "SELECT * FROM letter WHERE id = ?";

    public LetterGetDAO(Connection connection) {
        super(connection);
    }

    @Override
    public List<Letter> findAll() {
        List<Letter> letters = new ArrayList<Letter>();
        Statement statement = null;
        ResultSet resultSet = null;
        try{
            statement = connection.createStatement();
            resultSet = statement.executeQuery(SQL_SELECT_ALL_LETTERS);
            while (resultSet.next()) {
                Letter letter = new Letter();
                fillEntity(resultSet, letter);
                letters.add(letter);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResultSet(resultSet);
            closeStatement(statement);
        }

        return letters;
    }

    @Override
    public Letter findEntityById(int id) {
        Letter letter = new Letter();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try{
            preparedStatement = connection.prepareStatement(SQL_SELECT_LETTER_BY_ID);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                fillEntity(resultSet, letter);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResultSet(resultSet);
            closePreparedStatement(preparedStatement);
        }

        return letter;
    }

    @Override
    protected void fillEntity(ResultSet resultSet, Letter entity) throws SQLException {
        entity.setId(resultSet.getInt("id"));
        entity.setRecipient(resultSet.getInt("id_recipient"));
        entity.setSender(resultSet.getInt("id_sender"));
        entity.setSendDate(resultSet.getDate("send_date"));
        entity.setSubject(resultSet.getString("subject"));
        entity.setText(resultSet.getString("text"));
    }
}
