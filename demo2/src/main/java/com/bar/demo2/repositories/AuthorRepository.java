package com.bar.demo2.repositories;

import com.bar.demo2.bins.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Integer> {

    @Query(value = "SELECT AVG(year)\n" +
            "FROM spring_147.authors_books_list\n" +
            "INNER JOIN spring_147.books\n" +
            "ON spring_147.books.id = spring_147.authors_books_list.books_list_id \n" +
            "AND spring_147.authors_books_list.author_id = :id" ,nativeQuery = true)
    double getAvgYearAllBooksByAuthor(@Param("id") int id);
}
