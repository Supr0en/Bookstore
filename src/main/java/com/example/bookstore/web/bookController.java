package com.example.bookstore.web;

import com.example.bookstore.domain.Book;
import java.util.List;
import com.example.bookstore.domain.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class bookController {
    @Autowired
    BookRepository bookRepository;

    @GetMapping("/index")
    public String index(){
        return "index";
    }

    @GetMapping("/booklist")
    public String booklist(Model model){
        List<Book> booksList =  (List<Book>) bookRepository.findAll();
        model.addAttribute("booklist", booksList);
        return "booklist";
    }
}
