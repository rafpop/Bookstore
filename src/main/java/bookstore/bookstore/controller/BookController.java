package bookstore.bookstore.controller;

import bookstore.bookstore.model.Book;
import bookstore.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Objects;

@RestController
public class BookController {

    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = Objects.requireNonNull(bookService, "Book Service must be defined.");
    }

    @GetMapping("/")
    public ModelAndView getAllBooks(Model model) {
        model.addAttribute("index", bookService);
        return new ModelAndView("index").addObject("books", bookService.selectAllBooks());

    }
}
