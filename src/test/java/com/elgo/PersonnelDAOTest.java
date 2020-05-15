package com.elgo;

import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;

import static org.junit.Assert.*;

public class PersonnelDAOTest {

    Personnel p1 = new PersonnelBuilder("DIEYE", "Gora", 1).setDateDeNaissance(2020,9,19).getPersonnel();
    Personnel p2 = new PersonnelBuilder("BOB", "Ibo", 2).getPersonnel();
    Personnel p3 = new PersonnelBuilder("SILVER", "Bril", 3).setDateDeNaissance(1998,8,3).getPersonnel();
    private static void display(String message) {
        System.out.println(message);
    }

    private static void stop(String message) {
        System.err.println(message);
        System.exit(99);
    }

    @Test
    public void createPerson() {
        Connection conn = null;
        ResultSet resultats = null;
        String requete = "";

        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
        } catch (ClassNotFoundException e) {
            stop("Impossible de charger le pilote jdbc");
        }

    }

    @Test
    public void findPerson() {
    }

    @Test
    public void update() {
    }

    @Test
    public void delete() {
    }
}