package com.example.bookstore.domain;

public class Book {
    private String title;
    private String author;
    private String publicationYear;
    private String isbn;
    private String price;

    public Book(){
        this.title = null;
        this.author = null;
        this.publicationYear = null;
        this.isbn = null;
        this.price = null;

    }

    public Book(String title, String author, String publicationYear, String isbn, String price) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.isbn = isbn;
        this.price = price;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public String getPublicationYear() {
        return publicationYear;
    }
    public void setPublicationYear(String publicationYear) {
        this.publicationYear = publicationYear;
    }
    public String getIsbn() {
        return isbn;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public String getPrice() {
        return price;
    }
    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return this.title + this.author + this.publicationYear + this.isbn + this.price;
    }
}
