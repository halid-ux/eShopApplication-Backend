package mk.finki.ukim.eshop.controller;

import mk.finki.ukim.eshop.model.Book;
import mk.finki.ukim.eshop.model.dto.BookDto;
import mk.finki.ukim.eshop.service.IBookService;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/books")
public class BookController {
    private final IBookService bookService;

    public BookController(IBookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/list")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/list/page/{page}")
    public List<Book> getAllBooksByPage(@PathVariable int page) {
        return bookService.getAllBooksByPage(Pageable.ofSize(5).withPage(page));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        Book book = bookService.getBookById(id);

        if (book == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(book);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<Book> addBook(@RequestBody BookDto book) {
        Book newBook = bookService.addBook(book);

        if (newBook == null) {
            return ResponseEntity.badRequest().build();
        } else {
            return ResponseEntity.ok(newBook);
        }
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Book> editBook(@PathVariable Long id, @RequestBody BookDto book) {
        Book newBook = bookService.editBook(id, book);

        if (newBook == null) {
            return ResponseEntity.badRequest().build();
        } else {
            return ResponseEntity.ok(newBook);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Book> deleteBook(@PathVariable Long id) {
        Book book = bookService.getBookById(id);

        if (book == null) {
            return ResponseEntity.notFound().build();
        } else {
            bookService.deleteBook(id);
            return ResponseEntity.ok(book);
        }
    }

    @PutMapping("/mark/{id}")
    public ResponseEntity<Book> markBookAsTaken(@PathVariable Long id) {
        Book book = bookService.getBookById(id);

        if (book == null) {
            return ResponseEntity.notFound().build();
        } else {
            bookService.markBookAsTaken(id);
            return ResponseEntity.ok(book);
        }
    }
}
