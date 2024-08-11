package com.sridhar.bottle.service;
import java.util.*;
import com.sridhar.bottle.domain.Book;

public interface BookService {

    public void addBook(Book book);
    public List<Book> getAllBooks();

    public Book getBook(String id);
    public void updateBook(String id,Book book);
    public void deleteBook(String id);
    public List<Book> getBookByAuthor(String author);

}
