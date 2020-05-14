package com.elgo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class PersonnelBuilder{
    //Necessary params for personnel
    private  String nom;
    private  String prenom;
    private  int id;//new
    //optional params for personnel
    private LocalDate dateDeNaissance;
    private ArrayList<Integer> numTel;

    public PersonnelBuilder (String nom, String prenom, int id) {
        this.nom = nom;
        this.prenom = prenom;
        this.id = id;
    }
    public PersonnelBuilder setDateDeNaissance(int anne,int mois,int jour) {
        this.dateDeNaissance = LocalDate.of(anne, mois, jour);
        return this;
    }

    public PersonnelBuilder setNumTel(ArrayList<Integer> numTel) {
        this.numTel = numTel;
        return this;
    }


    public Personnel getPersonnel(){
        return new Personnel(nom, prenom, id, dateDeNaissance, numTel);
    }

}
