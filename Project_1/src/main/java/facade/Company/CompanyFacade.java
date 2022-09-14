package facade.Company;

import beans.Category;
import beans.Company;
import beans.Coupon;
import systemException.SystemException;

import java.sql.SQLException;
import java.util.List;

public interface CompanyFacade {
    boolean login(String email, String password) throws SQLException, InterruptedException;

    void addCoupon(Coupon coupon) throws SQLException, InterruptedException, SystemException;

    void updateCoupon(Coupon coupon) throws SystemException, SQLException, InterruptedException;

    void deleteCoupon(int couponId) throws SQLException, InterruptedException, SystemException;

    List<Coupon> getCompanyCoupons() throws SQLException, InterruptedException, SystemException;

    List<Coupon> getCompanyCoupons(Category category) throws SQLException, InterruptedException, SystemException;

    List<Coupon> getCompanyCoupons(double maxPrice) throws SQLException, InterruptedException, SystemException;

    Company getCompanyDetails() throws SQLException, InterruptedException, SystemException;

    void quit();

    Coupon getOneCuopon(int i) throws SQLException, InterruptedException;
}
