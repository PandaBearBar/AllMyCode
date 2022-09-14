package com.bar.demo2.repositories;

import com.bar.demo2.bins.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface BooksRepository extends JpaRepository<Books,Integer> {

    @Query(value = "SELECT * FROM spring_147.books where ( books.year >= :start AND books.year <= :end)", nativeQuery = true)
    List<Books> getAllBooksByYearRange(@Param("start") int start, @Param("end") int end );

    @Query(value = "SELECT avg(year) FROM spring_147.books", nativeQuery = true)
    double getAvgYearAllBooks();

}
