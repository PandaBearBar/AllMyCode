package dao.Coupon;

import beans.Category;
import beans.Coupon;

import java.sql.SQLException;
import java.util.List;

public interface CouponsDAO {
    void addCoupon(Coupon coupon) throws SQLException, InterruptedException;

    void updateCoupon(Coupon coupon) throws SQLException, InterruptedException;

    void deleteCoupon(int CouponId) throws SQLException, InterruptedException;

    void addCouponPurchase(int customerId, int couponId) throws SQLException, InterruptedException;

    void deleteCouponPurchase(int customerId, int couponId) throws SQLException, InterruptedException;

    List<Coupon> getAllCoupons() throws SQLException, InterruptedException;

    Coupon getOneCoupon(int couponId) throws SQLException, InterruptedException;

    List<Coupon> getAllCompanyCouponId(int companyId) throws SQLException, InterruptedException;

    boolean isNameAndCompanyExists(int CompanyId, String CouponName) throws SQLException, InterruptedException;

    boolean isIDAndCompanyExists(int companyId, int couponId) throws SQLException, InterruptedException;

    List<Coupon> getAllCompanyCouponCategoryCompany(Category category, int companyId) throws SQLException, InterruptedException;

    List<Coupon> getAllCompanyCouponPriceCompany(double maxPrice, int companyId) throws SQLException, InterruptedException;

    List<Coupon> getAllCustomerCouponCategoryCustomer(Category category, int customerId) throws SQLException, InterruptedException;

    List<Coupon> getAllCustomerCouponPriceCustomer(double maxPrice, int customerId) throws SQLException, InterruptedException;

    boolean isPurchased(int Coupon_Id, int Customer_Id) throws SQLException, InterruptedException;

    List<Coupon> getAllCouponByCustomer(int customer_Id) throws SQLException, InterruptedException;

    void ExCoupon() throws SQLException, InterruptedException;
}

