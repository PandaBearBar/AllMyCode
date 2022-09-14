package com.preTest.demo8.repos;

import com.preTest.demo8.bins.Toy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToyRepository extends JpaRepository<Toy,Integer> {
}
