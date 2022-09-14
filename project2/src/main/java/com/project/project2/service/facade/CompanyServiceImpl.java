package com.project.project2.service.facade;

import com.project.project2.bins.Category;
import com.project.project2.bins.Company;
import com.project.project2.bins.Coupon;
import com.project.project2.excaptions.CouponSystemException;
import com.project.project2.excaptions.ExceptionMsg;
import lombok.*;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class CompanyServiceImpl extends ClientService implements CompanyService{

    private int id;

    @Override
    public boolean login(String email, String password) {
        Company company = companyRepository.findByEmailAndPassword(email, password);
        this.id = (company != null)?company.getId():0;
        return this.id != 0;
    }

    @Override
    public void addCoupon(Coupon coupon) throws CouponSystemException {
        if (couponRepository.existsByCompanyIdAndTitle(id, coupon.getTitle()))
            throw new CouponSystemException(ExceptionMsg.CouponAddDenied);
        coupon.setCompanyId(id);
        couponRepository.save(coupon);
    }

    @Override
    public void updateCoupon(Coupon coupon) throws CouponSystemException {
        if (!couponRepository.existsByCompanyIdAndId(id,coupon.getId()))
            throw new CouponSystemException(ExceptionMsg.CouponUpdateDenied);
        couponRepository.saveAndFlush(coupon);
    }

    @Override
    public void deleteCoupon(int couponId) throws CouponSystemException {
        if (!couponRepository.existsById(couponId))
            throw new CouponSystemException(ExceptionMsg.CouponNotExist);
        couponRepository.deleteById(couponId);
    }

    @Override
    public List<Coupon> getCompanyCoupons() {
        return couponRepository.findAllByCompanyId(id);
    }

    @Override
    public List<Coupon> getCompanyCoupons(Category category) {
        return  couponRepository.findAllByCompanyIdAndCategory(id, category);

    }

    @Override
    public List<Coupon> getCompanyCoupons(double maxPrice) {
        return couponRepository.findAllByCompanyIdAndPriceLessThanEqual(id, maxPrice);

    }

    @Override
    public Coupon findSingleCoupon( int couponId) throws CouponSystemException {
        if (!couponRepository.existsById(couponId))
            throw new CouponSystemException(ExceptionMsg.CouponNotExist);
        return couponRepository.findByCompanyIdAndId(id, couponId);
    }

    @Override
    public Company getCompanyDetails() {
        return companyRepository.getReferenceById(id);
    }
}
