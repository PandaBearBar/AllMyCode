package com.example.demo7.service;

import com.example.demo7.bin.Author;
import com.example.demo7.bin.Books;
import com.example.demo7.excp.ErrMsg;
import com.example.demo7.excp.LibraryCustomException;
import com.example.demo7.repos.AuthorRepository;
import com.example.demo7.repos.BooksRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@RequiredArgsConstructor
@Service
public class LibraryServiceImpl implements LibraryService{

    private final AuthorRepository authorRepository;
    private final BooksRepository booksRepository;

    @Override
    public void addAuthor(Author author) throws LibraryCustomException {
        if (authorRepository.existsById(author.getId()))
            throw new LibraryCustomException(ErrMsg.IdExist);
        authorRepository.save(author);
    }

    @Override
    public void deleteAuthor(int id) throws LibraryCustomException {
        if (!authorRepository.existsById(id))
            throw new LibraryCustomException(ErrMsg.CantBeDeleted);
        authorRepository.deleteById(id);
    }

    @Override
    public List<Books> findAllBooks() {
        return booksRepository.findAll();
    }

    @Override
    public Author findByIdAuthor(int id) {
        return authorRepository.getReferenceById(id);
    }

    @Override
    public List<Books> findAllBooksBetween(int start, int end) {
        return booksRepository.findByYearBetween(start, end);
    }

    @Override
    public double findAvgBooks() {
        return booksRepository.findAvgBooks();
    }

    @Override
    public double findAvgBooksById(int id) {
        List<Books> booksList = authorRepository.getReferenceById(id).getBooksList();
        int years =0;
        for (Books b : booksList ) {
            years +=  b.getYear();
        }
        double avg = ((double) years)/booksList.size();
        return avg ;
    }
}
