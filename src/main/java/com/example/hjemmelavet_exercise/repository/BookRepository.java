package com.example.hjemmelavet_exercise.repository;

import com.example.hjemmelavet_exercise.model.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookRepository {
  List<Book> books = new ArrayList<>();

  private Connection connection = DatabaseManager.getConnection();

  public List<Book> getAllBooks(){
    PreparedStatement preparedStatement;
    try {
      preparedStatement = connection.prepareStatement("SELECT * FROM bookshelf");
      ResultSet resultSet = preparedStatement.executeQuery();

      while (resultSet.next()){
        books.add(new Book(
            resultSet.getInt("id"),
            resultSet.getString("name"),
            resultSet.getString("year")
        ));
      }

    } catch (SQLException e) {
      throw new RuntimeException(e);
    }

    return books;
  }

  public Book getBook(int id){
    PreparedStatement preparedStatement = null;
    try {
      preparedStatement = connection.prepareStatement("SELECT * FROM bookshelf WHERE id=?");
      preparedStatement.setInt(1, id);
      ResultSet resultSet = preparedStatement.executeQuery();

      if (resultSet.next()){
        return new Book( //returnerer og laver book-entitet direkte efter de data er hentet fra databasen
            resultSet.getInt("id"),
            resultSet.getString("name"),
            resultSet.getString("year")
        );
      }

    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    return null; //gøres hvis bogen ikke findes
  }

  public void createBook(Book book){
    try {
      PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO bookshelf (name, year) VALUES (?,?)");
      preparedStatement.setString(1, book.getName());
      preparedStatement.setString(2, book.getYear());
      preparedStatement.executeUpdate();

    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

}
