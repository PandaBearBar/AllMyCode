package dao.Company;

import beans.Company;

import java.sql.SQLException;
import java.util.List;

public interface CompaniesDAO {
    boolean isCompanyExists(String email, String password) throws SQLException, InterruptedException;

    void addCompany(Company company) throws SQLException, InterruptedException;

    void updateCompany(Company company) throws SQLException, InterruptedException;

    List<Company> getAllCompanies() throws SQLException, InterruptedException;

    Company getOneCompany(int CompanyId) throws SQLException, InterruptedException;

    Company getOneCompany(String email, String password) throws SQLException, InterruptedException;

    boolean isEmailExists(String email) throws SQLException, InterruptedException;

    boolean isNameExists(String name) throws SQLException, InterruptedException;

    boolean IdExist(int companyId) throws SQLException, InterruptedException; // todo go over dao and see which methods are not implemented

    void deleteAllCompany(int companyId) throws SQLException, InterruptedException;
}

