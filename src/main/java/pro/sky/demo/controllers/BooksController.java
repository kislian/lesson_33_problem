package pro.sky.demo.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pro.sky.demo.model.Book;
import pro.sky.demo.services.BookService;

import java.util.Collection;

@RestController
//устанавливаем базовый url
@RequestMapping("books")
public class BooksController {

    //заинжектим класс который работает с книгами
    private final BookService bookService;

    public BooksController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("{id}")//GET http://localhost:8080/books/23
    public ResponseEntity<Book> getBookInfo(@PathVariable Long id) {
        Book book = bookService.findBook(id);
        if (book == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(book);
    }

    @GetMapping  //GET http://localhost:8080/books
    public ResponseEntity<Collection<Book>> getAllBooks() {
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    @PostMapping //POST  http://localhost:8080/books
    public Book createBook(@RequestBody Book book) {
        return bookService.createBook(book);
    }

    @PutMapping //PUT  http://localhost:8080/books
    public ResponseEntity<Book> editBook(@RequestBody Book book) {
        Book foundBook = bookService.editBook(book);
        if (foundBook == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(foundBook);
    }

    //DELETE http://localhost:8080/books/23
    @DeleteMapping("{id}")
    public ResponseEntity deleteBook(@PathVariable Long id) {
        //удаляем книгу по id
        bookService.deleteBook(id);
        //вернём OK если удалось выполнить
        //если не удалось метод deleteBook выбросит исключение
        //return выполняться не будет статус 500
        return ResponseEntity.ok().build();
    }

}
