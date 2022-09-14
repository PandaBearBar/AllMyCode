package com.example.demo7.clr.on;

import com.example.demo7.bin.Author;
import com.example.demo7.bin.Books;
import com.example.demo7.repos.AuthorRepository;
import com.example.demo7.repos.BooksRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Order(1)
@Component
@RequiredArgsConstructor
public class RepositoryTesting implements CommandLineRunner {
    private final AuthorRepository authorRepository;

    @Override
    public void run(String... args) throws Exception {
        Author author1 = Author.builder()
                .name("Robert")
                .booksList(Arrays.asList(
                        Books.builder().name("Book1").year(1990).build(),
                        Books.builder().name("Book2").year(2010).build()))
                .build();
        Author author2 = Author.builder()
                .name("Loren")
                .booksList(Arrays.asList(
                        Books.builder().name("Book3").year(2005).build(),
                        Books.builder().name("Book4").year(1989).build()))
                .build();
        authorRepository.saveAll(Arrays.asList(author1,author2));

        authorRepository.findAll().forEach(System.out::println);
    }
}
