package facade.Company;

import beans.Category;
import beans.Company;
import beans.Coupon;
import facade.Client.ClientFacade;
import systemException.ExceptionMSG;
import systemException.SystemException;

import java.sql.SQLException;
import java.util.List;

public class CompanyFacadeImpl extends ClientFacade implements CompanyFacade {
    private int companyId;
    private boolean login;

    public CompanyFacadeImpl() throws SQLException {

    }

    public CompanyFacadeImpl(int companyId) throws SQLException {
        this.companyId = companyId;
    }

    public int getCompanyId() {
        return companyId;
    }

    @Override
    public boolean login(String email, String password) throws SQLException, InterruptedException {
        return login = companiesDAO.isCompanyExists(email, password);
    }

    @Override
    public void addCoupon(Coupon coupon) throws SQLException, InterruptedException, SystemException {
        if (couponsDAO.isNameAndCompanyExists(companyId, coupon.getTitle()))
            throw new SystemException(ExceptionMSG.Coupon_Name_Exist);
        couponsDAO.addCoupon(coupon);
    }

    @Override
    public void updateCoupon(Coupon coupon) throws SystemException, SQLException, InterruptedException {
        if (!companiesDAO.IdExist(companyId))
            throw new SystemException(ExceptionMSG.Company_Not_Same_ID);
        if (!couponsDAO.isIDAndCompanyExists(companyId, coupon.getId()))
            throw new SystemException(ExceptionMSG.Coupon_Not_Same_ID);
        couponsDAO.updateCoupon(coupon);
    }

    @Override
    public void deleteCoupon(int couponId) throws SQLException, InterruptedException, SystemException {
        if (!couponsDAO.isIDAndCompanyExists(companyId, couponId))
            throw new SystemException(ExceptionMSG.Coupon_Not_Same_ID);
        couponsDAO.deleteCoupon(couponId);
    }

    @Override
    public List<Coupon> getCompanyCoupons() throws SQLException, InterruptedException {
        return couponsDAO.getAllCompanyCouponId(companyId);
    }

    @Override
    public List<Coupon> getCompanyCoupons(Category category) throws SQLException, InterruptedException {
        return couponsDAO.getAllCompanyCouponCategoryCompany(category, companyId);

    }

    @Override
    public List<Coupon> getCompanyCoupons(double maxPrice) throws SQLException, InterruptedException {
        return couponsDAO.getAllCompanyCouponPriceCompany(maxPrice, companyId);
    }

    @Override
    public Company getCompanyDetails() throws SQLException, InterruptedException {
        Company company = companiesDAO.getOneCompany(companyId);
        company.setCoupons(couponsDAO.getAllCompanyCouponId(companyId));
        return company;
    }

    @Override
    public void quit() {
        login = false;
    }

    @Override
    public Coupon getOneCuopon(int i) throws SQLException, InterruptedException {
        return couponsDAO.getOneCoupon(i);
    }

}
















