package com.bar.demo2.controller;


import com.bar.demo2.bins.Author;
import com.bar.demo2.bins.Books;
import com.bar.demo2.exception.LibraryCustomException;
import com.bar.demo2.service.LibraryService;
import com.bar.demo2.models.DatesBetweenReq;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/library")
@RequiredArgsConstructor
public class LibraryController {

    private final LibraryService libraryService;

    @PostMapping("/author")//V V V
    @ResponseStatus(HttpStatus.CREATED)
    public void addAuthor(@RequestBody Author author) throws LibraryCustomException {
        libraryService.addAuthor(author);
    }

    @DeleteMapping("/author/delete/{id}")//V V V
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAuthor(@PathVariable int id) throws LibraryCustomException {
        libraryService.deleteAuthor(id);
    }

    @GetMapping("/books/all") //V V V
    public List<Books> getAllBooks(){
        return libraryService.getAllBooks();
    }

    @GetMapping("/author/{id}")//V V V
    public Author getOneById(@PathVariable long id) throws LibraryCustomException {
        return libraryService.getOneById((int) id);
    }
    @GetMapping("/books/btw/dates")//V V ?
    public List<Books> getAllTaskBetween(@RequestBody DatesBetweenReq datesBetween) throws LibraryCustomException {
        return libraryService.getAllBooksByRange(datesBetween.getStart(), datesBetween.getEnd());
    }

    @GetMapping("/books/avg") // V V V
    public double getAvgYearAllBooks(){
        return libraryService.getAvgYearAllBooks();
    }

    @GetMapping("/author/{id}/books/avg") //  V  V V
    public double getAvgYearAllBooksByAuthor(@PathVariable int id){
        return libraryService.getAvgYearAllBooksByAuthor(id);
    }

}
