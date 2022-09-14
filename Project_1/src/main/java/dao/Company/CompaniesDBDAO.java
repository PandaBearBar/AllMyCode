package dao.Company;

import beans.Company;
import db.ConnectionPool;
import db.JDBCUtils;
import db.ResultsUtils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CompaniesDBDAO implements CompaniesDAO {
    private ConnectionPool connectionPool = ConnectionPool.getInstance();

    public CompaniesDBDAO() throws SQLException {
    }

    //private static int companyId=1;

    private static final String QUERY_IS_EMAIL_PASSWORD_EXIST = "select exists (select * FROM project1.companies where `Password` = ? and `Email` = ? ) as 'res'";
    private static final String QUERY_IS_ID_EXIST = "select exists (select * FROM project1.companies where `Id` = ? ) as 'res'";
    private static final String QUERY_IS_EMAIL_EXIST = "select exists (select * FROM project1.companies where `Email` = ? ) as 'res'";
    private static final String QUERY_IS_NAME_EXIST = "select exists (select * FROM project1.companies where  `Name` = ? ) as 'res'";
    private static final String QUERY_UPDATE = "UPDATE `project1`.`companies` SET `Name` = ?, `Email` = ?, `Password` = ? WHERE (`Id` = ?);";
    private static final String QUERY_INSERT = "INSERT INTO `project1`.`companies` (`Name`, `Email`, `Password`) VALUES (?, ?, ?);";
    private static final String QUERY_DELETE = "DELETE FROM `project1`.`companies` WHERE (`Id` = ?);";
    private static final String QUERY_FIND_ALL = "SELECT * FROM project1.companies;";
    private static final String QUERY_FIND_ONE = "SELECT * FROM project1.companies WHERE (`Id` = ?)";
    private static final String QUERY_FIND_ONE_EMAIL_AND_PASSWORD = "SELECT * FROM project1.companies WHERE (`Email` = ? and `Password` = ?)";
    private static final String QUERY_DELETE_ALL_RELATED = "" +
            "DELETE `project1`.`customers_vs_coupons` , `project1`.`coupons`\n" +
            "FROM `project1`.`customers_vs_coupons` \n" +
            "INNER JOIN `project1`.`coupons` ON `project1`.`customers_vs_coupons` .`coupon_Id` = `project1`.`coupons`.`Id`\n" +
            "WHERE (`Company_Id` = ?);";
    private static final String QUERY_SAFE_OFF_DELETE = "SET `SQL_SAFE_UPDATES`=0;";
    private static final String QUERY_SAFE_ON_DELETE = "SET `SQL_SAFE_UPDATES`=1;";

    @Override
    public boolean isCompanyExists(String email, String password) throws SQLException, InterruptedException {
        boolean results = false;
        Map<Integer, Object> params = new HashMap<>();
        params.put(1, password);
        params.put(2, email);
        List<?> rows = JDBCUtils.executeResults(QUERY_IS_EMAIL_PASSWORD_EXIST, params);
        for (Object row: rows) {
            results = ResultsUtils.fromHashMapToBool((HashMap<String, Object>) row); //todo what if rows is null, also you could use get(0)
            break;
        }
        return results;
    }

    @Override
    public void addCompany(Company company) throws SQLException, InterruptedException {
        Map<Integer, Object> params = new HashMap<>();
        params.put(1, company.getName());
        params.put(2, company.getEmail());
        params.put(3, company.getPassword());
        JDBCUtils.execute(QUERY_INSERT, params);
    }

    @Override
    public void updateCompany(Company company) throws SQLException, InterruptedException {
        Map<Integer, Object> params = new HashMap<>();
        params.put(1, company.getName());
        params.put(2, company.getEmail());
        params.put(3, company.getPassword());
        params.put(4, company.getId());
        JDBCUtils.execute(QUERY_UPDATE, params);
    }

    @Override
    public List<Company> getAllCompanies() throws SQLException, InterruptedException {
        List<Company> results = new ArrayList<>();
        List<?> rows = JDBCUtils.executeResults(QUERY_FIND_ALL);
        for (Object row: rows) {
            results.add(ResultsUtils.fromHashMapToCompany((HashMap<String, Object>) row)); // todo what if null
        }
        return results;
    }

    @Override
    public Company getOneCompany(int CompanyId) throws SQLException, InterruptedException {
        Company company = null;
        Map<Integer, Object> params = new HashMap<>();
        params.put(1, CompanyId);
        List<?> rows = JDBCUtils.executeResults(QUERY_FIND_ONE, params);
        for (Object row: rows) {
            company = new Company(ResultsUtils.fromHashMapToCompany((HashMap<String, Object>) row)); //todo what if rows is null, also you could use get(0)
            break;
        }
        return company;
    }

    @Override
    public Company getOneCompany(String email, String password) throws SQLException, InterruptedException {
        Company company = null;
        Map<Integer, Object> params = new HashMap<>();
        params.put(1, email);
        params.put(2, password);
        List<?> rows = JDBCUtils.executeResults(QUERY_FIND_ONE_EMAIL_AND_PASSWORD, params);
        for (Object row: rows) {
            company = new Company(ResultsUtils.fromHashMapToCompany((HashMap<String, Object>) row)); //todo what if rows is null, also you could use get(0)
            break;
        }
        return company;
    }

    @Override
    public boolean isEmailExists(String email) throws SQLException, InterruptedException {
        boolean results = false;
        Map<Integer, Object> params = new HashMap<>();
        params.put(1, email);
        List<?> rows = JDBCUtils.executeResults(QUERY_IS_EMAIL_EXIST, params);
        for (Object row: rows) {
            results = ResultsUtils.fromHashMapToBool((HashMap<String, Object>) row); //todo what if rows is null, also you could use get(0)
            break;
        }
        return results;
    }

    @Override
    public boolean isNameExists(String name) throws SQLException, InterruptedException {
        boolean results = false;
        Map<Integer, Object> params = new HashMap<>();
        params.put(1, name);
        List<?> rows = JDBCUtils.executeResults(QUERY_IS_NAME_EXIST, params);
        for (Object row: rows) {
            results = ResultsUtils.fromHashMapToBool((HashMap<String, Object>) row);//todo what if rows is null, also you could use get(0)
            break;
        }
        return results;
    }

    @Override
    public boolean IdExist(int companyId) throws SQLException, InterruptedException {
        boolean results = false;
        Map<Integer, Object> params = new HashMap<>();
        params.put(1, companyId);
        List<?> rows = JDBCUtils.executeResults(QUERY_IS_ID_EXIST, params);
        for (Object row: rows) {
            results = ResultsUtils.fromHashMapToBool((HashMap<String, Object>) row);//todo what if rows is null, also you could use get(0)
            break;
        }
        return results;
    }

    @Override
    public void deleteAllCompany(int companyId) throws SQLException, InterruptedException {
        Map<Integer, Object> params = new HashMap<>();
        params.put(1, companyId);
        JDBCUtils.execute(QUERY_SAFE_OFF_DELETE);
        JDBCUtils.execute(QUERY_DELETE, params);
        JDBCUtils.execute(QUERY_DELETE_ALL_RELATED, params);
        JDBCUtils.execute(QUERY_SAFE_ON_DELETE);
    }
}
