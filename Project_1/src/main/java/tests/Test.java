package tests;

import art.titleArt;
import beans.Category;
import beans.Company;
import beans.Coupon;
import beans.Customer;
import db.JDBCUtils;
import facade.Admin.AdminFacadeImpl;
import facade.Company.CompanyFacadeImpl;
import facade.Customer.CustomerFacadeImpl;
import job.CouponExpirationDailyJob;
import loginSystem.ClientType;
import loginSystem.LoginManager;
import systemException.SystemException;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;

public class Test {

    private void line() {

        System.out.println(titleArt.Line.getMsg());

    }

    private void threadTime() {
        Thread thread = new Thread(CouponExpirationDailyJob.getInstance());

        thread.setDaemon(true);

        thread.start();

        System.out.println(titleArt.ThreadStart.getMsg());

        line();

    }

    private void adminTime() throws SQLException, InterruptedException, SystemException {

        Company company1 = new Company("Com 1", "Com1@gmail", "1234");

        Company company2 = new Company("Com 2", "Com2@gmail", "1234");

        Company company3 = new Company("Com 3", "Com3@gmail", "1234");

        Company company4 = new Company("Com 4", "Com4@gmail", "1234");

        Company company5 = new Company("Com 5", "Com5@gmail", "1234");

        Customer customer1 = new Customer("Cus", "1", "Cus1@gmail", "1234");

        Customer customer2 = new Customer("Cus", "2", "Cus2@gmail", "1234");

        Customer customer3 = new Customer("Cus", "3", "Cus3@gmail", "1234");

        Customer customer4 = new Customer("Cus", "4", "Cus4@gmail", "1234");

        Customer customer5 = new Customer("Cus", "5", "Cus5@gmail", "1234");

        line();

        AdminFacadeImpl adminFacade =
                ((AdminFacadeImpl) LoginManager.getInstance().login("admin@admin.com", "admin", ClientType.Administrator));

        System.out.println(titleArt.AdminEnter.getMsg());

        line();
        System.out.println(titleArt.comapnyL.getMsg());

        adminFacade.addCompany(company1);
        adminFacade.addCompany(company2);
        adminFacade.addCompany(company3);
        adminFacade.addCompany(company4);
        adminFacade.addCompany(company5);


        System.out.println(titleArt.Added.getMsg());

        System.out.println(titleArt.ChosenOne.getMsg());
        company5 = adminFacade.getOneCompany(5);
        company5.setEmail("Com5.1@gmail.com");

        adminFacade.updateCompany(company5);
        System.out.println(titleArt.Updated.getMsg());

        adminFacade.deleteCompany(1);
        System.out.println(titleArt.Deleted.getMsg());

        System.out.println(titleArt.All.getMsg());
        adminFacade.getAllCompanies().forEach(System.out::println);

        line();
        System.out.println(titleArt.customerL.getMsg());

        adminFacade.addCustomer(customer1);
        adminFacade.addCustomer(customer2);
        adminFacade.addCustomer(customer3);
        adminFacade.addCustomer(customer4);
        adminFacade.addCustomer(customer5);
        System.out.println(titleArt.Added.getMsg());

        customer1 = adminFacade.getOneCustomer(1);
        System.out.println(titleArt.ChosenOne.getMsg());

        customer1.setFirstName("Robert");
        customer1.setLastName("Rodrigo");
        adminFacade.updateCustomer(customer1);
        System.out.println(titleArt.Updated.getMsg());


        adminFacade.deleteCustomer(2);
        System.out.println(titleArt.Deleted.getMsg());

        System.out.println(titleArt.All.getMsg());
        adminFacade.getAllCustomer().forEach(System.out::println);

        adminFacade = (AdminFacadeImpl) LoginManager.logout();
        System.out.println(titleArt.AdminOut.getMsg());
        line();


    }

    private void companyTime() throws SQLException, InterruptedException, SystemException {
        line();
        System.out.println(titleArt.CompanyIn.getMsg());
        CompanyFacadeImpl companyFacade =
                ((CompanyFacadeImpl) LoginManager.getInstance().login("Com2@gmail", "1234", ClientType.Company));


        Coupon coupon1 = new Coupon(companyFacade.getCompanyId(), Category.Food, "Title1", "Description", Date.valueOf(LocalDate.now()), Date.valueOf(LocalDate.now().plusWeeks(1)), 15, 15.5, "Image 1");

        Coupon coupon2 = new Coupon(companyFacade.getCompanyId(), Category.Restaurant, "Title2", "Description", Date.valueOf(LocalDate.now()), Date.valueOf(LocalDate.now().plusWeeks(1)), 15, 14.5, "Image 2");

        Coupon coupon3 = new Coupon(companyFacade.getCompanyId(), Category.Electricity, "Title3", "Description", Date.valueOf(LocalDate.now()), Date.valueOf(LocalDate.now().plusWeeks(1)), 15, 22, "Image 3");

        Coupon coupon4 = new Coupon(companyFacade.getCompanyId(), Category.Electricity, "Title4", "Description", Date.valueOf(LocalDate.now()), Date.valueOf(LocalDate.now().plusWeeks(1)), 15, 51, "Image 4");

        Coupon coupon5 = new Coupon(companyFacade.getCompanyId(), Category.Vacation, "Title5", "Description", Date.valueOf(LocalDate.now()), Date.valueOf(LocalDate.now().plusWeeks(1)), 15, 22, "Image 5");

        companyFacade.addCoupon(coupon1);
        companyFacade.addCoupon(coupon2);
        companyFacade.addCoupon(coupon3);
        companyFacade.addCoupon(coupon4);
        companyFacade.addCoupon(coupon5);
        System.out.println(titleArt.couponL.getMsg());
        System.out.println(titleArt.Added.getMsg());
        Coupon coupon = companyFacade.getOneCuopon(3);
        coupon.setPrice(27.08);
        companyFacade.updateCoupon(coupon);
        System.out.println(titleArt.Updated.getMsg());

        companyFacade.deleteCoupon(1);
        System.out.println(titleArt.Deleted.getMsg());

        System.out.println(titleArt.All.getMsg());
        companyFacade.getCompanyCoupons().forEach(System.out::println);

        System.out.println(titleArt.ByCategory.getMsg());
        companyFacade.getCompanyCoupons(Category.Electricity).forEach(System.out::println);

        System.out.println(titleArt.ByMaxSum.getMsg());
        companyFacade.getCompanyCoupons(25).forEach(System.out::println);

        System.out.println(titleArt.Details.getMsg());
        System.out.println(companyFacade.getCompanyDetails());

        System.out.println(titleArt.CompanyOut.getMsg());
        companyFacade = (CompanyFacadeImpl) LoginManager.logout();
        line();

    }

    private void customerTime() throws SystemException, SQLException, InterruptedException {
        line();
        CustomerFacadeImpl customerFacade =
                ((CustomerFacadeImpl) LoginManager.getInstance().login("Cus4@gmail", "1234", ClientType.Customer));
        System.out.println(titleArt.CustomerIn.getMsg());


        System.out.println(titleArt.couponL.getMsg());
        customerFacade.purchaseCoupon(
                customerFacade.searchCoupon(3));
        customerFacade.purchaseCoupon(
                customerFacade.searchCoupon(4));
        customerFacade.purchaseCoupon(
                customerFacade.searchCoupon(5));
        System.out.println(titleArt.Added.getMsg());

        System.out.println(titleArt.All.getMsg());
        customerFacade.getCustomerCoupons().forEach(System.out::println);

        System.out.println(titleArt.ByMaxSum.getMsg());
        customerFacade.getCustomerCoupons(25).forEach(System.out::println);

        System.out.println(titleArt.ByCategory.getMsg());
        customerFacade.getCustomerCoupons(Category.Electricity).forEach(System.out::println);

        System.out.println(titleArt.Details.getMsg());
        System.out.println(customerFacade.getCustomerDetails());

        customerFacade = (CustomerFacadeImpl) LoginManager.logout();
        System.out.println(titleArt.CustomerOut.getMsg());
        line();
    }

    private void stopIt() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Click Any Bottom To Quit");
        String useless = scanner.next();
    }

    public void testAll() throws SQLException, InterruptedException, SystemException {

        JDBCUtils.databaseStrategy();

        threadTime();

        adminTime();

        companyTime();

        customerTime();

        stopIt();

    }
}
