package ShelKobi.DAO;

import ShelKobi.Beans.Person;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by kobis on 22 Mar, 2022
 */
public interface PersonDAO {

    void addPerson(Person person) throws SQLException, InterruptedException;
    void updatePerson(int personId,Person person) throws SQLException, InterruptedException;
    void deletePerson(int personId) throws SQLException, InterruptedException;

    List<Person> findAll() throws SQLException, InterruptedException;
    Person findById(int personId) throws SQLException, InterruptedException;
    boolean isPersonExist(int personId) throws SQLException, InterruptedException;
}
