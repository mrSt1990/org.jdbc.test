package org.data.connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by mr_St on 19.01.17.
 */
public class ConnectorDB {
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/test_db";
        Properties prop = new Properties();
        prop.put("user", "mysql");
        prop.put("password", "123");
        prop.put("autoReconect", "true");
        prop.put("characterEncoding", "UTF-8");
        prop.put("useUnicode", "true");
        return DriverManager.getConnection(url, prop);
    }
}
