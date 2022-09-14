package com.project.project2.service.facade;

import com.project.project2.repository.CompanyRepository;
import com.project.project2.repository.CouponRepository;
import com.project.project2.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;


public abstract class ClientService {
    @Autowired
    protected CustomerRepository customerRepository;
    @Autowired
    protected CouponRepository couponRepository;
    @Autowired
    protected CompanyRepository companyRepository;

    public abstract boolean login(String email, String password);
}
