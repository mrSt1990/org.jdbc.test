package org.data.dao;

import org.data.subject.Entity;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by mr_St on 19.01.17.
 */
public abstract class AbstractGetDAO<T extends Entity> extends AbstractDAO {
    public AbstractGetDAO(Connection connection) {
        super(connection);
    }

    public abstract List<T> findAll();
    public abstract T findEntityById(int id);
    protected abstract void fillEntity(ResultSet resultSet, T entity) throws SQLException;
}
