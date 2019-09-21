package bookstore.bookstore.controller;

import bookstore.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class DeleteController {

    private BookService bookService;

    @Autowired
    public DeleteController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/deleteBook/{id}")
    public ModelAndView delete(@PathVariable Long id) {
        bookService.deleteById(id);
        return new ModelAndView("index")
                .addObject("books", bookService.selectAllBooks());
    }
}
