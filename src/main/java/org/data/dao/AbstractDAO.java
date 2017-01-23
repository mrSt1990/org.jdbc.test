package org.data.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

/**
 * Created by mr_St on 19.01.17.
 */
public abstract class AbstractDAO {
    protected Connection connection;

    public AbstractDAO(Connection connection) {
        this.connection = connection;
    }

    protected void closeStatement(Statement st) {
        try{
            if (st != null) {
                st.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void closePreparedStatement(PreparedStatement st) {
        try{
            if (st != null) {
                st.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void closeResultSet(ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
