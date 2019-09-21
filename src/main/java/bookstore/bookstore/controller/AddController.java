package bookstore.bookstore.controller;

import bookstore.bookstore.model.Book;
import bookstore.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Objects;

@Controller
public class AddController {

    private BookService bookService;

    @Autowired
    public AddController(BookService bookService) {
        this.bookService = Objects.requireNonNull(bookService, "Book Service must be defined.");
    }

    @GetMapping
    public ModelAndView registerForm() {
        return new ModelAndView("add").addObject("book", new Book());
    }

    @PostMapping
    public ModelAndView save(@ModelAttribute @Valid Book book, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ModelAndView("add", bindingResult.getModel())
                    .addObject("book", book);
        }
        bookService.save(book);
        return new ModelAndView("index").addObject("books", bookService.selectAllBooks());
    }
}
