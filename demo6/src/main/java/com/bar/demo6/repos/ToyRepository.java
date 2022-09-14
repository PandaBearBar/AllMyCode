package com.bar.demo6.repos;

import com.bar.demo6.bins.Toy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToyRepository extends JpaRepository<Toy,Integer> {
}
