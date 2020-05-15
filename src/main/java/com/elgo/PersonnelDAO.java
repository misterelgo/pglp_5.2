package com.elgo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
public class PersonnelDAO implements DAO_API<Personnel> {

    @Override
    public Personnel createPerson(Personnel obj) {
        try{
            Statement query = conn.createStatement();
            query.execute("create table personnel(nom varchar(30), prenom varchar(40),id int ,PRIMARY KEY (id))");
            System.out.println("Personnel table Created");

            PreparedStatement statement = conn.prepareStatement("INSERT INTO personnel (nom, prenom, Id) VALUES (?,?,?) ");
            statement.setString(1, obj.getNom());
            statement.setString(2, obj.getPrenom());
            statement.setInt(3, obj.getId());
            statement.executeUpdate();
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return obj;
    }

    @Override
    public Personnel findPerson(int id) throws SQLException {
        Personnel person = null;
        try {
            PreparedStatement recherchePersonne =
                    conn.prepareStatement("SELECT * FROM personnes WHERE nom_personne = ?");

            recherchePersonne.setInt(3, id);

            ResultSet resultats = recherchePersonne.executeQuery();

            System.out.println("parcours des données retournées");

            boolean encore = resultats.next();

            while (encore) {
                System.out.print(resultats.getString(1) + " :  "+resultats.getString(2)+" "+
                        resultats.getInt(3));
                System.out.println();
                person = new PersonnelBuilder(resultats.getString("nom"), resultats.getString("prenom"), resultats.getInt("Id"))
                        .getPersonnel();
                encore = resultats.next();
            }
            resultats.close();
        }catch (Exception e){
            System.out.printf(e.getMessage());
        }

        return person;
    }

    @Override
    public int update(int id, String nom, String prenom) {
        try{

            PreparedStatement statement = conn.prepareStatement("update personnel set nom=?,prenom=? where id=?");
            statement.setString(1, nom);
            statement.setString(2, prenom);
            statement.setInt(3, id);
            return statement.executeUpdate();
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }

    @Override
    public int delete(int id) {
        try
        {
            PreparedStatement statement = conn.prepareStatement("delete from personnel where id=?");
            statement.setInt(1, id);
            return statement.executeUpdate();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return 0;
    }
}
