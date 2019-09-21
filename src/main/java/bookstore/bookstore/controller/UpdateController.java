package bookstore.bookstore.controller;

import bookstore.bookstore.model.Book;
import bookstore.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class UpdateController {

    private BookService bookService;

    @Autowired
    public UpdateController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/updateBook/{id}")
    public ModelAndView updateForm(@PathVariable Long id) {
        return new ModelAndView("update").addObject("books", bookService.selectBookById(id).get());
    }

    @PostMapping("/updateBook/{id}")
    public ModelAndView updateBook(@PathVariable Long id, @ModelAttribute Book updateBook) {
        updateBook.setId(id);
        bookService.save(updateBook);
        return new ModelAndView("index").addObject("books", bookService.selectAllBooks());
    }

}
