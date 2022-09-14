package com.project.project2.service.facade;

import com.project.project2.bins.Company;
import com.project.project2.bins.Customer;
import com.project.project2.excaptions.CouponSystemException;
import com.project.project2.excaptions.ExceptionMsg;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AdminServiceImpl extends ClientService implements AdminService{
    private final String email= "admin@admin.com";
    private final String password = "admin";
    @Override
    public boolean login(String email, String password) {
        return this.email.equals(email)&&this.password.equals(password);
    }
    @Override
    public void addCompany(Company company) throws CouponSystemException {
        if (companyRepository.existsByEmailOrName(company.getEmail(), company.getName()))
            throw new CouponSystemException(ExceptionMsg.CompanyEmailOrNameUnavailable);
        companyRepository.save(company);
    }

    @Override
    public void updateCompany(Company company) throws CouponSystemException {
        if (!companyRepository.existsByIdAndName(company.getId(), company.getName()))
            throw new CouponSystemException(ExceptionMsg.CompanyUpdateDenied);
        companyRepository.saveAndFlush(company);
    }

    @Override
    public void deleteCompany(int companyId) throws CouponSystemException {
        if (!companyRepository.existsById(companyId))
            throw new CouponSystemException(ExceptionMsg.CompanyNotExist);
        companyRepository.deleteById(companyId);
    }

    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public Company getOneCompany(int companyId) throws CouponSystemException {
        if (!companyRepository.existsById(companyId))
            throw new CouponSystemException(ExceptionMsg.CompanyNotExist);
        return companyRepository.getReferenceById(companyId);
    }

    @Override
    public void addCustomer(Customer customer) throws CouponSystemException {
        if (customerRepository.existsByEmail(customer.getEmail()))
            throw new CouponSystemException(ExceptionMsg.CustomerEmailUnavailable);
        customerRepository.save(customer);
    }

    @Override
    public void updateCustomer(Customer customer) throws CouponSystemException {
        if (!customerRepository.existsById(customer.getId()))
            throw new CouponSystemException(ExceptionMsg.CustomerUpdateDenied);
        customerRepository.saveAndFlush(customer);
    }

    @Override
    public void deleteCustomer(int customerId) throws CouponSystemException {
        if (!customerRepository.existsById(customerId))
            throw new CouponSystemException(ExceptionMsg.CustomerNotExist);
        customerRepository.deleteById(customerId);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getOneCustomer(int customerId) {
        return customerRepository.getReferenceById(customerId);
    }


}
