package com.elgo;

import java.io.Serializable;
import java.util.ArrayList;

public class AffichageParGroupe implements Container, Serializable {

    public ArrayList<InterfacePersonnel> groups = new ArrayList<InterfacePersonnel>();

    public  AffichageParGroupe (InterfacePersonnel racine) {
        this.groups.add(racine);
    }

    @Override
    public Iterator getIterator() {
        return new CompositeIterator();
    }

    private class CompositeIterator implements Iterator{
        int index = 0;

        public CompositeIterator() {
            int verifier=0;
            while(verifier<groups.size()) {
                if(groups.get(verifier) instanceof PersonnelComposite) {
                    PersonnelComposite personnel = (PersonnelComposite) groups.get(verifier);
                    int i=0;

                    while(i<personnel.personnels.size()) {
                        groups.add(personnel.personnels.get(i));
                        i++;
                    }

                }
                verifier++;
            }
        }
        @Override
        public boolean hasNext() {
            if(index < groups.size())
                return true;
            return false;
        }

        @Override
        public InterfacePersonnel Next() {
            if(this.hasNext())
                return groups.get(index++);
            return null;
        }
    }
}
