package com.sridhar.bottle.reponsitory;

import com.sridhar.bottle.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {

    @Query(value = "select * from books where rating > ?",nativeQuery = true)
    List<Book> getTopRatingProducts(Double rating);

    List<Book> findByAuthor(String author);

}
