package com.elgo;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
public class PersonnelDAO implements DAO_API<Personnel> {

    private List<Personnel> personnalList = new ArrayList<>();
    public PersonnelDAO(){
        personnalList.add(new PersonnelBuilder("Gandrick", "Fly", 2).setDateDeNaissance(1999,7,10).getPersonnel());
    }
    @Override
    public Optional<Personnel> get(long id) {
        return Optional.ofNullable(personnalList.get((int) id));
    }

    @Override
    public List<Personnel> getAll() {
        return personnalList;
    }

    @Override
    public void save(Personnel personnel) {
        personnalList.add(personnel);
    }

    @Override
    public void update(Personnel personnel, String[] params) {
        personnel.setNom(Objects.requireNonNull(params[0], "Name cannot be null"));
        personnel.setPrenom(Objects.requireNonNull(params[1], "prenom cannot be null"));

        personnalList.add(personnel);
    }

    @Override
    public void delete(Personnel personnel) {
        personnalList.remove(personnel);
    }


}
