import org.data.connect.ConnectorDB;
import org.data.dao.LetterModifyDAO;

import java.sql.Connection;
import java.sql.SQLException;

import static java.lang.System.out;

/**
 * Created by mr_St on 19.01.17.
 */
public class Starter {
    public static void main(String[] args) throws SQLException {

        Connection connection = ConnectorDB.getConnection();

//        Person p = new Person();
//        p.setFirstName("Краснова");
////        p.setLastName("Василий");
//        GregorianCalendar calendar = new GregorianCalendar(1990, Calendar.JUNE, 2);
//        p.setDateOfBirth(calendar.getTime());
//
//        PersonModifyDAO personModifyDAO = new PersonModifyDAO(connection);
//        boolean result = personModifyDAO.create(p);

        //Person p = new PersonGetDAO(connection).findPersonWithMinLettersLength();
        //out.println(p);

//        List<PersonInfo> personInfoList = new PersonGetDAO(connection).findPersonsInfo();
//        for (PersonInfo item:
//             personInfoList) {
//            out.println(item);
//        }

        boolean result = new LetterModifyDAO(connection).createLetters(3, "!!!", "!!!");
        out.println(result);
    }
}
