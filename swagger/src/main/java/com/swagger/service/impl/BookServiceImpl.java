package com.swagger.service.impl;

import com.swagger.Entity.Book;
import com.swagger.repository.BookRepository;
import com.swagger.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service("bookService")
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book getBookById(int id) {
        return bookRepository.findOne(id);
    }

    @Override
    public void updateById(int  id) {
      bookRepository.flush();
    }

    /**
     * @param id
     */
    @Override
    public void deleteById(int id) {
        bookRepository.delete(id);
    }
}
