package facade.Admin;

import beans.Company;
import beans.Coupon;
import beans.Customer;
import facade.Client.ClientFacade;
import systemException.ExceptionMSG;
import systemException.SystemException;

import java.sql.SQLException;
import java.util.List;


public class AdminFacadeImpl extends ClientFacade implements AdminFacade {
    private final static String EMAIL = "admin@admin.com";
    private final static String PASSWORD = "admin";

    public AdminFacadeImpl() throws SQLException {
    }

    @Override
    public boolean login(String email, String password) {
        return EMAIL.equals(email) && PASSWORD.equals(password);
    }

    @Override
    public void addCompany(Company company) throws SQLException, InterruptedException, SystemException {
        if (companiesDAO.isNameExists(company.getName())) throw new SystemException(ExceptionMSG.Company_Exist);
        if (companiesDAO.isEmailExists(company.getEmail())) throw new SystemException(ExceptionMSG.Email_Exist);
        companiesDAO.addCompany(company);
    }

    @Override
    public void updateCompany(Company company) throws SQLException, InterruptedException, SystemException {
        if (!companiesDAO.isNameExists(company.getName()))
            throw new SystemException(ExceptionMSG.Company_Not_Same_Name);
        if (!company.getName().equals(companiesDAO.getOneCompany(company.getId()).getName()))
            throw new SystemException(ExceptionMSG.Company_Not_Same_ID);
        companiesDAO.updateCompany(company);
    }

    @Override
    public void deleteCompany(int company) throws SQLException, InterruptedException {
        companiesDAO.deleteAllCompany(company);
    }

    @Override
    public List<Company> getAllCompanies() throws SQLException, InterruptedException {
        return companiesDAO.getAllCompanies();
    }

    @Override
    public Company getOneCompany(int companyId) throws SQLException, InterruptedException, SystemException {
        Company company = companiesDAO.getOneCompany(companyId);
        if (company == null) throw new SystemException(ExceptionMSG.Company_NOT_Exist);
        return company;
    }

    @Override
    public void addCustomer(Customer customer) throws SQLException, InterruptedException, SystemException {
        if (customersDAO.isEmailExists(customer.getEmail())) throw new SystemException(ExceptionMSG.Email_Exist);
        customersDAO.addCustomer(customer);
    }

    @Override
    public void updateCustomer(Customer customer) throws SystemException, SQLException, InterruptedException {
        if (!customersDAO.IdExist(customer.getId())) throw new SystemException(ExceptionMSG.Customer_Not_Same_ID);
        customersDAO.updateCustomer(customer);
    }

    @Override
    public void deleteCustomer(int customerId) throws SQLException, InterruptedException {
        customersDAO.deleteCustomerAll(customerId);
    }

    @Override
    public List<Customer> getAllCustomer() throws SQLException, InterruptedException {
        return customersDAO.getAllCustomers();
    }

    @Override
    public Customer getOneCustomer(int customerId) throws SQLException, InterruptedException {
        return customersDAO.getOneCustomer(customerId);
    }

    @Override
    public List<Coupon> showAllCoupons() throws SQLException, InterruptedException {
        return couponsDAO.getAllCoupons();
    }


}
