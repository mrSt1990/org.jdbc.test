package org.data.dao;

import org.data.subject.Entity;

import java.sql.Connection;

/**
 * Created by mr_St on 19.01.17.
 */
public abstract class AbstractModifyDAO<T extends Entity> extends AbstractDAO {
    public AbstractModifyDAO(Connection connection) {
        super(connection);
    }

    public abstract boolean delete(int id);
    public boolean delate(T entity) {
        if (entity == null) {
            throw new IllegalArgumentException();
        }

        return delete(entity.getId());
    }
    public abstract boolean create(T entity);
    public abstract boolean update(T entity);
}
