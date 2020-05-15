package com.elgo;
import java.sql.*;
public class DatabaseConn {
    private static final String DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
    private static String JDBC_URL = "jdbc:derby:derbyDB;create=true";
    Connection conn;

    private static void display(String message) {
        System.out.println(message);
    }

    private static void stop(String message) {
        System.err.println(message);
        System.exit(99);
    }

    public  DatabaseConn() {
        // chargement du pilote

        //connection a la base de données
        display("connexion a la base de données");
        try {
            this.conn = DriverManager.getConnection(JDBC_URL);
            if (this.conn!=null)
            {
                display("connected Successfully");
            }
        } catch (SQLException e) {
            stop("Connection à la base de données impossible");
        }
    }
}