package ShelKobi.DAO;

import ShelKobi.Beans.Cat;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by kobis on 22 Mar, 2022
 * DAO = Data Access Object
 */
public interface CatDAO {
    void addCat(Cat cat) throws SQLException, InterruptedException;
    void updateCat(int catId, Cat cat) throws SQLException, InterruptedException;
    void deleteCat(int catId) throws SQLException, InterruptedException;

    List<Cat> findAll() throws SQLException, InterruptedException;
    Cat findById(int catId) throws SQLException, InterruptedException;
    boolean isCatExist(int catId) throws SQLException, InterruptedException;

    List<Cat> getAllCatsByName(String name) throws SQLException, InterruptedException;
    List<Cat> getAllCatsByWeightOver(float weight) throws SQLException, InterruptedException;
    List<Cat> getAllCatsByCityAndByWeightUnder(String city,float weight) throws SQLException, InterruptedException;
    double catsAvgWeight() throws SQLException, InterruptedException;
    int count() throws SQLException, InterruptedException;

}
