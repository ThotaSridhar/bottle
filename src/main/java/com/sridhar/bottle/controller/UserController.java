package com.sridhar.bottle.controller;

import com.sridhar.bottle.domain.Book;
import com.sridhar.bottle.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;



@RestController
public class UserController {

    @Autowired
    BookService bookService;

    @GetMapping("/book")
    public ResponseEntity<?> getAllBook(){
        List<Book> list = bookService.getAllBooks();
        return new ResponseEntity<>(list, HttpStatus.ACCEPTED);
    }

    @GetMapping("/book/{id}")
    public ResponseEntity<?> getBook(@PathVariable("id") String bookId){
        Book book = bookService.getBook(bookId);
        return new ResponseEntity<>(book,HttpStatusCode.valueOf(200));
    }
    @GetMapping("/book/author")
    public ResponseEntity<?> getBookByAuthor(@RequestParam("author") String author){
        List<Book>  bs;
        bs = bookService.getBookByAuthor(author);
        return new ResponseEntity<>(bs,HttpStatus.ACCEPTED);
    }
}

