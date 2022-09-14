package com.example.demo7.service;

import com.example.demo7.bin.Author;
import com.example.demo7.bin.Books;
import com.example.demo7.excp.LibraryCustomException;

import java.util.List;

public interface LibraryService {

    void addAuthor(Author author) throws LibraryCustomException;
    void deleteAuthor(int id) throws LibraryCustomException;
    List<Books> findAllBooks();
    Author findByIdAuthor(int id);
    List<Books>findAllBooksBetween(int start,int end);
    double findAvgBooks();
    double findAvgBooksById(int id);



}
