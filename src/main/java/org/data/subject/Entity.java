package org.data.subject;

import java.io.Closeable;
import java.io.Serializable;

/**
 * Created by mr_St on 19.01.17.
 */
public abstract class Entity implements Serializable, Cloneable {

    private int id;

    public Entity() {
    }

    public Entity(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
