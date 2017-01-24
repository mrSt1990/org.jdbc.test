import org.data.connect.ConnectorDB;
import org.data.dao.LetterModifyDAO;
import org.data.util.HibernateUtil;
import org.hibernate.Session;

import java.sql.Connection;
import java.sql.SQLException;

import static java.lang.System.out;

/**
 * Created by mr_St on 19.01.17.
 */
public class Starter {
    public static void main(String[] args) {

//        Connection connection = ConnectorDB.getConnection();

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

//        boolean result = new LetterModifyDAO(connection).createLetters(3, "!!!", "!!!");
//        out.println(result);





//        System.out.println("Hibernate one to many (XML Mapping)");
//        Session session = HibernateUtil.getSessionFactory().openSession();
//
//        session.beginTransaction();
//
//        Stock stock = new Stock();
//        stock.setStockCode("7052");
//        stock.setStockName("PADINI");
//        session.save(stock);
//
//        StockDailyRecord stockDailyRecords = new StockDailyRecord();
//        stockDailyRecords.setPriceOpen(new Float("1.2"));
//        stockDailyRecords.setPriceClose(new Float("1.1"));
//        stockDailyRecords.setPriceChange(new Float("10.0"));
//        stockDailyRecords.setVolume(3000000L);
//        stockDailyRecords.setDate(new Date());
//
//        stockDailyRecords.setStock(stock);
//        stock.getStockDailyRecords().add(stockDailyRecords);
//
//        session.save(stockDailyRecords);
//
//        session.getTransaction().commit();
//        System.out.println("Done");

    }
}
