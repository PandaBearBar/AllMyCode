package com.project.project2.service.facade;

import com.project.project2.bins.Company;
import com.project.project2.bins.Customer;
import com.project.project2.excaptions.CouponSystemException;

import java.util.List;

public interface AdminService {
    boolean login(String email,String password);

    void addCompany(Company company) throws CouponSystemException;
    void updateCompany(Company company) throws CouponSystemException;
    void deleteCompany(int companyId) throws CouponSystemException;
    List<Company>getAllCompanies();
    Company getOneCompany(int companyId) throws CouponSystemException;

    void addCustomer(Customer customer) throws CouponSystemException;
    void updateCustomer(Customer customer) throws CouponSystemException;
    void deleteCustomer(int customerId) throws CouponSystemException;
    List<Customer>getAllCustomers();
    Customer getOneCustomer(int customerId);

}
