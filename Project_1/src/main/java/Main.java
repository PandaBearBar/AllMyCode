import systemException.SystemException;
import tests.Test;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SystemException, SQLException, InterruptedException {
        Test test = new Test();
        test.testAll();
    }
}
