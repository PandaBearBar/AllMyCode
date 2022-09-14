package com.project.project2.clr.on;

import com.project.project2.bins.*;
import com.project.project2.excaptions.CouponSystemException;
import com.project.project2.repository.CouponRepository;
import com.project.project2.service.dailyTask.DailyEliminateJob;
import com.project.project2.service.facade.AdminService;
import com.project.project2.service.facade.ClientService;
import com.project.project2.service.facade.CompanyService;
import com.project.project2.service.facade.CustomerService;
import com.project.project2.service.loginSystem.ClientType;
import com.project.project2.service.loginSystem.LoginManager;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.LocalDate;

@Component
@Order(6)
@RequiredArgsConstructor
public class CouponSystemTestng implements CommandLineRunner {
    private final LoginManager loginManager;
    private final DailyEliminateJob dailyEliminateJob;
    private final CouponRepository couponRepository;
    @Override
    public void run(String... args) throws Exception {
        dailyEliminateJob.CouponEliminator();
        adminTime2Shine();
        companyTime2Shine();
        customerTime2Shine();
        couponRepository.deleteAllByEndDateLessThan(Date.valueOf(LocalDate.now().plusDays(2)));
       // couponRepository.deleteById(3);
    }
    public void adminTime2Shine() throws CouponSystemException {
        System.out.println(AsciiArt.LINE);
        System.out.println(AsciiArt.ADMIN_LOGIN);
        AdminService adminService =
                (AdminService) loginManager.login("admin@admin.com", "admin", ClientType.Administrator);
        Customer customer1 = Customer.builder()
                .firstName("1")
                .lastName("1")
                .email("1@customr.com")
                .password("customer")
                .build();
        Customer customer2 = Customer.builder()
                .firstName("2")
                .lastName("2")
                .email("2@customr.com")
                .password("customer")
                .build();
        Customer customer3 = Customer.builder()
                .firstName("3")
                .lastName("3")
                .email("3@customr.com")
                .password("customer")
                .build();
        Customer customer4 = Customer.builder()
                .firstName("4")
                .lastName("4")
                .email("4@customr.com")
                .password("customer")
                .build();
        Customer customer5 = Customer.builder()
                .firstName("5")
                .lastName("5")
                .email("5@customr.com")
                .password("customer")
                .build();
        Company company1 = Company.builder()
                .name("1")
                .email("1@company.com")
                .password("company")
                .build();
        Company company2 = Company.builder()
                .name("2")
                .email("2@company.com")
                .password("company")
                .build();
        Company company3 = Company.builder()
                .name("3")
                .email("3@company.com")
                .password("company")
                .build();
        Company company4 = Company.builder()
                .name("4")
                .email("4@company.com")
                .password("company")
                .build();
        Company company5 = Company.builder()
                .name("5")
                .email("5@company.com")
                .password("company")
                .build();
        adminService.addCompany(company1);
        adminService.addCompany(company2);
        adminService.addCompany(company3);
        adminService.addCompany(company4);
        adminService.addCompany(company5);
        adminService.getAllCompanies().forEach(System.out::println);
        company1 = adminService.getOneCompany(1);
        company1.setEmail("theNewEmail@company.com");
        company1.setPassword("theNewPassword");
        adminService.updateCompany(company1);
        adminService.getAllCompanies().forEach(System.out::println);
        adminService.deleteCompany(5);
        adminService.getAllCompanies().forEach(System.out::println);
        System.out.println(AsciiArt.LINE);
        adminService.addCustomer(customer1);
        adminService.addCustomer(customer2);
        adminService.addCustomer(customer3);
        adminService.addCustomer(customer4);
        adminService.addCustomer(customer5);
        adminService.getAllCustomers().forEach(System.out::println);
        customer1 = adminService.getOneCustomer(1);
        customer1.setEmail("theNewEmail@customer.com");
        customer1.setPassword("theNewPassword");
        adminService.updateCustomer(customer1);
        adminService.getAllCustomers().forEach(System.out::println);
        adminService.deleteCustomer(5);
        adminService.getAllCustomers().forEach(System.out::println);
        System.out.println(AsciiArt.LINE);
        System.out.println(AsciiArt.ADMIN_LOGOUT);
    }
    public void companyTime2Shine() throws CouponSystemException {
        System.out.println(AsciiArt.LINE);
        System.out.println(AsciiArt.COMPANY_LOGIN);
        CompanyService companyService =
                (CompanyService) loginManager.login("theNewEmail@company.com", "theNewPassword", ClientType.Company);
        Coupon coupon1 = Coupon.builder()
                .title("1")
                .desc("First")
                .category(Category.Electricity)
                .startDate(Date.valueOf(LocalDate.now()))
                .endDate(Date.valueOf(LocalDate.now().plusDays(1)))
                .img("img.jpg")
                .price(135.5)
                .amount(15)
                .build();
        Coupon coupon2 = Coupon.builder()
                .title("2")
                .desc("Second")
                .category(Category.Food)
                .startDate(Date.valueOf(LocalDate.now()))
                .endDate(Date.valueOf(LocalDate.now().plusDays(1)))
                .img("img.jpg")
                .price(18)
                .amount(7)
                .build();
        Coupon coupon3 = Coupon.builder()
                .title("3")
                .desc("Third")
                .category(Category.Restaurant)
                .startDate(Date.valueOf(LocalDate.now()))
                .endDate(Date.valueOf(LocalDate.now().plusDays(1)))
                .img("img.jpg")
                .price(1000.5)
                .amount(5)
                .build();
        Coupon coupon4 = Coupon.builder()
                .title("4")
                .desc("Forth")
                .category(Category.Vacation)
                .startDate(Date.valueOf(LocalDate.now()))
                .endDate(Date.valueOf(LocalDate.now().plusDays(1)))
                .img("img.jpg")
                .price(1.99)
                .amount(100_000)
                .build();
        Coupon coupon5 = Coupon.builder()
                .title("5")
                .desc("Fifth")
                .category(Category.Electricity)
                .startDate(Date.valueOf(LocalDate.now()))
                .endDate(Date.valueOf(LocalDate.now().plusDays(1)))
                .img("img.jpg")
                .price(500)
                .amount(35)
                .build();
        companyService.addCoupon(coupon1);
        companyService.addCoupon(coupon2);
        companyService.addCoupon(coupon3);
        companyService.addCoupon(coupon4);
        companyService.addCoupon(coupon5);
        companyService.getCompanyCoupons().forEach(System.out::println);
        System.out.println(AsciiArt.LINE);
        System.out.println(companyService.getCompanyCoupons());
        companyService.getCompanyCoupons().forEach(System.out::println);
        coupon1 = companyService.findSingleCoupon(1);
        coupon1.setTitle("TheNewTitle");
        coupon1.setDesc("TheNewDescription");
        companyService.updateCoupon(coupon1);
        companyService.getCompanyCoupons(Category.Electricity);
        companyService.deleteCoupon(2);
        companyService.getCompanyCoupons(501);
        System.out.println(companyService.getCompanyDetails());
        System.out.println(AsciiArt.COMPANY_LOGOUT);
    }
    public void customerTime2Shine() throws CouponSystemException{
        System.out.println(AsciiArt.LINE);
        System.out.println(AsciiArt.CUSTOMER_LOGIN);
        CustomerService customerService =
                (CustomerService) loginManager.login("theNewEmail@customer.com","theNewPassword",ClientType.Customer);
        customerService.purchaseCoupon(customerService.searchCoupon(1));
        customerService.purchaseCoupon(customerService.searchCoupon(4));
        customerService.purchaseCoupon(customerService.searchCoupon(3));
        customerService.getCustomerCoupons().forEach(System.out::println);
        customerService.refundCoupon(customerService.searchCoupon(4));
        customerService.getCustomerCoupons(Category.Electricity).forEach(System.out::println);
        System.out.println(AsciiArt.LINE);
        customerService.getCustomerCoupons(150).forEach(System.out::println);
        System.out.println(AsciiArt.LINE);
        System.out.println(customerService.getCustomerDetails());
        System.out.println(AsciiArt.CUSTOMER_LOGOUT);
    }
}
