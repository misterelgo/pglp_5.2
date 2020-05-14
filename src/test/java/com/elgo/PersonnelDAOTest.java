import com.elgo.*;
import org.junit.Test;

import java.io.*;
import java.util.Optional;

import static org.junit.Assert.*;

public class PersonnelDAOTest {
    private static DAO_API<Personnel> personnelDAO_api;

    @Test
    public void personnelDAO() throws IOException, ClassNotFoundException {
        personnelDAO_api = new PersonnelDAO();
        personnelDAO_api.save( new PersonnelBuilder("Lopy", "Douglas", 3).setDateDeNaissance(2020,9,19).getPersonnel());

        Personnel p4 = new PersonnelBuilder("DAVID", "Henry", 4).setDateDeNaissance(2000,7,4).getPersonnel();
        personnelDAO_api.save(p4);
        personnelDAO_api.update(p4, new String[]{"Jake", "Henry"});
        personnelDAO_api.delete(p4);
        personnelDAO_api.getAll().forEach(personnel -> personnel.print());

        //Serializing the Object
        FileOutputStream fos = new FileOutputStream("dao_personnel.ser");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(personnelDAO_api);
        System.out.println("Object successfully serialized");
        oos.close();
        fos.close();

        //Deserializing the object
        System.out.println("----------------------------------------------------------------------");
        //Deserializing the object
        FileInputStream fis = new FileInputStream("dao_personnel.ser");
        ObjectInputStream ois = new ObjectInputStream(fis);
        PersonnelDAO dao_personnel = (PersonnelDAO) ois.readObject();
        System.out.println("Deserialized sucessfully");

        dao_personnel.getAll().forEach(personnel -> personnel.print());
    }
}