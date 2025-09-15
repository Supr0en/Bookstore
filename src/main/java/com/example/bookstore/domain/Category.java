package com.example.bookstore.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String categoryName;

    public Category() {
        this.categoryName = "";
    }
    public Category(String categoryName) {
        this.categoryName = categoryName;
    }
    public Long getCategoryId() {
        return id;
    }

    public String getCategoryName() {
        return categoryName;
    }
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public String toString() {
        return "[ id=" + id + ", categoryName=" + categoryName + " ]";
    }
}
