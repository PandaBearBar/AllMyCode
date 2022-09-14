package db;

import beans.Category;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JDBCUtils {
    //Utils to create Data Base :
    public static final String URL =
            "jdbc:mysql://localhost:3306?createDatabaseIfNotExist=TRUE&useTimezone=TRUE&serverTimezone=UTC";

    public static final String USER =
            "root";

    public static final String PASSWORD =
            "1234";

    private static final String QUERY_CREATE_SCHEMA =
            "create schema Project1";

    private static final String QUERY_DROP_SCHEMA =
            "drop schema Project1";

    private static final String QUERY_CREATE_TABLE_COMPANIES =
            "CREATE TABLE `project1`.`companies` (\n" +
                    "  `Id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `Name` VARCHAR(45) NOT NULL,\n" +
                    "  `Email` VARCHAR(45) NOT NULL,\n" +
                    "  `Password` VARCHAR(45) NOT NULL,\n" +
                    "  PRIMARY KEY (`Id`));\n";

    private static final String QUERY_CREATE_TABLE_CUSTOMERS =
            "CREATE TABLE `project1`.`customers` (\n" +
                    "  `Id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `First_Name` VARCHAR(45) NOT NULL,\n" +
                    "  `Last_Name` VARCHAR(45) NOT NULL,\n" +
                    "  `Email` VARCHAR(45) NOT NULL,\n" +
                    "  `Password` VARCHAR(45) NOT NULL,\n" +
                    "  PRIMARY KEY (`Id`));\n";

    private static final String QUERY_CREATE_TABLE_CATEGORIES =
            "CREATE TABLE `project1`.`categories` (\n" +
                    "  `Id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `Name` VARCHAR(45) NOT NULL,\n" +
                    "  PRIMARY KEY (`Id`));\n";

    private static final String QUERY_CREATE_TABLE_COUPONS =
            "CREATE TABLE `project1`.`coupons` (\n" +
                    "  `Id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `Company_Id` INT(11) NOT NULL,\n" +
                    "  `Category_Id` INT(11) NOT NULL,\n" +
                    "  `Title` VARCHAR(45) NOT NULL,\n" +
                    "  `Description` VARCHAR(45) NOT NULL,\n" +
                    "  `Start_Date` DATE NOT NULL,\n" +
                    "  `End_Date` DATE NOT NULL,\n" +
                    "  `Amount` INT(11) NOT NULL,\n" +
                    "  `Price` DOUBLE NOT NULL,\n" +
                    "  `Image` VARCHAR(45) NOT NULL,\n" +
                    "  PRIMARY KEY (`Id`),\n" +
                    "  INDEX `Company_idx` (`Company_Id` ASC) VISIBLE,\n" +
                    "  INDEX `Category_idx` (`Category_Id` ASC) VISIBLE,\n" +
                    "  CONSTRAINT `Company`\n" +
                    "    FOREIGN KEY (`Company_Id`)\n" +
                    "    REFERENCES `project1`.`companies` (`Id`)\n" +
                    "    ON DELETE NO ACTION\n" +
                    "    ON UPDATE NO ACTION,\n" +
                    "  CONSTRAINT `Category`\n" +
                    "    FOREIGN KEY (`Category_Id`)\n" +
                    "    REFERENCES `project1`.`categories` (`Id`)\n" +
                    "    ON DELETE NO ACTION\n" +
                    "    ON UPDATE NO ACTION);";

    private static final String QUERY_CREATE_TABLE_CUSTOMERS_VS_COUPONS =
            "CREATE TABLE `project1`.`customers_vs_coupons` (\n" +
                    "  `customer_Id` INT NOT NULL,\n" +
                    "  `coupon_Id` INT NOT NULL,\n" +
                    "  PRIMARY KEY (`customer_Id`, `coupon_Id`),\n" +
                    "  INDEX `Coupon_idx` (`coupon_Id` ASC) VISIBLE,\n" +
                    "  CONSTRAINT `Customer`\n" +
                    "    FOREIGN KEY (`customer_Id`)\n" +
                    "    REFERENCES `project1`.`customers` (`Id`)\n" +
                    "    ON DELETE NO ACTION\n" +
                    "    ON UPDATE NO ACTION,\n" +
                    "  CONSTRAINT `Coupon`\n" +
                    "    FOREIGN KEY (`coupon_Id`)\n" +
                    "    REFERENCES `project1`.`coupons` (`Id`)\n" +
                    "    ON DELETE NO ACTION\n" +
                    "    ON UPDATE NO ACTION)\n" +
                    "ENGINE = InnoDB;";


    private static final String QUERY_ADD = "INSERT INTO `project1`.`categories` (`Name`) VALUES (?);";

    private static final String QUERY_MOSHE = "SET SQL_SAFE_UPDATES = 0";
    private static final String QUERY_KOBI = "SET SQL_SAFE_UPDATES = 1";


    public static void addAllCategories() throws SQLException, InterruptedException {
        for (Category c: Category.values()) {
            Map<Integer, Object> params = new HashMap<>();
            params.put(1, c.name());
            JDBCUtils.execute(QUERY_ADD, params);
        }
    }

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void databaseStrategy() throws SQLException, InterruptedException {
        try {
            execute(QUERY_DROP_SCHEMA);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        execute(QUERY_CREATE_SCHEMA);
        execute(QUERY_CREATE_TABLE_CATEGORIES);
        execute(QUERY_CREATE_TABLE_COMPANIES);
        execute(QUERY_CREATE_TABLE_COUPONS);
        execute(QUERY_CREATE_TABLE_CUSTOMERS);
        execute(QUERY_CREATE_TABLE_CUSTOMERS_VS_COUPONS);
        addAllCategories();
    }

    public static Connection getConnection() throws SQLException, InterruptedException {
        return ConnectionPool.getInstance().getConnection();
    }

    public static void closeConnection(Connection conn) throws SQLException {
        ConnectionPool.getInstance().restoreConnection(conn);
    }

    public static void closePreparedStatement(PreparedStatement statement) throws SQLException {
        statement.close();
    }

    public static void closeResultSet(ResultSet resultSet) throws SQLException {
        resultSet.close();
    }

    public static void closeResources(Connection conn, PreparedStatement statement) throws SQLException {
        closePreparedStatement(statement);
        closeConnection(conn);
    }

    public static void closeResources(Connection conn, PreparedStatement statement, ResultSet resultSet) throws SQLException {
        closeResultSet(resultSet);
        closeResources(conn, statement);
    }

    public static void executeNoKey(String sql) throws SQLException, InterruptedException {
        execute(QUERY_MOSHE);
        execute(sql);
        execute(QUERY_KOBI);
    }


    public static void execute(String sql) throws SQLException, InterruptedException {

        //Step 2 - Open Connection
        Connection conn = getConnection();

        //Step 3 - Prepared Statement
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.execute();

        //Step 5 - Close Resources
        closeResources(conn, statement);
    }


    public static List<?> executeResults(String sql) throws SQLException, InterruptedException {

        //Step 2 - Open Connection
        Connection conn = getConnection();

        //Step 3 - Prepared Statement
        PreparedStatement statement = conn.prepareStatement(sql);

        //Step 4 - ResultSet
        ResultSet resultSet = statement.executeQuery();
        List<?> rows = resultSetToArrayList(resultSet);

        //Step 5 - Close Resources
        closeResources(conn, statement, resultSet);

        return rows;
    }

    public static List<?> executeResults(String sql, Map<Integer, Object> map) throws SQLException, InterruptedException {

        //Step 2 - Open Connection
        Connection conn = getConnection();

        //Step 3 - Prepared Statement
        PreparedStatement statement = conn.prepareStatement(sql);
        addParams(statement, map);

        //Step 4 - ResultSet
        ResultSet resultSet = statement.executeQuery();
        List<?> rows = resultSetToArrayList(resultSet);

        //Step 5 - Close Resources
        closeResources(conn, statement, resultSet);

        return rows;
    }


    public static void execute(String sql, Map<Integer, Object> map) throws SQLException, InterruptedException {

        //Step 2 - Open Connection
        Connection conn = getConnection();

        //Step 3 - Prepared Statement
        PreparedStatement statement = conn.prepareStatement(sql);
        addParams(statement, map);

        statement.execute();

        //Step 5 - Close Resources
        closeResources(conn, statement);
    }


    public static void addParams(PreparedStatement statement, Map<Integer, Object> map) throws SQLException {
        for (Map.Entry<Integer, Object> entry: map.entrySet()) {
            Integer key = entry.getKey();
            Object obj = entry.getValue();
            if (obj instanceof Integer) {
                statement.setInt(key, (int) obj);
            } else if (obj instanceof String) {
                statement.setString(key, (String) obj);
            } else if (obj instanceof Double) {
                statement.setDouble(key, (double) obj);
            } else if (obj instanceof Float) {
                statement.setDouble(key, (Float) obj);
            }
        }
    }


    public static List<?> resultSetToArrayList(ResultSet rs) throws SQLException {

        ResultSetMetaData md = rs.getMetaData();
        int columns = md.getColumnCount();

        List<HashMap<String, Object>> list = new ArrayList<>();

        while (rs.next()) {
            HashMap<String, Object> row = new HashMap<>(columns);
            for (int i = 1; i <= columns; ++i) {
                row.put(md.getColumnName(i), rs.getObject(i));
            }
            list.add(row);
        }

        return list;
    }
}
