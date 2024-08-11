package com.sridhar.bottle.service.impl;

import com.sridhar.bottle.domain.Book;
import com.sridhar.bottle.reponsitory.BookRepository;
import com.sridhar.bottle.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BookServiceImpl implements BookService {


    @Autowired
    BookRepository bookRepository;


    @Override
    public void addBook(Book book) {
        bookRepository.save(book);
    }

    @Override
    public List<Book> getAllBooks() {
        List<Book> books;
        books = bookRepository.findAll();
        return books;
    }

    @Override
    public Book getBook(String id) {
        Optional<Book> book = bookRepository.findById(Integer.valueOf(id));
        return book.orElse(null);
    }

    @Override
    public void updateBook(String id, Book book) {
//        for(int i=0;i<books.size();i++){
//            if(books.get(i).getId().equals(id)){
//                books.set(i,book);
//            }
//        }
    }

    @Override
    public void deleteBook(String id) {
        Optional<Book> book = bookRepository.findById(Integer.valueOf(id));
        book.ifPresent(value -> bookRepository.delete(value));
    }

    @Override
    public List<Book> getBookByAuthor(String author){
        List<Book> books;
//        books = bookRepository.findByAuthor(author);
        books = bookRepository.getTopRatingProducts(Double.valueOf(author));
        System.out.println("The rating is"+author);
        System.out.println("books are "+books);
        return books;
    }
}
