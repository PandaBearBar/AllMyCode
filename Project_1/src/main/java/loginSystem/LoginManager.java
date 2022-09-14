package loginSystem;

import dao.Company.CompaniesDAO;
import dao.Company.CompaniesDBDAO;
import dao.Customer.CustomerDBDAO;
import dao.Customer.CustomersDAO;
import facade.Admin.AdminFacadeImpl;
import facade.Client.ClientFacade;
import facade.Company.CompanyFacadeImpl;
import facade.Customer.CustomerFacadeImpl;

import java.sql.SQLException;

public class LoginManager {
    private static LoginManager Instance;
    private CompaniesDAO companiesDAO = new CompaniesDBDAO();
    private CustomersDAO customersDAO = new CustomerDBDAO();

    private LoginManager() throws SQLException {
    }

    public static LoginManager getInstance() throws SQLException {
        if (Instance == null) {
            synchronized (LoginManager.class) {
                if (Instance == null)
                    Instance = new LoginManager();
            }
        }
        return Instance;
    }

    public ClientFacade login(String email, String password, ClientType clientType) throws SQLException, InterruptedException {
        switch (clientType) {
            case Administrator:
                AdminFacadeImpl adminFacade = new AdminFacadeImpl();
                return (adminFacade.login(email, password)) ? adminFacade : null;
            case Company:
                CompanyFacadeImpl companyFacade = new CompanyFacadeImpl(companiesDAO.getOneCompany(email, password).getId());
                return (companyFacade.login(email, password)) ? companyFacade : null;
            case Customer:
                CustomerFacadeImpl customerFacade = new CustomerFacadeImpl(customersDAO.getOneCustomer(email, password).getId());
                return (customerFacade.login(email, password)) ? customerFacade : null;
            default:
                return null;
        }
    }

    public static ClientFacade logout() {
        return null;
    }
}
