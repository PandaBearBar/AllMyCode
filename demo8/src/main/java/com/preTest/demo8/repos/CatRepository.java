package com.preTest.demo8.repos;

import com.preTest.demo8.bins.Cat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatRepository extends JpaRepository<Cat,Integer> {

}
