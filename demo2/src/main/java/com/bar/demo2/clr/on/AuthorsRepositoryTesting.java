package com.bar.demo2.clr.on;

import com.bar.demo2.bins.Author;
import com.bar.demo2.repositories.AuthorRepository;
import com.bar.demo2.repositories.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Order(2)
public class AuthorsRepositoryTesting implements CommandLineRunner {

    @Autowired
    private AuthorRepository authorsRepository;

    @Autowired
    private BooksRepository booksRepository;

    @Override
    public void run(String... args) throws Exception {
        Author author1 = Author.builder()
                .name("Robert")
                .booksList(Arrays.asList(booksRepository.getById(1),booksRepository.getById(2)))
                .build();
        Author author2 = Author.builder()
                .name("Roberto")
                .booksList(Arrays.asList(booksRepository.getById(3),booksRepository.getById(4)))
                .build();
        authorsRepository.saveAll(Arrays.asList(author1,author2));
        authorsRepository.findAll().forEach(System.out::println);

    }
}
