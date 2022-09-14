package facade.Client;

import dao.Company.CompaniesDAO;
import dao.Company.CompaniesDBDAO;
import dao.Coupon.CouponsDAO;
import dao.Coupon.CouponsDBDAO;
import dao.Customer.CustomerDBDAO;
import dao.Customer.CustomersDAO;

import java.sql.SQLException;

public abstract class ClientFacade {

    protected CompaniesDAO companiesDAO = new CompaniesDBDAO();

    protected CustomersDAO customersDAO = new CustomerDBDAO();

    protected CouponsDAO couponsDAO = new CouponsDBDAO();

    protected ClientFacade() throws SQLException {
    }

    public abstract boolean login(String email, String password) throws SQLException, InterruptedException;

}
