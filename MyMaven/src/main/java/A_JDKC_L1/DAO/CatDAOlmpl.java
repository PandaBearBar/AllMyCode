package A_JDKC_L1.DAO;

import A_JDKC_L1.Beans.Cat;
import A_JDKC_L1.db.JDBCUtils;
import A_JDKC_L1.db.ResultsUtils;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CatDAOlmpl implements CatDAO {
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
    public void addCat(Cat cat) throws SQLException {
        Map<Integer, Object> param = new HashMap<>();
        param.put(1, cat.getName());
        param.put(2, cat.getAge());
        param.put(3, cat.getCity());

        JDBCUtils.execute(QUERY_INSERT, param);
    }

    @Override
    public void update(int catId, Cat cat) throws SQLException {
        Map<Integer, Object> param = new HashMap<>();
        param.put(1, cat.getName());
        param.put(2, cat.getAge());
        param.put(3, cat.getCity());
        param.put(4, catId);

        JDBCUtils.execute(QUERY_UPDATE, param);
    }

    @Override
    public void deleteCat(int catId) throws SQLException {
        Map<Integer, Object> param = new HashMap<>();
        param.put(1, catId);

        JDBCUtils.execute(QUERY_DELETE, param);
    }

    @Override
    public List<Cat> findAll() throws SQLException {
        List<Cat> results = new ArrayList<>();
        List<?> rows = JDBCUtils.executeResults(QUERY_FIND_ALL);
        for (Object row: rows) {
            results.add(ResultsUtils.fromHashMapToCat((HashMap<String, Object>) row));
        }
        return results;
    }

    @Override
    public Cat findById(int catId) throws SQLException {
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
    public boolean isCatExist(int catId) throws SQLException {
        boolean results = false;
        Map<Integer, Object> params = new HashMap<>();
        params.put(1, catId);
        List<?> rows = JDBCUtils.executeResults(QUERY_IS_EXIST, params);
        for (Object row : rows) {
            results = ResultsUtils.fromHashMapToBool((HashMap<String, Object>) row);
        }
        return results;
    }

    @Override
    public List<Cat> getAllCatsByName(String name) throws SQLException {

        Map<Integer, Object> params = new HashMap<>();
        params.put(1, name);

        List<Cat> results = new ArrayList<>();
        List<?> rows = JDBCUtils.executeResults(QUERY_FIND_NAME,params);
        for (Object row: rows) {
            results.add(ResultsUtils.fromHashMapToCat((HashMap<String, Object>) row));
        }
        return results;
    }

    @Override
    public List<Cat> getAllCatsByWeightOver(float weight) throws SQLException {
        Map<Integer, Object> params = new HashMap<>();
        params.put(1, weight);

        List<Cat> results = new ArrayList<>();
        List<?> rows = JDBCUtils.executeResults(QUERY_FIND_WEIGHT,params);
        for (Object row: rows) {
            results.add(ResultsUtils.fromHashMapToCat((HashMap<String, Object>) row));
        }
        return results;
    }

    @Override
    public List<Cat> getAllCatsByCityAndByWeightUnder(String city, float weight) throws SQLException {
        List<Cat> results = new ArrayList<>();
        Map<Integer, Object> params = new HashMap<>();
        params.put(1, weight);
        params.put(2, city);
        List<?> rows = JDBCUtils.executeResults(QUERY_FIND_WEIGHT_CITY, params);
        for (Object row : rows) {
            results.add(ResultsUtils.fromHashMapToCat((HashMap<String,Object>)row));
        }
        return results;
    }

    @Override
    public double catsAvgWeight() throws SQLException {
        double results = 0;
        List<?>rows = JDBCUtils.executeResults(QUERY_AVERAGE_WEIGHT);
        for (Object row : rows) {
            results = ResultsUtils.fromHashMapToDouble((Map<String,Object>)row);
            break;
        }
        return results;
    }

    @Override
    public int count() throws SQLException {
        int results  = 0;
        List<?> rows = JDBCUtils.executeResults(QUERY_COUNT);
        for (Object row : rows) {
            results = ResultsUtils.fromHashMapToInt((Map<String,Object>)row);
            break;
        }
        return results;
    }
}
