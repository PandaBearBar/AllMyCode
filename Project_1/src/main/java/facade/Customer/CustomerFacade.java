package facade.Customer;

import beans.Category;
import beans.Coupon;
import beans.Customer;
import systemException.SystemException;

import java.sql.SQLException;
import java.util.List;

public interface CustomerFacade {
    boolean login(String email, String password) throws SQLException, InterruptedException;

    Coupon searchCoupon(int CouponId) throws SQLException, InterruptedException, SystemException;

    void purchaseCoupon(Coupon coupon) throws SQLException, InterruptedException, SystemException;

    List<Coupon> getCustomerCoupons() throws SQLException, InterruptedException, SystemException;

    List<Coupon> getCustomerCoupons(Category category) throws SQLException, InterruptedException, SystemException;

    List<Coupon> getCustomerCoupons(double maxPrice) throws SQLException, InterruptedException, SystemException;

    Customer getCustomerDetails() throws SQLException, InterruptedException, SystemException;

    void deleteCouponPurchase(int couponId) throws SQLException, InterruptedException, SystemException;
}
