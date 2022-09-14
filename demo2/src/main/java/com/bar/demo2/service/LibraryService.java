package com.bar.demo2.service;

import com.bar.demo2.bins.Author;
import com.bar.demo2.bins.Books;
import com.bar.demo2.exception.LibraryCustomException;
import org.springframework.stereotype.Service;

import java.util.List;


public interface LibraryService {
    void addAuthor(Author author) throws LibraryCustomException;
    void deleteAuthor(int Id) throws LibraryCustomException;
    List<Books> getAllBooks();
    Author getOneById(int Id) throws LibraryCustomException;
    List<Books> getAllBooksByRange(int start, int end) throws LibraryCustomException;
    double getAvgYearAllBooks();
    double getAvgYearAllBooksByAuthor(int Id);
}
