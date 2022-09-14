package ShelKobi;

import ShelKobi.Beans.Cat;
import ShelKobi.Beans.Person;
import ShelKobi.DAO.CatDAO;
import ShelKobi.DAO.CatDAOImpl;
import ShelKobi.DAO.PersonDAO;
import ShelKobi.DAO.PersonDAOImpl;
import ShelKobi.db.ConnectionPool;
import ShelKobi.db.JDBCUtils;

import java.sql.SQLException;

/**
 * Created by kobis on 22 Mar, 2022
 */
public class Test {

    public static void main(String[] args) throws SQLException, InterruptedException {

        System.out.println("Start");

        //Init Database
        JDBCUtils.databaseStrategy();
/*
        //DAO = Data Access Object
        CatDAO catDAO = new CatDAOImpl();

        System.out.println("@@@@@@@@@@@ Add Cats @@@@@@@@@@@ ");
        Cat c1 = new Cat("Eli", 4.5f, "TLV");
        Cat c2 = new Cat("Elimon", 3.5f, "TLV");
        Cat c3 = new Cat("Mitzi", 6.5f, "JLM");
        Cat c4 = new Cat("Mitzi", 4.5f, "JLM");
        Cat c5 = new Cat("Kitzi", 2.8f, "HFA");
        Cat c6 = new Cat("Pitzi", 4.5f, "JLM");
        catDAO.addCat(c1);
        catDAO.addCat(c2);
        catDAO.addCat(c3);
        catDAO.addCat(c4);
        catDAO.addCat(c5);
        catDAO.addCat(c6);

        catDAO.findAll().forEach(System.out::println);
        System.out.println("@@@@@@@@@@@ Update Cats @@@@@@@@@@@ ");
        c1.setName("Eliyahoo");
        catDAO.updateCat(1, c1);
        catDAO.findAll().forEach(System.out::println);
        System.out.println("@@@@@@@@@@@ Delete Cats @@@@@@@@@@@ ");
        catDAO.deleteCat(2);
        catDAO.findAll().forEach(System.out::println);
        System.out.println("@@@@@@@@@@@ Find Single Cat @@@@@@@@@@@ ");
        System.out.println(catDAO.findById(1));
        System.out.println("@@@@@@@@@@@ Is Cat Exist @@@@@@@@@@@ ");
        System.out.println(catDAO.isCatExist(1)); //true
        System.out.println(catDAO.isCatExist(1750)); //false
        System.out.println("@@@@@@@@@@@ Cats by names @@@@@@@@@@@");
        System.out.println(catDAO.getAllCatsByName("Mitzi"));
        System.out.println("@@@@@@@@@@@ Cats by weight @@@@@@@@@@@");
        System.out.println(catDAO.getAllCatsByWeightOver(4.5f));
        System.out.println("@@@@@@@@@@@ Cats by weight and city @@@@@@@@@@@");
        System.out.println(catDAO.getAllCatsByCityAndByWeightUnder("JLM", 5f));
        System.out.println("@@@@@@@@@@@ Cats avg @@@@@@@@@@@");
        System.out.println(catDAO.catsAvgWeight());
        System.out.println("@@@@@@@@@@@ Cats count @@@@@@@@@@@");
        System.out.println(catDAO.count());
        ConnectionPool.getInstance().closeAllConnections();
        System.out.println("End Cats");
*/
        PersonDAO personDAO = new PersonDAOImpl();
        System.out.println("!!!!ADD!!!!PERSON!!!!");
        personDAO.addPerson(new Person("JOJO","BOBO","051-234-5678","TLV"));
        personDAO.addPerson(new Person("DOJO","ROBO","055-555-5555","TLV"));
        personDAO.addPerson(new Person("MOJO","JOBO","052-555-5755","JLM"));
        personDAO.addPerson(new Person("LOJO","GOBO","051-236-5978","TLV"));
        personDAO.addPerson(new Person("ROJO","ROGO","055-585-5555","TLV"));
        personDAO.addPerson(new Person("BOJO","JOMO","052-555-5885","JLM"));


        System.out.println("Update !");
        personDAO.updatePerson(1, new Person("FOFO","The Driver","051-234-5678","TLV"));

        System.out.println("Delete !");
        personDAO.deletePerson(2);

        System.out.println("Print All");
        personDAO.findAll().forEach(System.out::println);

        System.out.println("find by id");
        System.out.println(personDAO.findById(1));

        System.out.println("finfd if exist");
        System.out.println(personDAO.isPersonExist(1));
        System.out.println(personDAO.isPersonExist(1111));

        System.out.println("END");
    }
}
