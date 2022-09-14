package ShelKobi.DAO;

import ShelKobi.Beans.Cat;
import ShelKobi.Beans.Person;
import ShelKobi.db.JDBCUtils;
import ShelKobi.db.ResultsUtils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by kobis on 22 Mar, 2022
 */
public class PersonDAOImpl implements PersonDAO {
    private static final String QUERY_INSERT = "INSERT INTO `java147`.`people` (`last_name`, `first_name`, `phone_number`, `city`) VALUES (? , ?, ?, ?);";
    private static final String QUERY_UPDATE = "UPDATE java147.people SET `last_name` = ?, `first_name` = ?, `phone_number` = ? , `city` = ? WHERE (`id` = ?);";
    private static final String QUERY_DELETE = "DELETE FROM java147.people WHERE (`id` = ?);";
    private static final String QUERY_FIND_ALL = "SELECT * FROM java147.people;";
    private static final String QUERY_FIND_ONE = "SELECT * FROM java147.people WHERE (`id` = ?)";
    private static final String QUERY_FIND_NAME = "SELECT * FROM java147.people WHERE (`name` = ?)";
    private static final String QUERY_FIND_WEIGHT = "SELECT * FROM java147.people WHERE (`weight` = ?)";
    private static final String QUERY_FIND_WEIGHT_CITY = "SELECT * FROM java147.people WHERE (weight <= ?) AND (city = ?);";
    private static final String QUERY_IS_EXIST = "select exists ( SELECT * FROM java147.people where id=?) as res;";
    private static final String QUERY_AVERAGE_WEIGHT = "SELECT  AVG(weight) 'res' FROM java147.people;";
    private static final String QUERY_COUNT = "SELECT  count(id) 'res' FROM java147.people;";

    private static Map<Integer, Object> params = new HashMap<>();
    private static List<?> rows;

    @Override
    public void addPerson(Person person) throws SQLException, InterruptedException {
        params.clear();
        params.put(1, person.getLastName());
        params.put(2, person.getFirstName());
        params.put(3, person.getPhoneNumber());
        params.put(4, person.getCity());
        JDBCUtils.execute(QUERY_INSERT, params);
    }

    @Override
    public void updatePerson(int personId, Person person) throws SQLException, InterruptedException {
        params.clear();
        params.put(1, person.getLastName());
        params.put(2, person.getFirstName());
        params.put(3, person.getPhoneNumber());
        params.put(4, person.getCity());
        params.put(5, personId);
        JDBCUtils.execute(QUERY_UPDATE, params);
    }

    @Override
    public void deletePerson(int personId) throws SQLException, InterruptedException {
        params.clear();
        params.put(1, personId);
        JDBCUtils.execute(QUERY_DELETE, params);

    }

    @Override
    public List<Person> findAll() throws SQLException, InterruptedException {
        List<Person> results = new ArrayList<>();
        rows = JDBCUtils.executeResults(QUERY_FIND_ALL);
        for (Object row: rows) {
            results.add(ResultsUtils.fromHashMapToPerson((HashMap<String, Object>) row));
        }
        return results;
    }

    @Override
    public Person findById(int personId) throws SQLException, InterruptedException {
        Person results = null;
        params.clear();
        params.put(1,personId);
        rows = JDBCUtils.executeResults(QUERY_FIND_ONE,params);
        for (Object row:rows) {
            results = ResultsUtils.fromHashMapToPerson((HashMap<String, Object>) row);
            break;
        }
        return results;
    }

    @Override
    public boolean isPersonExist(int personId) throws SQLException, InterruptedException {
        boolean results = false;
        params.clear();
        params.put(1, personId);
        List<?> rows = JDBCUtils.executeResults(QUERY_IS_EXIST, params);
        for (Object row: rows) {
            results = ResultsUtils.fromHashMapToBool((HashMap<String, Object>) row);
            break;
        }
        return results;
    }
}
