package com.example.hjemmelavet_exercise.service;

import com.example.hjemmelavet_exercise.model.Book;
import com.example.hjemmelavet_exercise.repository.BookRepository;
import org.springframework.web.context.request.WebRequest;

import java.sql.PreparedStatement;

public class BookService {
  BookRepository bookRepository = new BookRepository();

  public void createBook(WebRequest payload){
    Book book = new Book(payload.getParameter("name"), payload.getParameter("year"));
    bookRepository.createBook(book);
  }

}
