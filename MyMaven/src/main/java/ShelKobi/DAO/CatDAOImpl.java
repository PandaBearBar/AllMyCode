package ShelKobi.DAO;

import ShelKobi.Beans.Cat;
import ShelKobi.db.JDBCUtils;
import ShelKobi.db.ResultsUtils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by kobis on 22 Mar, 22
 */
public class CatDAOImpl implements CatDAO {

    private static final String QUERY_INSERT = "INSERT INTO `java147`.`cats` (`name`, `weight`, `city`) VALUES (?, ?, ?);";
    private static final String QUERY_UPDATE = "UPDATE `java147`.`cats` SET `name` = ?, `weight` = ?, `city` = ? WHERE (`id` = ?);";
    private static final String QUERY_DELETE = "DELETE FROM `java147`.`cats` WHERE (`id` = ?);";
    private static final String QUERY_FIND_ALL = "SELECT * FROM java147.cats;";
    private static final String QUERY_FIND_ONE = "SELECT * FROM java147.cats WHERE (`id` = ?)";
    private static final String QUERY_FIND_NAME = "SELECT * FROM java147.cats WHERE (`name` = ?)";
    private static final String QUERY_FIND_WEIGHT = "SELECT * FROM java147.cats WHERE (`weight` >= ?)";
    private static final String QUERY_FIND_WEIGHT_CITY = "SELECT * FROM java147.cats WHERE (weight <= ?) AND (city = ?);";
    private static final String QUERY_IS_EXIST = "select exists ( SELECT * FROM java147.cats where id=?) as res;";
    private static final String QUERY_AVERAGE_WEIGHT = "SELECT  AVG(weight) 'res' FROM java147.cats;";
    private static final String QUERY_COUNT = "SELECT  count(id) 'res' FROM java147.cats;";

    @Override
    public void addCat(Cat cat) throws SQLException, InterruptedException {

        Map<Integer,Object> params = new HashMap<>();
        params.put(1,cat.getName());
        params.put(2,cat.getWeight());
        params.put(3,cat.getCity());

        JDBCUtils.execute(QUERY_INSERT,params);
    }

    @Override
    public void updateCat(int catId, Cat cat) throws SQLException, InterruptedException {
        Map<Integer,Object> params = new HashMap<>();
        params.put(1,cat.getName());
        params.put(2,cat.getWeight());
        params.put(3,cat.getCity());
        params.put(4,catId);

        JDBCUtils.execute(QUERY_UPDATE,params);
    }

    @Override
    public void deleteCat(int catId) throws SQLException, InterruptedException {
        Map<Integer,Object> params = new HashMap<>();
        params.put(1,catId);

        JDBCUtils.execute(QUERY_DELETE,params);


    }

    @Override
    public List<Cat> findAll() throws SQLException, InterruptedException {
        List<Cat> results = new ArrayList<>();
        List<?> rows = JDBCUtils.executeResults(QUERY_FIND_ALL);
        for (Object row: rows) {
            results.add(ResultsUtils.fromHashMapToCat((HashMap<String, Object>) row));
        }


        return results;
    }

    @Override
    public Cat findById(int catId) throws SQLException, InterruptedException {
        Cat results = null;

        Map<Integer,Object> params = new HashMap<>();
        params.put(1,catId);

        List<?> rows = JDBCUtils.executeResults(QUERY_FIND_ONE,params);
        for (Object row:rows) {
            results = new Cat(ResultsUtils.fromHashMapToCat((HashMap<String, Object>) row));
            break;
        }

        return results;
    }

    @Override
    public boolean isCatExist(int catId) throws SQLException, InterruptedException {
        boolean results = false;
        Map<Integer,Object> params = new HashMap<>();
        params.put(1,catId);
        List<?> rows = JDBCUtils.executeResults(QUERY_IS_EXIST,params);
        for (Object row:rows) {
            results = ResultsUtils.fromHashMapToBool((HashMap<String, Object>) row);
            break;
        }

        return results;
    }

    @Override
    public List<Cat> getAllCatsByName(String name) throws SQLException, InterruptedException {
        List<Cat> results = new ArrayList<>();
        Map<Integer,Object> params = new HashMap<>();
        params.put(1,name);

        List<?> rows = JDBCUtils.executeResults(QUERY_FIND_NAME,params);
        for (Object row:rows) {
            results.add(new Cat(ResultsUtils.fromHashMapToCat((HashMap<String, Object>) row)));
        }
        return results;
    }

    @Override
    public List<Cat> getAllCatsByWeightOver(float weight) throws SQLException, InterruptedException {
        List<Cat> results = new ArrayList<>();
        Map<Integer,Object> params = new HashMap<>();
        params.put(1, weight);

        List<?> rows = JDBCUtils.executeResults(QUERY_FIND_WEIGHT,params);
        for (Object row:rows) {
            results.add(new Cat(ResultsUtils.fromHashMapToCat((HashMap<String, Object>) row)));
        }
        return results;
    }

    @Override
    public List<Cat> getAllCatsByCityAndByWeightUnder(String city, float weight) throws SQLException, InterruptedException {
        List<Cat> results = new ArrayList<>();
        Map<Integer,Object> params = new HashMap<>();
        params.put(1, weight);
        params.put(2, city);

        List<?> rows = JDBCUtils.executeResults(QUERY_FIND_WEIGHT_CITY,params);
        for (Object row:rows) {
            results.add(new Cat(ResultsUtils.fromHashMapToCat((HashMap<String, Object>) row)));
        }
        return results;
    }

    @Override
    public double catsAvgWeight() throws SQLException, InterruptedException {
        double results = 0;
        List<?> rows = JDBCUtils.executeResults(QUERY_AVERAGE_WEIGHT);
        for (Object row:rows) {
            results = ResultsUtils.fromHashMapTodouble((HashMap<String, Object>) row);
            break;
        }

        return results;
    }

    @Override
    public int count() throws SQLException, InterruptedException {
        int results = 0;
        List<?> rows = JDBCUtils.executeResults(QUERY_COUNT);
        for (Object row:rows) {
            results = ((int) ResultsUtils.fromHashMapToInt((HashMap<String, Object>) row));
            break;
        }

        return results;
    }
}
