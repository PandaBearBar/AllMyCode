package com.bar.demo2.clr.on;

import com.bar.demo2.bins.Author;
import com.bar.demo2.bins.Books;
import com.bar.demo2.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Order(3)
public class LibraryServiceImplTesting implements CommandLineRunner {

    @Autowired
    LibraryService libraryService;

    @Override
    public void run(String... args) throws Exception {

        Books book6 =Books.builder()
                .year(2015)
                .name("Book 6")
                .build();
        Books book5 =Books.builder()
                .year(2020)
                .name("Book 5")
                .build();

        libraryService.addAuthor(Author.builder()
                        .name("Jojo")
                        .booksList(Arrays.asList(book5,book6))
                .build());

        libraryService.deleteAuthor(1);

        libraryService.getAllBooks().forEach(System.out::println);

        System.out.println(libraryService.getOneById(3));

        libraryService.getAllBooksByRange(2000, 2011).forEach(System.out::println);

        System.out.println(libraryService.getAvgYearAllBooks());

        System.out.println(libraryService.getAvgYearAllBooksByAuthor(3));
    }
}
