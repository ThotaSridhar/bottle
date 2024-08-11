package com.sridhar.bottle;

import com.sridhar.bottle.domain.Book;
import com.sridhar.bottle.domain.Genre;
import com.sridhar.bottle.reponsitory.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.util.List;

@SpringBootApplication
public class BottleApplication implements CommandLineRunner {

	Logger logger = LoggerFactory.getLogger(BottleApplication.class);

	@Value("${user}")
	String user;

	@Value("${car}")
	String car;

	@Autowired
	BookRepository bookRepository;

	public static void main(String[] args) {
		SpringApplication.run(BottleApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("The car is "+car);
		System.out.println("user is "+user);

		List<Book> books= bookRepository.findAll();


	}
}
