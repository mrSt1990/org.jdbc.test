package org.data.dao;

import org.data.subject.Letter;
import org.data.subject.Person;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by mr_St on 22.01.17.
 */
public class LetterModifyDAO extends AbstractModifyDAO<Letter> {

    private static final String SQL_DELETE_LETTER_BY_ID = "DELETE FROM letter WHERE id = ?";
    private static final String SQL_INSERT_LETTER = "INSERT INTO letter (id_sender, id_recipient, subject, text, send_date) VALUES (?, ?, ?, ?, ?)";

    public LetterModifyDAO(Connection connection) {
        super(connection);
    }

    @Override
    public boolean delete(int id) {
        boolean flag = false;
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_DELETE_LETTER_BY_ID);
            statement.setInt(1, id);
            statement.executeUpdate();
            flag = true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closePreparedStatement(statement);
        }

        return flag;
    }

    @Override
    public boolean create(Letter entity) {
        boolean flag = false;
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_INSERT_LETTER);
            statement.setInt(1, entity.getSender());
            statement.setInt(2, entity.getRecipient());
            statement.setString(3, entity.getSubject());
            statement.setString(4, entity.getText());
            statement.setDate(5, new Date(entity.getSendDate().getTime()));
            statement.executeUpdate();
            flag = true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            closePreparedStatement(statement);
        }

        return flag;
    }

    @Override
    public boolean update(Letter entity) {
        throw new NotImplementedException();
    }

    public boolean createLetters(int id_sender, String subject, String text) {
        boolean flag = false;
        PreparedStatement statement = null;
        Letter letter = new Letter();
        letter.setSender(id_sender);
        letter.setSubject(subject);
        letter.setText(text);
        letter.setSendDate(new java.util.Date());
        try {
            List<Person> personList = new PersonGetDAO(connection).findAll();
            connection.setAutoCommit(false);
            for (Person person :
                    personList) {
                if (person.getId() != id_sender) {
                    letter.setRecipient(person.getId());
                    create(letter);
                }
            }
            connection.commit();
            flag = true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            closePreparedStatement(statement);
        }

        if (!flag) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        try {
            connection.setAutoCommit(true);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return flag;
    }


}
