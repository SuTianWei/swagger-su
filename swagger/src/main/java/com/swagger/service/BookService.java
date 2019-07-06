package com.swagger.service;

import com.swagger.Entity.Book;

import java.util.List;

public interface BookService {
    List<Book> getAllBooks();

    Book save(Book book);

    Book getBookById(int id);

    void updateById(int id);

    void deleteById(int id);
}
