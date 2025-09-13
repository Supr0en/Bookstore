package com.example.bookstore.web;

import com.example.bookstore.domain.Book;
import java.util.List;
import com.example.bookstore.domain.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class bookController {
    @Autowired
    private BookRepository bookRepository;

    @RequestMapping(value = "/index")
    public String index(){
        return "index";
    }

    @RequestMapping(value = "/booklist")
    public String booklist(Model model){
        List<Book> booksList =  (List<Book>) bookRepository.findAll();
        model.addAttribute("booklist", booksList);
        return "booklist";
    }

    @RequestMapping(value = "/add")
    public String addBook(Model model){
        model.addAttribute("book", new Book());
        return "addbook";
    }
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveBook(Book book){
        bookRepository.save(book);
        return "redirect:/booklist";
    }
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteBook(@PathVariable("id") Long id){
        bookRepository.deleteById(id);
        return "redirect:/booklist";
    }

    @RequestMapping(value = "/edit/{id}")
    public String editBook(@PathVariable("id") Long id, Model model){
        Book book = bookRepository.findById(id).get();
        if (bookRepository.findById(id).isPresent()){
            model.addAttribute("book", book);
        } else {
            throw new RuntimeException("Book not found");
        }
        return "editbook";
    }
}
