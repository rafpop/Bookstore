package bookstore.bookstore.controller;

import bookstore.bookstore.model.Book;
import bookstore.bookstore.repository.BookRepository;
import bookstore.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class RestMethodController {

    public BookService bookService;

    @Autowired
    public RestMethodController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/books")
    public ResponseEntity save(@RequestBody Book book) {
        bookService.save(book);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/books")
    public ResponseEntity getAllBooks() {
         return ResponseEntity.ok(bookService.selectAllBooks());

    }
}
