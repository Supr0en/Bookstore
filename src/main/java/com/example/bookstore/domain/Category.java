package com.example.bookstore.domain;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long categoryId;
    private String categoryName;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
    private List<Book> books;

    public Category() {
        this.categoryName = "";
    }
    public Category(String categoryName) {
        this.categoryName = categoryName;
    }
    public Long getCategoryId() {
        return categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<Book> getBooks() {
        return books;
    }
    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "[ id=" + categoryId + ", categoryName=" + categoryName + " ]";
    }
}
