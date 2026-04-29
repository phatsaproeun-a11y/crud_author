package org.example.crud.controller;

import lombok.RequiredArgsConstructor;
import org.example.crud.model.entity.Book;
import org.example.crud.model.request.BookRequest;
import org.example.crud.model.response.ApiResponse;
import org.example.crud.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("api/v1/books")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<Book>>> getAllBook(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size
    ){
        List<Book> books = bookService.getAllBooks(page, size);
        return ResponseEntity.status(HttpStatus.OK).body(
                new ApiResponse<>(
                        "get All Book is successfully",
                        books,
                        HttpStatus.OK.value(),
                        LocalDateTime.now()
                )
        );
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Book>> addBook(@RequestBody BookRequest bookRequest){
        Book books = bookService.addBook(bookRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                new ApiResponse<>(
                        "Add new Book is successfully!",
                        books,
                        HttpStatus.OK.value(),
                        LocalDateTime.now()
                )
        );

    }

    @PutMapping("/{book_id}")
    public ResponseEntity<ApiResponse<Book>> updateBook(@PathVariable("book_id") Long bookId, @RequestBody BookRequest bookRequest){
        Book books = bookService.updateBook(bookId, bookRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                new ApiResponse<>(
                        "update Book is successfully!",
                        books,
                        HttpStatus.OK.value(),
                        LocalDateTime.now()
                )
        );
    }

    @DeleteMapping("/{book_id}")
    public ResponseEntity<ApiResponse<Book>> deleteBook(@PathVariable("book_id") Long bookId){
        Book books = bookService.deleteBook(bookId);
        return ResponseEntity.status(HttpStatus.OK).body(
                new ApiResponse<>(
                        "delete Book is successfully!",
                        books,
                        HttpStatus.OK.value(),
                        LocalDateTime.now()
                )
        );
    }







}
