package com.elgo;
import java.sql.*;
public class DatabaseTest {
    private static final String DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
    private static final String JDBC_URL = "jdbc:derby:testconn1;create=true";

    Connection conn;
    public DatabaseTest() throws SQLException {
        this.conn = DriverManager.getConnection(JDBC_URL);
        if (this.conn != null){
            System.out.println("Connected successfully");
        }
    }
}
