
package A_JDKC_L1.db;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by kobis on 22 Mar, 2022
 */
public class JDBCUtils {

    private static final String URL = "jdbc:mysql://localhost:3306?createDatabaseIfNotExist=TRUE&useTimezone=TRUE&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "1234";


    private static final String QUERY_CREATE_SCHEMA = "create schema java147";
    private static final String QUERY_DROP_SCHEMA = "drop schema java147";
    private static final String QUERY_CREATE_TABLE_CATS = "CREATE TABLE `java147`.`cats` (\n" +
            "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
            "  `name` VARCHAR(30) NOT NULL,\n" +
            "  `weight` DOUBLE NOT NULL,\n" +
            "  `city` VARCHAR(30) NOT NULL,\n" +
            "  PRIMARY KEY (`id`));\n";
    private static final String QUERY_CREATE_TABLE_PEOPLE = "CREATE TABLE `java147`.`people` (\n" +
            "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
            "  `last_name` VARCHAR(30) NOT NULL,\n" +
            "  `first_name` VARCHAR(30) NOT NULL,\n" +
            "  `phone_number` VARCHAR(11) NOT NULL,\n" +
            "  `city` INT NOT NULL,\n" +
            "  PRIMARY KEY (`id`));\n";


    // not relevant for us, since we're using MySQL Driver Type 4
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void databaseStrategy() throws SQLException {
        try {
            execute(QUERY_DROP_SCHEMA);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        execute(QUERY_CREATE_SCHEMA);
        execute(QUERY_CREATE_TABLE_CATS);
        execute(QUERY_CREATE_TABLE_PEOPLE);
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void closeConnection(Connection conn) throws SQLException {
        conn.close();
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


    public static void execute(String sql) throws SQLException {

        //Step 2 - Open Connection
        Connection conn = getConnection();

        //Step 3 - Prepared Statement
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.execute();

        //Step 5 - Close Resources
        closeResources(conn, statement);
    }


    public static List<?> executeResults(String sql) throws SQLException {

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

    public static void execute(String sql, Map<Integer, Object> map) throws SQLException {

        //Step 2 - Open Connection
        Connection conn = getConnection();

        //Step 3 - Prepared Statement
        PreparedStatement statement = conn.prepareStatement(sql);
        addParams(statement, map);

        statement.execute();

        //Step 5 - Close Resources
        closeResources(conn, statement);
    }

    public static List<?> executeResults(String sql,Map<Integer, Object> map) throws SQLException {

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