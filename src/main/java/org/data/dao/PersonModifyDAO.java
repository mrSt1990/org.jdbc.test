package org.data.dao;

import org.data.subject.Person;

import java.sql.*;

/**
 * Created by mr_St on 19.01.17.
 */
public class PersonModifyDAO extends AbstractModifyDAO<Person> {

    private static final String SQL_DELETE_PERSON_BY_ID = "DELETE FROM person WHERE id = ?";
    private static final String SQL_INSERT_PERSON = "INSERT INTO person (last_name, first_name, middle_name, date_of_birth) VALUES (?, ?, ?, ?)";
    private static final String SQL_UPDATE_PERSON = "UPDATE person SET last_name = ?, first_name = ?, middle_name = ?, date_of_birth = ? WHERE id = ?";

    public PersonModifyDAO(Connection connection) {
        super(connection);
    }

    @Override
    public boolean delete(int id) {
        boolean flag = false;
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_DELETE_PERSON_BY_ID);
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
    public boolean create(Person entity) {
        boolean flag = false;
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_INSERT_PERSON);
            statement.setString(1, entity.getLastName());
            statement.setString(2, entity.getFirstName());
            statement.setString(3,entity.getMiddleName());
            statement.setDate(4, new Date(entity.getDateOfBirth().getTime()));
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
    public boolean update(Person entity) {
        boolean flag = false;
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_UPDATE_PERSON);
            statement.setString(1, entity.getLastName());
            statement.setString(2, entity.getFirstName());
            statement.setString(3,entity.getMiddleName());
            statement.setDate(4, new Date(entity.getDateOfBirth().getTime()));
            statement.setInt(5, entity.getId());
            statement.executeUpdate();
            flag = true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            closePreparedStatement(statement);
        }

        return flag;
    }
}
