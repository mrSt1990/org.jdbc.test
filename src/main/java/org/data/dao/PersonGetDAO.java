package org.data.dao;

import org.data.subject.Person;
import org.data.subject.PersonInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mr_St on 19.01.17.
 */
public class PersonGetDAO extends AbstractGetDAO<Person> {

    private static final String SQL_SELECT_ALL_PERSONS = "SELECT * FROM person";
    private static final String SQL_SELECT_PERSON_BY_ID = "SELECT * FROM person WHERE id = ?";
    private static final String SQL_SELECT_PERSON_WITH_MIN_LETTERS_LENGTH = "select p.*\n" +
            "from person p,\n" +
            "\t(select p.id id_person, Sum(char_length(l.text)) summ\n" +
            "\tfrom person p, letter l\n" +
            "\twhere l.id_sender = p.id\n" +
            "\tgroup by p.id\n" +
            "\torder by summ limit 1) p_summ\n" +
            "where p.id = p_summ.id_person\t";

    private static final String SQL_SELECT_PERSONS_INFO = "select p.*, count_1.cnt send_cnt, count_2.cnt recieve_cnt\n" +
            "from\n" +
            "person p\n" +
            "left join (select p.id, count(l1.id) cnt\n" +
            "\t\t  from person p \n" +
            "\t\t  left join letter l1 on l1.id_sender = p.id\n" +
            "\t\t  group by p.id) count_1 on p.id = count_1.id\n" +
            "left join (select p.id, count(l2.id) cnt\n" +
            "\t\t  from person p \n" +
            "\t\t  left join letter l2 on l2.id_recipient = p.id\n" +
            "\t\t  group by p.id) count_2 on p.id = count_2.id";

    public PersonGetDAO(Connection connection) {
        super(connection);
    }

    @Override
    public List<Person> findAll() {
        List<Person> persons = new ArrayList<Person>();
        Statement statement = null;
        ResultSet resultSet = null;
        try{
            statement = connection.createStatement();
            resultSet = statement.executeQuery(SQL_SELECT_ALL_PERSONS);
            while (resultSet.next()) {
                Person person = new Person();
                fillEntity(resultSet, person);
                persons.add(person);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResultSet(resultSet);
            closeStatement(statement);
        }

        return persons;
    }

    @Override
    public Person findEntityById(int id) {
        Person person = new Person();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try{
            preparedStatement = connection.prepareStatement(SQL_SELECT_PERSON_BY_ID);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                fillEntity(resultSet, person);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResultSet(resultSet);
            closePreparedStatement(preparedStatement);
        }

        return person;
    }

    @Override
    protected void fillEntity(ResultSet resultSet, Person entity) throws SQLException {
        entity.setId(resultSet.getInt("id"));
        entity.setLastName(resultSet.getString("last_name"));
        entity.setFirstName(resultSet.getString("first_name"));
        entity.setMiddleName(resultSet.getString("middle_name"));
        entity.setDateOfBirth(resultSet.getDate("date_of_birth"));
    }

    public Person findPersonWithMinLettersLength() {
        Person person = new Person();
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(SQL_SELECT_PERSON_WITH_MIN_LETTERS_LENGTH);
            if (resultSet.next()) {
                fillEntity(resultSet, person);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            closeResultSet(resultSet);
            closeStatement(statement);
        }

        return person;
    }

    public List<PersonInfo> findPersonsInfo() {
        List<PersonInfo> personInfoList = new ArrayList<PersonInfo>();
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(SQL_SELECT_PERSONS_INFO);
            while (resultSet.next()) {
                Person person = new Person();
                fillEntity(resultSet, person);
                PersonInfo pInfo = new PersonInfo();
                pInfo.setPerson(person);
                pInfo.setSendLettersCnt(resultSet.getInt("send_cnt"));
                pInfo.setRecieveLetterCnt(resultSet.getInt("recieve_cnt"));
                personInfoList.add(pInfo);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        finally {
            closeResultSet(resultSet);
            closeStatement(statement);
        }

        return personInfoList;
    }

}
