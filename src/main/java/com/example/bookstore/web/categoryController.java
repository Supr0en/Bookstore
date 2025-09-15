package com.example.bookstore.web;

import com.example.bookstore.domain.Category;
import com.example.bookstore.domain.CategoryRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class categoryController {

    private final CategoryRepository categoryRepository;

    public categoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @RequestMapping(value = "/categoryList")
    public String categoryList(Model model) {
        List<Category> categories = (List<Category>) categoryRepository.findAll();
        model.addAttribute("categories", categories);
        return "categorylist";
    };

    @RequestMapping(value = "/addCategory")
    public String addBook(Model model){
        model.addAttribute("category", new Category());
        return "addCategory";
    }
    @RequestMapping(value = "/saveCategory", method = RequestMethod.POST)
    public String saveBook(Category category){
        categoryRepository.save(category);
        return "redirect:/categoryList";
    }
}
