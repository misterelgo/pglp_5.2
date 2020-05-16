package com.elgo;
import java.sql.*;

public class PersonnelDAO implements DAO_API<Personnel> {

    private static final String DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
    private static String JDBC_URL = "jdbc:derby:derbyDB;create=true";
    Connection conn;

    private static void display(String message) {
        System.out.println(message);
    }

    private static void stop(String message) {
        System.err.println(message);
        System.exit(99);
    }

    public  PersonnelDAO() {
        // chargement du pilote

        //connection a la base de données
        display("connexion a la base de données");
        try {
            this.conn = DriverManager.getConnection(JDBC_URL);
            if (this.conn!=null)
            {
                display("connected Successfully");
            }
        } catch (SQLException e) {
            stop("Connection à la base de données impossible");
        }
    }

    @Override
    public Personnel createPerson(Personnel obj) {
        try{
            Statement query = conn.createStatement();
            query.execute("create table personnel(nom varchar(30), prenom varchar(50),id int ,PRIMARY KEY (id))");
            System.out.println("Personnel table Created");

            PreparedStatement statement = conn.prepareStatement("INSERT INTO personnel (nom, prenom, id) VALUES (?,?,?) ");
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
                    conn.prepareStatement("SELECT * FROM personneL WHERE id = ?");

            recherchePersonne.setInt(1, id);

            ResultSet resultats = recherchePersonne.executeQuery();

            System.out.println("recherche du personnel...");

            boolean encore = resultats.next();

            while (encore) {
                System.out.print(resultats.getString("nom") + ", "+resultats.getString("prenom")+", "+
                        resultats.getString("id"));
                System.out.println();
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

    @Override
    public void printAll() {
        try {
            Statement affichPersonnel =
                    conn.createStatement();
            ResultSet res = affichPersonnel.executeQuery("SELECT * FROM personnel");
            System.out.println("parcours des données retournées");

            while (res.next()) {
                System.out.print(res.getString("nom") + ", "+res.getString("prenom")+", "+
                        res.getInt("id"));
                System.out.println();
            }
            res.close();
        }catch (Exception e){
            System.out.printf(e.getMessage());
        }

    }
}
