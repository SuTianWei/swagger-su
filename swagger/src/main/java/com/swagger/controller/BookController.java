package com.swagger.controller;

import com.swagger.Entity.Book;
import com.swagger.Entity.Publisher;
import com.swagger.service.BookService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Id;
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
        Book book1 = bookService.save(book);
        return new ResponseEntity<>(book, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "按照id查看书籍")
    public ResponseEntity<List<Book>> getBook(@RequestParam int id) {
        Book books = bookService.getBookById(id);
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


    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ApiOperation(value = "更新书籍按照id")
    public ResponseEntity<?> update(@RequestBody Book book, @RequestParam int id) {
        Book book1 = bookService.getBookById(id);
        if (book == null) {
            return new ResponseEntity<>("book Not Exist. ", HttpStatus.BAD_REQUEST);
        }
        book.setId(id);
        Book book2 = bookService.save(book);
        return new ResponseEntity<>(book, HttpStatus.CREATED);
    }

}

