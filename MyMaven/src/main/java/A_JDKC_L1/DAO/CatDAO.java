package A_JDKC_L1.DAO;

import A_JDKC_L1.Beans.Cat;

import java.sql.SQLException;
import java.util.List;

public interface CatDAO {
    void addCat(Cat cat) throws SQLException;

    void update(int catId, Cat cat) throws SQLException;

    void deleteCat(int catId) throws SQLException;

    List<Cat> findAll() throws SQLException;

    Cat findById(int catId) throws SQLException;

    boolean isCatExist(int catId) throws SQLException;

    List<Cat> getAllCatsByName(String name) throws SQLException;

    List<Cat> getAllCatsByWeightOver(float weight) throws SQLException;

    List<Cat> getAllCatsByCityAndByWeightUnder(String city, float weight) throws SQLException;

    double catsAvgWeight() throws SQLException;

    int count() throws SQLException;
}
