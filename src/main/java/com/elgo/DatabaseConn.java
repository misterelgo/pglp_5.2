package com.elgo;
import java.sql.*;
public class DatabaseConn {
    private static final String DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
    private static String JDBC_URL = "jdbc:derby:DBtest;create=true";

    private static void display(String message) {
        System.out.println(message);
    }

    private static void stop(String message) {
        System.err.println(message);
        System.exit(99);
    }

    public static Connection getDatabaseConnection() {
        Connection conn;
        // chargement du pilote
        try {
            Class.forName(DRIVER);
        }catch (ClassNotFoundException e) {
            stop("Impossible de charger le pilote jdbc");
        }

        //connection a la base de données
        display("connexion a la base de données");
        try {
            conn = DriverManager.getConnection(JDBC_URL);
            if (conn!=null)
            {
                display("connected Successfully");
                return conn;
            }
        } catch (SQLException e) {
            stop("Connection à la base de données impossible");
        }
        return null;
    }
}