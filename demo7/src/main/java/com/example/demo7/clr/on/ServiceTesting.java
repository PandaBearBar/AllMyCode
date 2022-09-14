package com.example.demo7.clr.on;

import com.example.demo7.bin.Author;
import com.example.demo7.bin.Books;
import com.example.demo7.service.LibraryService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Order(2)
@RequiredArgsConstructor
public class ServiceTesting implements CommandLineRunner {
    private final LibraryService libraryService;
    @Override
    public void run(String... args) throws Exception {

        libraryService.addAuthor(
                Author.builder()
                        .name("Jojo")
                        .booksList(Arrays.asList(
                        Books.builder()
                        .year(2020)
                        .name("Book 5")
                        .build(),
                        Books.builder()
                        .year(2015)
                        .name("Book 6")
                        .build()))
                        .build());

        libraryService.deleteAuthor(1);

        libraryService.findAllBooks().forEach(System.out::println);

        System.out.println(libraryService.findByIdAuthor(3));

        libraryService.findAllBooksBetween(2000, 2011).forEach(System.out::println);

        System.out.println(libraryService.findAvgBooks());

        System.out.println(libraryService.findAvgBooksById(3));
    }
}
