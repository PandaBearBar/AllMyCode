package A_JDKC_L1.db;

import A_JDKC_L1.Beans.Cat;

import java.util.HashMap;
import java.util.Map;

public class ResultsUtils {


    public static Cat fromHashMapToCat(HashMap<String, Object> row) {
        int id = (int) row.get("id");
        String name = (String) row.get("name");
        double val = (double) row.get("weight");
        float weight = (float) val;
        String city = (String) row.get("city");
        return new Cat(name, weight, city, id);
    }

    public static boolean fromHashMapToBool(HashMap<String,Object> row){
        long result = (long) row.get("res");
        return result == 1;
    }

    public static double fromHashMapToDouble(Map<String, Object> row) {
        return (double) row.get("res");
    }

    public static Integer fromHashMapToInt(Map<String, Object> row) {
        return ((int)((long) row.get("res")));
    }
}

