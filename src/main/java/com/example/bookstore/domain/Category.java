package com.example.bookstore.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long categoryid;
    private String categoryName;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
    @JsonIgnoreProperties("category")
    private List<Book> books;

    public Category() {
        this.categoryName = "";
    }
    public Category(String categoryName) {
        this.categoryName = categoryName;
    }
    public Long getCategoryid() {
        return categoryid;
    }
    public void setCategoryid(Long categoryid) {
        this.categoryid = categoryid;
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
        return "[ id=" + categoryid + ", categoryName=" + categoryName + " ]";
    }
}
