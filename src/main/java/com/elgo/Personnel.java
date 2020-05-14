package com.elgo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class Personnel implements InterfacePersonnel {
    //Necessary params for personnel
    private  String nom;
    private  String prenom;
    private  int id;//new

    //optional params for personnel
    private  LocalDate dateDeNaissance;
    private  ArrayList<Integer> numTel;

    public Personnel(String nom, String prenom, int id, LocalDate dateDeNaissance, ArrayList<Integer> numTel) {
        this.nom = nom;
        this.prenom = prenom;
        this.id = id;
        this.dateDeNaissance = dateDeNaissance;
        this.numTel = numTel;
    }


    // Setter
    public void setNom(String newName) {
        this.nom = newName;
    }
    // Setter
    public void setPrenom(String newName) {
        this.prenom = newName;
    }

    // Setter
    public void setDateDeNaissance(LocalDate newDate) {
        this.dateDeNaissance = newDate;
    }
    // Setter
    public void setNumTel(ArrayList<Integer> newNumtel) {
        this.numTel = newNumtel;
    }

    @Override
    public void print() {
        System.out.println(
                "Personnel: " +
                        "nom='" + nom + '\'' +
                        ", prenom='" + prenom + '\'' +
                        ", id=" + id +
                        ", dateDeNaissance=" + dateDeNaissance +
                        ", numTel=" + numTel
        );
    }
}
