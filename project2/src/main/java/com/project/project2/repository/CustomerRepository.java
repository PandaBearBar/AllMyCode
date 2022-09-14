package com.project.project2.repository;

import com.project.project2.bins.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    boolean existsByEmail(String email);
    Customer findByEmailAndPassword(String email, String password);
}
