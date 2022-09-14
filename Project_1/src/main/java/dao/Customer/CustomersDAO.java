package dao.Customer;

import beans.Customer;

import java.sql.SQLException;
import java.util.List;

public interface CustomersDAO {

    boolean isCustomerExist(String email, String password) throws SQLException, InterruptedException;

    void addCustomer(Customer customer) throws SQLException, InterruptedException;

    void updateCustomer(Customer customer) throws SQLException, InterruptedException;

    List<Customer> getAllCustomers() throws SQLException, InterruptedException;

    Customer getOneCustomer(int CustomerId) throws SQLException, InterruptedException;

    boolean isEmailExists(String email) throws SQLException, InterruptedException;

    boolean IdExist(int customerId) throws SQLException, InterruptedException;

    Customer getOneCustomer(String email, String password) throws SQLException, InterruptedException;

    void deleteCustomerAll(int customerId) throws SQLException, InterruptedException;

}
