package com.project.project2.service.facade;

import com.project.project2.bins.Category;
import com.project.project2.bins.Coupon;
import com.project.project2.bins.Customer;
import com.project.project2.excaptions.CouponSystemException;
import com.project.project2.excaptions.ExceptionMsg;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class CustomerServiceImpl extends ClientService implements CustomerService {

    private int id;


    @Override
    public boolean login(String email, String password) {
        Customer customer = customerRepository.findByEmailAndPassword(email, password);
        this.id = (customer != null)? customer.getId() : 0 ;
        return this.id != 0;
    }

    @Override
    public void purchaseCoupon(Coupon coupon) throws CouponSystemException {
        if (couponRepository.exitsByCustomerIdAndCouponsId(id, coupon.getId()) == 1 ||
                coupon.getEndDate().equals(Date.valueOf(LocalDate.now())) ||
                coupon.getAmount() <= 0)
            throw new CouponSystemException(ExceptionMsg.PurchaseDenied);
        coupon.setAmount(coupon.getAmount() - 1);
        couponRepository.saveAndFlush(coupon);
        couponRepository.addCouponPurchase(id, coupon.getId());
    }

    @Override
    public void refundCoupon(Coupon coupon) throws CouponSystemException {
        if (couponRepository.exitsByCustomerIdAndCouponsId(id, coupon.getId()) == 0)
            throw new CouponSystemException(ExceptionMsg.RefundDenied);
        coupon.setAmount(coupon.getAmount() + 1);
        couponRepository.saveAndFlush(coupon);
        couponRepository.deleteCouponPurchase(id, coupon.getId());
    }

    @Override
    public List<Coupon> getCustomerCoupons() {
        return couponRepository.findAllByCustomerId(id);
    }

    @Override
    public List<Coupon> getCustomerCoupons(Category category) {
        return couponRepository.findAllByCustomerIdAndCategory(id, category);
    }

    @Override
    public List<Coupon> getCustomerCoupons(double maxPrice) {
        return couponRepository.findAllByCustomerIdAndPriceLessThanEqual(id, maxPrice);
    }

    @Override
    public Coupon searchCoupon(int couponId) {
        return couponRepository.getReferenceById(couponId);
    }

    @Override
    public Customer getCustomerDetails() {
        return customerRepository.getReferenceById(id);
    }
}
