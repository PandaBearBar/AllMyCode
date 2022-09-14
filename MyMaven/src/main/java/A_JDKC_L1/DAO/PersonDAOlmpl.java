package A_JDKC_L1.DAO;

import A_JDKC_L1.Beans.Cat;
import A_JDKC_L1.Beans.Person;

import java.sql.SQLException;
import java.util.List;

public class PersonDAOlmpl implements PersonDAO{
    @Override
    public void addPerson(Person person) {

    }

    @Override
    public void updatePerson(int personId, Person person) {

    }

    @Override
    public void deletePerson(int personId) {

    }

    @Override
    public List<Person> findAll() {
        return null;
    }

    @Override
    public Person findById(int personId) {
        return null;
    }

    @Override
    public boolean isPersonExist(int personId) {
        return false;
    }

    @Override
    public List<Cat> getAllCatsByWeightOver(float weight) throws SQLException {
        return null;
    }

    @Override
    public List<Cat> getAllCatsByCityAndByWeightUnder(String city, float weight) throws SQLException {
        return null;
    }

    @Override
    public double catsAvgWeight() {
        return 0;
    }

    @Override
    public int count() {
        return 0;
    }
}
