package com.swagger.controller;

import com.sun.org.apache.regexp.internal.RE;
import com.swagger.Entity.Book;
import com.swagger.Entity.Publisher;
import com.swagger.service.BookService;
import com.swagger.service.impl.BookServiceImpl;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ApiOperation(value = "get all books", response = Book.class, responseContainer = "List")
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> books = bookService.getAllBooks();
        if (!books.isEmpty()) {
            return new ResponseEntity(books, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    @ApiOperation(value = "add book details")
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        Book bookresponse = bookService.save(book);
        return new ResponseEntity<>(bookresponse, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "get book  by id")
    public ResponseEntity<List<Book>> getBook(@RequestParam int id) {
        Book books = bookService.getBookById(id);
        if (books != null) {
            return new ResponseEntity(books, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ApiOperation(value = "更新一个")
    public ResponseEntity<Book> updateById(@RequestBody Book book) {
        Book books = bookService.updateById(book);
        if (books != null) {
            return new ResponseEntity(books, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ApiOperation(value = "按照Id删除图书")
    public ResponseEntity<?> removePublisher(@RequestParam int id) {
        Book book = bookService.getBookById(id);
        if (book == null) {
            return new ResponseEntity<>("User Not Exist. ", HttpStatus.BAD_REQUEST);
        }
        bookService.deleteById(id);
        return new ResponseEntity<>("Successfully Deleted. ", HttpStatus.OK);
    }
}

