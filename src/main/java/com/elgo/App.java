package com.elgo;

import java.sql.SQLException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws SQLException {
        System.out.println( "Test Db connection!" );
        DatabaseTest dbConnection = new DatabaseTest();
    }
}
