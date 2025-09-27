package com.example.bookstore.web;

import com.example.bookstore.domain.Book;
import com.example.bookstore.domain.BookRepository;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@Controller
public class bookRestController {
    private final BookRepository bookRepository;

    public bookRestController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @RequestMapping(value="/books", method=RequestMethod.GET)
    public @ResponseBody List<Book> findAllBooksRest() {
        return (List<Book>) bookRepository.findAll();
    }

    @RequestMapping(value="/books/{id}", method=RequestMethod.GET)
    public @ResponseBody Optional<Book> getOneBookRest(@PathVariable(name = "id") Long id) {
        return bookRepository.findById(id);
    }

    @RequestMapping(value="/books", method=RequestMethod.POST)
    public @ResponseBody Book saveBookRest(@RequestBody Book book) {
        return bookRepository.save(book);
    }
}
