package dao.Customer;

import beans.Customer;
import db.JDBCUtils;
import db.ResultsUtils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerDBDAO implements CustomersDAO {


    private static final String QUERY_IS_EMAIL_PASSWORD_EXIST = "select exists (select * FROM project1.customers where `Password` = ? and `Email` = ? ) as 'res'";
    private static final String QUERY_UPDATE = "UPDATE `project1`.`customers` SET `First_Name` = ?,`Last_Name` = ?, `Email` = ?, `Password` = ? WHERE (`Id` = ?);";
    private static final String QUERY_INSERT = "INSERT INTO `project1`.`customers` (`First_Name`,`Last_Name`, `Email`, `Password`) VALUES (?, ?, ?, ?);";
    private static final String QUERY_DELETE = "DELETE FROM `project1`.`customers` WHERE (`Id` = ?);";
    private static final String QUERY_FIND_ALL = "SELECT * FROM project1.customers;";
    private static final String QUERY_FIND_ONE = "SELECT * FROM project1.customers WHERE (`Id` = ?)";
    private static final String QUERY_IS_EMAIL_EXIST = "select exists (select * FROM project1.customers where `Email` = ? ) as 'res'";
    private static final String QUERY_IS_ID_EXIST = "select exists (select * FROM project1.customers where `Id` = ? ) as 'res'";
    private static final String QUERY_FIND_ONE_EMAIL_AND_PASSWORD = "SELECT * FROM project1.customers WHERE (`Email` = ? and `Password` = ?)";
    private static final String QUERY_DELETE_ALL_RELATED = "" +
            "delete FROM project1.customers_vs_coupons where `customer_Id`= ?;";
    private static final String QUERY_SAFE_OFF_DELETE = "SET `SQL_SAFE_UPDATES`=0;";
    private static final String QUERY_SAFE_ON_DELETE = "SET `SQL_SAFE_UPDATES`=1;";


    @Override
    public boolean isCustomerExist(String email, String password) throws SQLException, InterruptedException {
        boolean results = false;
        Map<Integer, Object> params = new HashMap<>();
        params.put(1, password);
        params.put(2, email);
        List<?> rows = JDBCUtils.executeResults(QUERY_IS_EMAIL_PASSWORD_EXIST, params);
        for (Object row: rows) {
            results = ResultsUtils.fromHashMapToBool((HashMap<String, Object>) row);
            break;
        }
        return results;
    }

    @Override
    public void addCustomer(Customer customer) throws SQLException, InterruptedException {
        Map<Integer, Object> params = new HashMap<>();
        params.put(1, customer.getFirstName());
        params.put(2, customer.getLastName());
        params.put(3, customer.getEmail());
        params.put(4, customer.getPassword());
        JDBCUtils.execute(QUERY_INSERT, params);
    }

    @Override
    public void updateCustomer(Customer customer) throws SQLException, InterruptedException {
        Map<Integer, Object> params = new HashMap<>();
        params.put(1, customer.getFirstName());
        params.put(2, customer.getLastName());
        params.put(3, customer.getEmail());
        params.put(4, customer.getPassword());
        params.put(5, customer.getId());
        JDBCUtils.execute(QUERY_UPDATE, params);
    }

    @Override
    public List<Customer> getAllCustomers() throws SQLException, InterruptedException {
        List<Customer> results = new ArrayList<>();
        List<?> rows = JDBCUtils.executeResults(QUERY_FIND_ALL);
        for (Object row: rows) {
            results.add(ResultsUtils.fromHashMapToCustomer((HashMap<String, Object>) row));
        }
        return results;
    }

    @Override
    public Customer getOneCustomer(int CustomerId) throws SQLException, InterruptedException {
        Customer customer = null;
        Map<Integer, Object> params = new HashMap<>();
        params.put(1, CustomerId);
        List<?> rows = JDBCUtils.executeResults(QUERY_FIND_ONE, params);
        for (Object row: rows) {
            customer = new Customer(ResultsUtils.fromHashMapToCustomer((HashMap<String, Object>) row));
            break;
        }
        return customer;
    }

    @Override
    public boolean isEmailExists(String email) throws SQLException, InterruptedException {
        boolean results = false;
        Map<Integer, Object> params = new HashMap<>();
        params.put(1, email);
        List<?> rows = JDBCUtils.executeResults(QUERY_IS_EMAIL_EXIST, params);
        for (Object row: rows) {
            results = ResultsUtils.fromHashMapToBool((HashMap<String, Object>) row);
            break;
        }
        return results;
    }

    @Override
    public boolean IdExist(int customerId) throws SQLException, InterruptedException {
        boolean results = false;
        Map<Integer, Object> params = new HashMap<>();
        params.put(1, customerId);
        List<?> rows = JDBCUtils.executeResults(QUERY_IS_ID_EXIST, params);
        for (Object row: rows) {
            results = ResultsUtils.fromHashMapToBool((HashMap<String, Object>) row);
            break;
        }
        return results;
    }

    @Override
    public Customer getOneCustomer(String email, String password) throws SQLException, InterruptedException {
        Customer customer = null;
        Map<Integer, Object> params = new HashMap<>();
        params.put(1, email);
        params.put(2, password);
        List<?> rows = JDBCUtils.executeResults(QUERY_FIND_ONE_EMAIL_AND_PASSWORD, params);
        for (Object row: rows) {
            customer = new Customer(ResultsUtils.fromHashMapToCustomer((HashMap<String, Object>) row));
            break;
        }
        return customer;
    }

    @Override
    public void deleteCustomerAll(int customerId) throws SQLException, InterruptedException {
        Map<Integer, Object> params = new HashMap<>();
        params.put(1, customerId);
        JDBCUtils.execute(QUERY_SAFE_OFF_DELETE);
        JDBCUtils.execute(QUERY_DELETE, params);
        JDBCUtils.execute(QUERY_DELETE_ALL_RELATED, params);
        JDBCUtils.execute(QUERY_SAFE_ON_DELETE);
    }

}
