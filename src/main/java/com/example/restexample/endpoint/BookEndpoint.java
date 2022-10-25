package com.example.restexample.endpoint;

import com.example.restexample.model.Book;
import com.example.restexample.model.BookLanguage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BookEndpoint {


    List<Book> books = new ArrayList<>(List.of(
            new Book(1, "girq 1", "Poxos", 32.3, BookLanguage.ARM),
            new Book(2, "girq 2", "Poxosik", 22.3, BookLanguage.ARM),
            new Book(3, "girq 3", "Poxosyan", 22.6, BookLanguage.ARM)
    ));


    @GetMapping("/books")                //es toxov zapros@ ksarqvi
    public List<Book> getAllBooks() {      // list erov kunenanq stex bolor grqer@
        return books;                      //amboxjutyamb return kenenq mer bolor grqer@ zaprosi jamanak
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable("id") int id) {  //stex kunenanq id zapros egac girq@
        for (Book book : books) {                                          //stex for kfranq grqeri vrayov
            if (book.getId() == id) {                                      // stex kstugenq zapros egac id ov girq uninq te che
                return ResponseEntity.ok(book);                            //es toxov ete gtav kveradardznenq
            }
        }
        return ResponseEntity.notFound().build();                          //stex e or chgdav null kxrgenq status kod@ aveli jishte notfound


    }

    @PostMapping("/books")
    public ResponseEntity<?> createBook(@RequestBody Book book) {
        for (Book bookFromDB : books) {
            if (bookFromDB.getTitle().equals(book.getTitle()) && bookFromDB.getAuthorName().equals(book.getAuthorName())) {
                return ResponseEntity.status(HttpStatus.CONFLICT).build();
            }
        }
        books.add(book);
        return ResponseEntity.noContent().build();

    }

    @PutMapping("/books")
    public ResponseEntity<Book> updateBook(@RequestBody Book book) {
        if (book.getId() > 0) {
            for (Book bookFromDB : books) {
                if (bookFromDB.getId() == book.getId()) {
                    bookFromDB.setLanguage(book.getLanguage());
                    bookFromDB.setTitle(book.getTitle());
                    bookFromDB.setPrice(book.getPrice());
                    bookFromDB.setAuthorName(book.getAuthorName());
                    return ResponseEntity.ok(bookFromDB);
                }
            }
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity<?> deleteBookId(@PathVariable("id") int id) {
        for (Book book : books) {
            if (book.getId() == id) {
                books.remove(book);
                return ResponseEntity.noContent().build();
            }

        }
        return ResponseEntity.notFound().build();
    }
}
