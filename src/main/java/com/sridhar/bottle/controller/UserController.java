package com.sridhar.bottle.controller;

import com.sridhar.bottle.domain.Book;
import com.sridhar.bottle.reponsitory.UserRepository;
import com.sridhar.bottle.service.BookService;
import com.sridhar.bottle.service.UserService;
import com.sridhar.bottle.service.resource.UserRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;



@RestController
public class UserController {

    @Autowired
    BookService bookService;
    @Autowired
    UserService   userService;

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
    @PostMapping("/register")
    public ResponseEntity<?> addBook(@RequestBody @Valid UserRequest userRequest){
        userService.addUser(userRequest.getUser());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}

