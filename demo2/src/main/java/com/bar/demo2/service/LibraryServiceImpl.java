package com.bar.demo2.service;

import com.bar.demo2.bins.Author;
import com.bar.demo2.bins.Books;
import com.bar.demo2.exception.ExceptionMSG;
import com.bar.demo2.exception.LibraryCustomException;
import com.bar.demo2.repositories.AuthorRepository;
import com.bar.demo2.repositories.BooksRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@RequiredArgsConstructor // level three
@Service
public class LibraryServiceImpl implements LibraryService{
    //@Autowired - first level
    private final BooksRepository booksRepository;

    // second level
//    public LibraryServiceImpl(BooksRepository booksRepository) {
//        this.booksRepository = booksRepository;
//    }

    //@Autowired - first level
    private final AuthorRepository authorRepository;
    // second level
//    public LibraryServiceImpl(AuthorRepository authorRepository) {
//        this.authorRepository = authorRepository;
//    }

    @Override
    public void addAuthor(Author author) throws LibraryCustomException {
        if (authorRepository.existsById(author.getId()))throw new LibraryCustomException(ExceptionMSG.AlreadyExist);
        booksRepository.saveAll(author.getBooksList());
        authorRepository.save(author);
    }

    @Override
    public void deleteAuthor(int Id) throws LibraryCustomException {
        if (!authorRepository.existsById(Id))
            throw new LibraryCustomException(ExceptionMSG.NotExist);
        authorRepository.deleteById(Id);
    }

    @Override
    public List<Books> getAllBooks() {
        return booksRepository.findAll();
    }

    @Override
    public Author getOneById(int Id) throws LibraryCustomException {
        if (!authorRepository.existsById(Id))
            throw new LibraryCustomException(ExceptionMSG.NotExist);
        return authorRepository.getById(Id);
    }

    @Override
    public List<Books> getAllBooksByRange(int start, int end) throws LibraryCustomException {
        if (start >= end )
            throw new LibraryCustomException(ExceptionMSG.StartBiggerEnd);
        return booksRepository.getAllBooksByYearRange(start,end);
    }

    @Override
    public double getAvgYearAllBooks() {
        return booksRepository.getAvgYearAllBooks();
    }

    @Override
    public double getAvgYearAllBooksByAuthor(int id) {
        return authorRepository.getAvgYearAllBooksByAuthor(id);
    }
}
