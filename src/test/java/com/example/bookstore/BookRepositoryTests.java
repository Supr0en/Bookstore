package com.example.bookstore;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;

import com.example.bookstore.domain.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.bookstore.domain.Book;
import com.example.bookstore.domain.BookRepository;


@ExtendWith(SpringExtension.class)
@DataJpaTest
public class BookRepositoryTests {
    @Autowired
    private BookRepository bookRepository;

    @Test
    public void createAndFindNewBook() { // test for adding new book and finding by author
        Book book = new Book("New Book", "Test author", 2025, "1222-444", "42", null);
        bookRepository.save(book);
        assertThat(bookRepository.findByAuthor("Test author")).isNotNull();
    }
    @Test
    public void createAndDeleteBook() {
        Book book = new Book ("New Book", "Test author", 2025, "1222-444", "42", null);
        bookRepository.save(book);

        bookRepository.delete(book);
        assertFalse(bookRepository.existsById(book.getId()));
    }

}
