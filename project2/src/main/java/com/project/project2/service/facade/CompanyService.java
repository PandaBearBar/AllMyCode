package com.project.project2.service.facade;

import com.project.project2.bins.Category;
import com.project.project2.bins.Company;
import com.project.project2.bins.Coupon;
import com.project.project2.excaptions.CouponSystemException;

import java.util.List;

public interface CompanyService {
    boolean login(String email, String password);
    void addCoupon(Coupon coupon) throws CouponSystemException;
    void updateCoupon(Coupon coupon) throws CouponSystemException;
    void deleteCoupon(int couponId) throws CouponSystemException;
    List<Coupon> getCompanyCoupons();
    List<Coupon> getCompanyCoupons(Category category);
    List<Coupon> getCompanyCoupons(double maxPrice);
    Coupon findSingleCoupon( int id) throws CouponSystemException;
    Company getCompanyDetails();

}
