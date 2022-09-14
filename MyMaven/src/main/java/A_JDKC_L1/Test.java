package A_JDKC_L1;


import A_JDKC_L1.Beans.Cat;
import A_JDKC_L1.DAO.CatDAO;
import A_JDKC_L1.DAO.CatDAOlmpl;
import A_JDKC_L1.db.JDBCUtils;

import java.sql.SQLException;

public class Test {
    public static void main(String[] args) throws SQLException {

        Cat c1 = new Cat("A", 4.5f, "A");
        Cat c2 = new Cat("B", 4.6f, "B");
        Cat c3 = new Cat("C", 4.7f, "C");
        JDBCUtils.databaseStrategy();
        CatDAOlmpl CatDAO = new CatDAOlmpl();
        CatDAO.addCat(c1);
        CatDAO.addCat(c2);
        CatDAO.addCat(c3);
        CatDAO.addCat(new Cat("AD", 5f, "D"));
        CatDAO.addCat(new Cat("BD", 5f, "D"));
        CatDAO.addCat(new Cat("CD", 5f, "D"));
        CatDAO.addCat(new Cat("DD", 5f, "D"));
        CatDAO.addCat(new Cat("ED", 5f, "D"));
        CatDAO.addCat(new Cat("BA", 4.5f, "A"));
        System.out.println("Cats ADDED");
        System.out.println(CatDAO.findAll());
        c1.setAge(80f);
        CatDAO.update(1, c1);
        System.out.println(CatDAO.findAll());
        System.out.println("Cat Updated");
        CatDAO.deleteCat(2);
        System.out.println("Cat Eliminate WOHAHAHAHAHAHAHAHAH");
        System.out.println(CatDAO.findAll());
        /* */
        System.out.println(CatDAO.findById(1));
        System.out.println(CatDAO.isCatExist(5));
        System.out.println(CatDAO.getAllCatsByWeightOver(4.9f));
        System.out.println(CatDAO.getAllCatsByName("A"));
        System.out.println(CatDAO.catsAvgWeight());
        System.out.println(CatDAO.count());
        System.out.println(CatDAO.getAllCatsByCityAndByWeightUnder("D",6f));

    }
}
