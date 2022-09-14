package com.bar.demo2.clr.on;


import com.bar.demo2.bins.Books;
import com.bar.demo2.repositories.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;

@Component
@Order(1)
public class BooksRepositoryTesting implements CommandLineRunner {

    @Autowired
    private BooksRepository booksRepository;

    @Override
    public void run(String... args) throws Exception {
        Books book1 = Books.builder()
                .name("Book 1")
                .year(1995)
                .build();
        Books book2 = Books.builder()
                .name("Book 2")
                .year(2000)
                .build();
        Books book3 = Books.builder()
                .name("Book 3")
                .year(2005)
                .build();
        Books book4 = Books.builder()
                .name("Book 4")
                .year(2010)
                .build();

        booksRepository.saveAll(Arrays.asList(book1,book2,book3,book4));
        booksRepository.findAll().forEach(System.out::println);
    }
}
