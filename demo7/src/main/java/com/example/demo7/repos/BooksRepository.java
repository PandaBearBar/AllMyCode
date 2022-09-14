package com.example.demo7.repos;

import com.example.demo7.bin.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface BooksRepository extends JpaRepository<Books,Integer> {
    List<Books>findByYearBetween(int start, int end);
    @Query(nativeQuery = true, value = "SELECT AVG(`year`) FROM `demo7-author-books`.books;")
    double findAvgBooks();
}
