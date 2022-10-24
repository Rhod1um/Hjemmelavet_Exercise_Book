package com.example.hjemmelavet_exercise.controller;

import com.example.hjemmelavet_exercise.model.Book;
import com.example.hjemmelavet_exercise.repository.BookRepository;
import com.example.hjemmelavet_exercise.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import java.util.List;

@Controller
public class BookController {
  BookService bookService = new BookService();

  @GetMapping("/")
  public String index(){
    return "index";
  }


  @PostMapping("/create")
  public String create(WebRequest payload){
    bookService.createBook(payload);
    return "redirect:/";
  }
}
