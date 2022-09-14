package com.project.project2.service.facade;

import com.project.project2.bins.Category;
import com.project.project2.bins.Coupon;
import com.project.project2.bins.Customer;
import com.project.project2.excaptions.CouponSystemException;

import java.util.List;

public interface CustomerService {
    boolean login(String email,String password);

    void purchaseCoupon(Coupon coupon) throws CouponSystemException;
    void refundCoupon(Coupon coupon) throws CouponSystemException;
    List<Coupon>getCustomerCoupons();
    List<Coupon>getCustomerCoupons(Category category);
    List<Coupon>getCustomerCoupons(double maxPrice);

    Coupon searchCoupon(int couponId);

    Customer getCustomerDetails();
}
