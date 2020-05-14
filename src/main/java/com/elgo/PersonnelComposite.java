package com.elgo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PersonnelComposite implements InterfacePersonnel {

    private int idComposite;
    public List<InterfacePersonnel> personnels = new ArrayList<>();

    public void addPersonnel(InterfacePersonnel personnel){
        personnels.add(personnel);
    }

    public ArrayList<InterfacePersonnel> gettab(){
        return (ArrayList<InterfacePersonnel>) Collections.unmodifiableList(this.personnels);

    }
    public PersonnelComposite(int idComposite) {
        this.idComposite = idComposite;
    }

    @Override
    public void print() {
        System.out.println("Id du composite: "+ idComposite);
        for (InterfacePersonnel personne: personnels){
            personne.print();
        }
    }
}
