package A_JDKC_L1.DAO;

import A_JDKC_L1.Beans.Cat;
import A_JDKC_L1.Beans.Person;

import java.sql.SQLException;
import java.util.List;

public interface PersonDAO {
    void addPerson(Person person);

    void updatePerson(int personId, Person person);

    void deletePerson(int personId);

    List<Person> findAll();

    Person findById(int personId);

    boolean isPersonExist(int personId);

    List<Cat> getAllCatsByWeightOver(float weight) throws SQLException;

    List<Cat> getAllCatsByCityAndByWeightUnder(String city, float weight) throws SQLException;

    double catsAvgWeight();

    int count();

}
