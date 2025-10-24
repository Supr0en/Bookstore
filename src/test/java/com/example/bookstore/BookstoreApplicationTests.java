package com.example.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.bookstore.web.categoryController;
import com.example.bookstore.web.bookController;
import com.example.bookstore.web.bookRestController;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class BookstoreApplicationTests {

    @Autowired
    private bookController bookController;
    @Autowired
    private bookRestController bookRestController;
    @Autowired
    private categoryController categoryController;

    @Test
    public void SmokeTestBookController() {
        assertThat(bookController).isNotNull();
    }
    @Test
    public void SmokeTestBookRestController() {
        assertThat(bookRestController).isNotNull();
    }
    @Test
    public void SmokeTestCategoryController() {
        assertThat(categoryController).isNotNull();
    }
}
