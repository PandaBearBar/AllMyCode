package facade.Customer;

import beans.Category;
import beans.Coupon;
import beans.Customer;
import facade.Client.ClientFacade;
import systemException.ExceptionMSG;
import systemException.SystemException;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class CustomerFacadeImpl extends ClientFacade implements CustomerFacade {
    private int customerId;
    private boolean login;

    public CustomerFacadeImpl() throws SQLException {
    }

    public CustomerFacadeImpl(int customerId) throws SQLException {
        this.customerId = customerId;
    }

    private void loginMsg() throws SystemException {
        if (!login) throw new SystemException(ExceptionMSG.Logout);
    }

    @Override
    public boolean login(String email, String password) throws SQLException, InterruptedException {
        return login = customersDAO.isCustomerExist(email, password);
    }

    @Override
    public Coupon searchCoupon(int CouponId) throws SQLException, InterruptedException, SystemException {
        return couponsDAO.getOneCoupon(CouponId);
    }


    @Override
    public void purchaseCoupon(Coupon coupon) throws SQLException, InterruptedException, SystemException {
        if (coupon.getAmount() <= 0) throw new SystemException(ExceptionMSG.Purchase_Coupon_END_Amount);
        if (coupon.getEndDate().equals(Date.valueOf(LocalDate.now())))
            throw new SystemException(ExceptionMSG.Purchase_Coupon_END_Time);
        if (couponsDAO.isPurchased(coupon.getId(), customerId))
            throw new SystemException(ExceptionMSG.Purchase_Coupon_X_Times);
        coupon.setAmount(coupon.getAmount() - 1);
        couponsDAO.updateCoupon(coupon);
        couponsDAO.addCouponPurchase(customerId, coupon.getId());
    }

    @Override
    public List<Coupon> getCustomerCoupons() throws SQLException, InterruptedException, SystemException {
        return couponsDAO.getAllCouponByCustomer(customerId);
    }


    @Override
    public List<Coupon> getCustomerCoupons(Category category) throws SQLException, InterruptedException, SystemException {
        loginMsg();
        return couponsDAO.getAllCustomerCouponCategoryCustomer(category, customerId);
    }


    @Override
    public List<Coupon> getCustomerCoupons(double maxPrice) throws SQLException, InterruptedException, SystemException {
        loginMsg();
        return couponsDAO.getAllCustomerCouponPriceCustomer(maxPrice, customerId);
    }

    @Override
    public Customer getCustomerDetails() throws SQLException, InterruptedException, SystemException {
        loginMsg();
        Customer customer = customersDAO.getOneCustomer(customerId);
        customer.setCoupons(couponsDAO.getAllCouponByCustomer(customerId));
        return customer;
    }

    @Override
    public void deleteCouponPurchase(int couponId) throws SQLException, InterruptedException, SystemException {
        if (couponsDAO.isPurchased(couponId, customerId))
            throw new SystemException(ExceptionMSG.Purchase_NOT_EXIST);
        couponsDAO.deleteCouponPurchase(customerId, couponId);

    }

}
