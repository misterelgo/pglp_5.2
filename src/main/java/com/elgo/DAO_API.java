package com.elgo;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface DAO_API<T> extends Serializable {
    Connection conn = null;

    public abstract T createPerson(T obj);
    public abstract T findPerson(int id) throws SQLException;
    public abstract int update(int id , String nom, String prenom);
    public abstract int delete (int id);
    public abstract void printAll ();
}
