package dao.Coupon;

import beans.Category;
import beans.Coupon;
import db.JDBCUtils;
import db.ResultsUtils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CouponsDBDAO implements CouponsDAO {

    private static final String QUERY_INSERT = "INSERT INTO `project1`.`coupons` (`Company_Id`, `Category_Id`, `Title`, `Description`, `Start_Date`, `End_Date`, `Amount`, `Price`, `Image`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";
    private static final String QUERY_UPDATE = "UPDATE `project1`.`coupons` SET `Category_Id` = ?, `Title` = ?, `Description` = ? ,`Start_Date` = ? ,`End_Date` = ? ,`Amount` = ? ,`Price` = ? ,`Image` = ? WHERE (`Id` = ?);";
    private static final String QUERY_DELETE = "DELETE FROM `project1`.`coupons` WHERE (`Id` = ?);";
    private static final String QUERY_FIND_ONE = "SELECT * FROM project1.coupons WHERE (`Id` = ?)";
    private static final String QUERY_FIND_ALL = "SELECT * FROM project1.coupons;";

    private static final String QUERY_FIND_BY_COMPANY_ID = "SELECT * FROM project1.coupons where `Company_Id` = ? ;";
    private static final String QUERY_FIND_BY_MAX_PRICE_COMPANY = "SELECT * FROM project1.coupons where `Price` <= ? and `Company_Id` = ? ;";
    private static final String QUERY_FIND_BY_CATEGORY_COMPANY = "SELECT * FROM project1.coupons where `Category_Id` = ? and `Company_Id` = ? ;";

    private static final String QUERY_FIND_COUPONS_BY_CUSTOMER_ID = "" +
            "SELECT `project1`.`coupons`.`*`\n" +
            " FROM `project1`.`customers_vs_coupons` \n" +
            " RIGHT JOIN `project1`.`coupons` \n" +
            " ON `project1`.`customers_vs_coupons`.`coupon_Id` = `project1`.`coupons`.`Id` \n" +
            " WHERE (`customer_Id` = ? );";

    private static final String QUERY_FIND_BY_MAX_PRICE_CUSTOMER = "" +
            "SELECT `project1`.`coupons`.`*`\n" +
            "FROM `project1`.`customers_vs_coupons`\n" +
            "RIGHT JOIN `project1`.`coupons`\n" +
            "ON `project1`.`customers_vs_coupons`.`coupon_Id` = `project1`.`coupons`.`Id`\n" +
            "WHERE (`Price` <= ? and`customer_Id` = ? );";

    private static final String QUERY_FIND_BY_CATEGORY_CUSTOMER = "" +
            "SELECT `project1`.`coupons`.`*`\n" +
            "FROM `project1`.`customers_vs_coupons`\n" +
            "RIGHT JOIN `project1`.`coupons`\n" +
            "ON `project1`.`customers_vs_coupons`.`coupon_Id` = `project1`.`coupons`.`Id`\n" +
            "WHERE (`Category_Id` = ? and`customer_Id` = ? );";

    private static final String QUERY_IS_PURCHASE = "select exists (select * FROM project1.customers_vs_coupons where `Coupon_Id` = ? and `Customer_Id` = ? ) as 'res'";
    private static final String QUERY_INSERT_PURCHASE = "INSERT INTO `project1`.`customers_vs_coupons` (`Customer_Id`,`Coupon_Id`) VALUES (?, ?);";
    private static final String QUERY_DELETE_PURCHASE = "DELETE FROM `project1`.`customers_vs_coupons` WHERE (`Customer_Id` = ? and `Coupon_Id` = ?);";
    private static final String QUERY_IS_COMPANY_NAME_EXIST = "select exists (select * FROM project1.coupons where `Company_Id` = ? and `Title` = ? ) as 'res'";
    private static final String QUERY_IS_ID_COMPANY_EXIST = "select exists (select * FROM project1.coupons where `Company_Id` = ? and `Id` = ? ) as 'res'";

    private static final String QUERY_DATE_NOW = "Delete FROM project1.coupons where End_Date < current_date();";


    @Override
    public void addCoupon(Coupon coupon) throws SQLException, InterruptedException {
        int category_id = coupon.getCategory().ordinal() + 1;
        Map<Integer, Object> params = new HashMap<>();
        params.put(1, coupon.getCompanyId());
        params.put(2, category_id);
        params.put(3, coupon.getTitle());
        params.put(4, coupon.getDescription());
        params.put(5, coupon.getStartDate().toString());
        params.put(6, coupon.getEndDate().toString());
        params.put(7, coupon.getAmount());
        params.put(8, coupon.getPrice());
        params.put(9, coupon.getImage());
        JDBCUtils.execute(QUERY_INSERT, params);
    }

    @Override
    public void updateCoupon(Coupon coupon) throws SQLException, InterruptedException {
        Map<Integer, Object> params = new HashMap<>();
        int category_id = coupon.getCategory().ordinal() + 1;
        params.put(1, category_id);
        params.put(2, coupon.getTitle());
        params.put(3, coupon.getDescription());
        params.put(4, coupon.getStartDate().toString());
        params.put(5, coupon.getEndDate().toString());
        params.put(6, coupon.getAmount());
        params.put(7, coupon.getPrice());
        params.put(8, coupon.getImage());
        params.put(9, coupon.getId());
        JDBCUtils.execute(QUERY_UPDATE, params);
    }

    @Override
    public void deleteCoupon(int CouponId) throws SQLException, InterruptedException {
        Map<Integer, Object> params = new HashMap<>();
        params.put(1, CouponId);
        JDBCUtils.execute(QUERY_DELETE, params);
    }

    @Override
    public void addCouponPurchase(int customerId, int couponId) throws SQLException, InterruptedException {
        Map<Integer, Object> params = new HashMap<>();
        params.put(1, customerId);
        params.put(2, couponId);
        JDBCUtils.execute(QUERY_INSERT_PURCHASE, params);
    }

    @Override
    public boolean isPurchased(int Coupon_Id, int Customer_Id) throws SQLException, InterruptedException {
        boolean results = false;
        Map<Integer, Object> params = new HashMap<>();
        params.put(1, Customer_Id);
        params.put(2, Coupon_Id);
        List<?> rows = JDBCUtils.executeResults(QUERY_IS_PURCHASE, params);
        for (Object row: rows) {
            results = ResultsUtils.fromHashMapToBool((HashMap<String, Object>) row);
            break;
        }
        return results;
    }


    @Override
    public void deleteCouponPurchase(int customerId, int couponId) throws SQLException, InterruptedException {
        if (isPurchased(couponId, customerId)) {
            Map<Integer, Object> params = new HashMap<>();
            params.put(1, couponId);
            params.put(2, customerId);
            JDBCUtils.execute(QUERY_DELETE_PURCHASE, params);
        }
    }

    @Override
    public List<Coupon> getAllCoupons() throws SQLException, InterruptedException {
        List<Coupon> results = new ArrayList<>();
        List<?> rows = JDBCUtils.executeResults(QUERY_FIND_ALL);
        for (Object row: rows) {
            results.add(ResultsUtils.fromHashMapToCoupon((HashMap<String, Object>) row)); //todo what if rows is null
        }
        return results;
    }

    @Override
    public Coupon getOneCoupon(int couponId) throws SQLException, InterruptedException {
        Coupon coupon = null;
        Map<Integer, Object> params = new HashMap<>();
        params.put(1, couponId);
        List<?> rows = JDBCUtils.executeResults(QUERY_FIND_ONE, params);
        for (Object row: rows) {
            coupon = new Coupon(ResultsUtils.fromHashMapToCoupon((HashMap<String, Object>) row));//todo what if rows is null, also you could use get(0)
            break;
        }
        return coupon;
    }

    @Override
    public List<Coupon> getAllCompanyCouponId(int companyId) throws SQLException, InterruptedException {
        List<Coupon> results = new ArrayList<>();
        Map<Integer, Object> params = new HashMap<>();
        params.put(1, companyId);
        List<?> rows = JDBCUtils.executeResults(QUERY_FIND_BY_COMPANY_ID, params);
        for (Object row: rows) {
            results.add(ResultsUtils.fromHashMapToCoupon((HashMap<String, Object>) row));
        }
        return results;
    }

    @Override
    public boolean isNameAndCompanyExists(int companyId, String couponName) throws SQLException, InterruptedException {
        boolean results = false;
        Map<Integer, Object> params = new HashMap<>();
        params.put(1, companyId);
        params.put(2, couponName);
        List<?> rows = JDBCUtils.executeResults(QUERY_IS_COMPANY_NAME_EXIST, params);
        for (Object row: rows) {
            results = ResultsUtils.fromHashMapToBool((HashMap<String, Object>) row);
            break;
        }
        return results;
    }

    @Override
    public boolean isIDAndCompanyExists(int companyId, int couponId) throws SQLException, InterruptedException {
        boolean results = false;
        Map<Integer, Object> params = new HashMap<>();
        params.put(1, companyId);
        params.put(2, couponId);
        List<?> rows = JDBCUtils.executeResults(QUERY_IS_ID_COMPANY_EXIST, params);
        for (Object row: rows) {
            results = ResultsUtils.fromHashMapToBool((HashMap<String, Object>) row);
            break;
        }
        return results;
    }

    @Override
    public List<Coupon> getAllCompanyCouponCategoryCompany(Category category, int companyId) throws SQLException, InterruptedException {
        List<Coupon> results = new ArrayList<>();
        int category_id = category.ordinal() + 1;
        Map<Integer, Object> params = new HashMap<>();
        params.put(1, category_id);
        params.put(2, companyId);
        List<?> rows = JDBCUtils.executeResults(QUERY_FIND_BY_CATEGORY_COMPANY, params);
        for (Object row: rows) {
            results.add(ResultsUtils.fromHashMapToCoupon((HashMap<String, Object>) row));//todo what if rows is null
        }
        return results;
    }

    @Override
    public List<Coupon> getAllCompanyCouponPriceCompany(double maxPrice, int companyId) throws SQLException, InterruptedException {
        List<Coupon> results = new ArrayList<>();
        Map<Integer, Object> params = new HashMap<>();
        params.put(1, maxPrice);
        params.put(2, companyId);
        List<?> rows = JDBCUtils.executeResults(QUERY_FIND_BY_MAX_PRICE_COMPANY, params);
        for (Object row: rows) {
            results.add(ResultsUtils.fromHashMapToCoupon((HashMap<String, Object>) row));//todo what if rows is null
        }
        return results;
    }


    @Override
    public List<Coupon> getAllCustomerCouponCategoryCustomer(Category category, int customerId) throws SQLException, InterruptedException {
        List<Coupon> results = new ArrayList<>();
        int category_id = category.ordinal();
        Map<Integer, Object> params = new HashMap<>();
        params.put(1, category_id + 1);
        params.put(2, customerId);
        List<?> rows = JDBCUtils.executeResults(QUERY_FIND_BY_CATEGORY_CUSTOMER, params);
        for (Object row: rows) {
            results.add(ResultsUtils.fromHashMapToCoupon((HashMap<String, Object>) row));
        }
        // todo
        return results;
    }

    @Override
    public List<Coupon> getAllCustomerCouponPriceCustomer(double maxPrice, int customerId) throws SQLException, InterruptedException {
        List<Coupon> results = new ArrayList<>();
        Map<Integer, Object> params = new HashMap<>();
        params.put(1, maxPrice);
        params.put(2, customerId);
        List<?> rows = JDBCUtils.executeResults(QUERY_FIND_BY_MAX_PRICE_CUSTOMER, params);
        for (Object row: rows) {
            results.add(ResultsUtils.fromHashMapToCoupon((HashMap<String, Object>) row));
        }
        return results;
    }


    @Override
    public List<Coupon> getAllCouponByCustomer(int customer_Id) throws SQLException, InterruptedException {
        List<Coupon> results = new ArrayList<>();
        Map<Integer, Object> params = new HashMap<>();
        params.put(1, customer_Id);
        List<?> rows = JDBCUtils.executeResults(QUERY_FIND_COUPONS_BY_CUSTOMER_ID, params);
        for (Object row: rows) {
            results.add(ResultsUtils.fromHashMapToCoupon((HashMap<String, Object>) row));
        }
        return results;
    }

    public void ExCoupon() throws SQLException, InterruptedException {
        JDBCUtils.executeNoKey(QUERY_DATE_NOW);
    }
}
