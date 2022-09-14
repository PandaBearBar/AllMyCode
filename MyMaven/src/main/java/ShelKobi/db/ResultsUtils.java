package ShelKobi.db;

import ShelKobi.Beans.Cat;
import ShelKobi.Beans.Person;

import java.util.HashMap;

/**
 * Created by kobis on 22 Mar, 2022
 */
public class ResultsUtils {

    public static Cat fromHashMapToCat(HashMap<String, Object> row) {
        int id = (int) row.get("id");
        String name = (String) row.get("name");
        double val = (double) row.get("weight");
        float weight = (float) val;
        String city = (String) row.get("city");
        return new Cat(id, name, weight, city);
    }

    public static boolean fromHashMapToBool(HashMap<String,Object> row){
        long result = (long) row.get("res");
        return result == 1;
    }
    public static double fromHashMapTodouble(HashMap<String,Object> row) {
        return (double) row.get("res");
    }

    public static long fromHashMapToInt(HashMap<String, Object> row) {
        return (long)row.get("res");
    }

    public static Person fromHashMapToPerson(HashMap<String, Object> row) {
        int id = (int) row.get("id");
        String last_name = (String)row.get("last_name");
        String first_name = (String)row.get("first_name");
        String phone_number = (String)row.get("phone_number");
        String city = (String) row.get("city");
        return new Person(id,last_name,first_name,phone_number,city);


    }
}
