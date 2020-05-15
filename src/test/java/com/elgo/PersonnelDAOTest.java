package com.elgo;

import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.Assert.*;

public class PersonnelDAOTest {

    Personnel p1 = new PersonnelBuilder("DIEYE", "Gora", 1).getPersonnel();
    Personnel p2 = new PersonnelBuilder("BOB", "Ibo", 2).getPersonnel();
    Personnel p3 = new PersonnelBuilder("SILVER", "Bril", 3).getPersonnel();
    Personnel p4 = new PersonnelBuilder("Gril", "Kil", 3).getPersonnel();

    private static void display(String message) {
        System.out.println(message);
    }

    private static void stop(String message) {
        System.err.println(message);
        System.exit(99);
    }


    @Test
    public void testbd() throws SQLException {
        PersonnelDAO pers1 = new PersonnelDAO();
        //pers1.createPerson(p4);
        //pers1.findPerson(1);
        //pers1.delete(2);
        pers1.printAll();

    }


}