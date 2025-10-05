package com.example.bookstore.web;

import com.example.bookstore.domain.Book;
import java.util.List;
import com.example.bookstore.domain.BookRepository;
import com.example.bookstore.domain.CategoryRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class bookController {
    private final BookRepository bookRepository;
    private final CategoryRepository categoryRepository;

    public bookController(BookRepository bookRepository, CategoryRepository categoryRepository) {
        this.bookRepository = bookRepository;
        this.categoryRepository = categoryRepository;
    }

    @RequestMapping(value = "/index")
    public String index(){
        return "index"; // index.html
    }

    @RequestMapping(value = "/booklist")
    public String booklist(Model model){
        List<Book> booksList = (List<Book>) bookRepository.findAll();
        model.addAttribute("booklist", booksList);
        return "booklist"; // booklist.html
    }

    @RequestMapping(value = "/addBook")
    public String addBook(Model model){
        model.addAttribute("book", new Book());
        model.addAttribute("categoryList", categoryRepository.findAll());
        return "addbook"; // addbook.html
    }
    @RequestMapping(value = "/saveBook", method = RequestMethod.POST)
    public String saveBook(Book book){
        bookRepository.save(book);
        return "redirect:/booklist"; // redirect booklist.html
    }
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteBook(@PathVariable("id") Long id){
        bookRepository.deleteById(id);
        return "redirect:/booklist"; // redirect booklist.html
    }

    @RequestMapping(value = "/edit/{id}")
    public String editBook(@PathVariable("id") Long id, Model model){
        Book book = bookRepository.findById(id).get();
        if (bookRepository.findById(id).isPresent()){
            model.addAttribute("book", book);
        } else {
            throw new RuntimeException("Book not found");
        }
        return "editbook"; // editbook.html
    }
}
