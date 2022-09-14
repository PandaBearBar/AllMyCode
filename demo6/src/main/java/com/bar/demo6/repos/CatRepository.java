package com.bar.demo6.repos;

import com.bar.demo6.bins.Cat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CatRepository extends JpaRepository<Cat,Integer> {

    List<Cat> findByNameAndWeight(String name,float weight);
    List<Cat> findByNameOrWeight(String name,float weight);
    List<Cat> findByOrderByWeightDesc();
    List<Cat> findByOrderByWeightAsc();
    List<Cat> findByNameContaining(String chr);

    @Query(value = "SELECT avg(weight) FROM demo6.cats ;", nativeQuery = true )
    float AvgCatWeight();
}
