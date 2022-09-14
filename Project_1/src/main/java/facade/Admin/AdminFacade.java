package facade.Admin;

import beans.Company;
import beans.Coupon;
import beans.Customer;
import systemException.SystemException;

import java.sql.SQLException;
import java.util.List;

public interface AdminFacade {
    boolean login(String email, String password) throws SQLException, InterruptedException;

    void addCompany(Company company) throws SQLException, InterruptedException, SystemException;

    void updateCompany(Company company) throws SQLException, InterruptedException, SystemException;

    void deleteCompany(int company) throws SQLException, InterruptedException;

    List<Company> getAllCompanies() throws SQLException, InterruptedException;

    Company getOneCompany(int companyId) throws SQLException, InterruptedException, SystemException;

    void addCustomer(Customer customer) throws SQLException, InterruptedException, SystemException;

    void updateCustomer(Customer customer) throws SystemException, SQLException, InterruptedException;

    void deleteCustomer(int customer) throws SQLException, InterruptedException;

    List<Customer> getAllCustomer() throws SQLException, InterruptedException;

    Customer getOneCustomer(int customerId) throws SQLException, InterruptedException;

    List<Coupon> showAllCoupons() throws SQLException, InterruptedException;
}
