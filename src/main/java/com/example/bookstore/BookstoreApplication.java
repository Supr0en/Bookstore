package com.example.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.bookstore.domain.Book;
import com.example.bookstore.domain.BookRepository;
import com.example.bookstore.domain.CategoryRepository;
import com.example.bookstore.domain.Category;

import java.util.ArrayList;
import java.util.List;


@SpringBootApplication
public class BookstoreApplication {
    private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(BookstoreApplication.class, args);
    }

    @Bean
    public CommandLineRunner BookDemo(BookRepository bookRepository, CategoryRepository categoryRepository) {
        return (args) -> {
            log.info("save a couple of Categories");
            categoryRepository.save(new Category("Scifi"));
            categoryRepository.save(new Category("Programming"));
            categoryRepository.save(new Category("Fiction"));
            categoryRepository.save(new Category("Fiction"));
            categoryRepository.save(new Category("History"));
            categoryRepository.save(new Category("Dictionary"));

            log.info("fetch all categories");
            List<Category> categories = new ArrayList<>();
            for (Category category : categoryRepository.findAll()) {
                categories.add(category);
                log.info(category.toString());
            }
            log.info("save a couple of Books");
            bookRepository.save(new Book("The Clean coder", "Martin, Robert C", "2011", "2123123-23", "50", categories.get(1)));
            bookRepository.save(new Book("Clean code", "Martin, Robert C", "2009", "1223121-52", "45", categories.get(1)));

            log.info("fetch all book");
            for (Book book : bookRepository.findAll()) {
                log.info(book.toString());
            }
        };
    }
}
