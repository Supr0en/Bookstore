package com.example.bookstore;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;

import com.example.bookstore.domain.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.bookstore.domain.Category;
import com.example.bookstore.domain.CategoryRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class CategoryRepositoryTests {
    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    public void createAndFindNewCategory() { // test for adding new Category and find category by name
        Category category = new Category("new findings");
        categoryRepository.save(category);
        assertThat(categoryRepository.findByCategoryName("new findings")).isNotNull();
    }
    @Test
    public void createAndDeleteCategory() {
        Category category = new Category("new findings");
        categoryRepository.save(category);

        categoryRepository.delete(category);
        assertFalse(categoryRepository.existsById(category.getCategoryid()));

    }
}
