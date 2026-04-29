package org.example.crud.service;

import org.example.crud.model.entity.Book;
import org.example.crud.model.request.BookRequest;
import java.util.List;

public interface BookService {
    List<Book> getAllBooks(int page, int size);
    Book addBook(BookRequest bookRequest);
    Book updateBook(Long bookId, BookRequest bookRequest);
    Book deleteBook(long bookId);
}