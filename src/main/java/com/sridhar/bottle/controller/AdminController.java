package com.sridhar.bottle.controller;


import com.sridhar.bottle.domain.Book;
import com.sridhar.bottle.service.BookService;
import com.sridhar.bottle.service.resource.BookRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AdminController {

    @Autowired
    BookService bookService;

    @PostMapping("/admin/book")
    public ResponseEntity<?> createBook(@RequestBody @Valid BookRequest bookRequest){
        Book book = bookRequest.getBook();
        bookService.addBook(book);
        return new ResponseEntity<>(book, HttpStatus.CREATED);
    }

    @PutMapping("admin/book")
    public ResponseEntity<?> updateBook(@RequestBody  BookRequest bookRequest){
//        bookService.updateBook(book.getId(),book);
        Book book = bookRequest.getBook();
        return new ResponseEntity<>(book,HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("admin/book")
    public ResponseEntity<?> deleteBook(@RequestParam("id") String id){
        bookService.deleteBook(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("admin/check")
    public String check(){
        return "working fine";
    }
}
