package bookstore.bookstore.service;

import bookstore.bookstore.model.Book;
import bookstore.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class BookService {

    private BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = Objects.requireNonNull(bookRepository, "Book Repository must be defined");
    }

    public void save(Book book) {
        bookRepository.save(book);
    }

    public List<Book> selectAllBooks() {
       return bookRepository.findAll();
    }

    public Optional<Book> selectBookById(Long id) {
       return bookRepository.findById(id);
    }

    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }

}
