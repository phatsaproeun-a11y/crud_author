package org.example.crud.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.crud.model.entity.Author;
import org.example.crud.model.entity.Book;
import org.example.crud.model.request.BookRequest;
import org.example.crud.repository.BookCategoryRepo;
import org.example.crud.repository.BookRepo;
import org.example.crud.service.BookService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepo bookRepo;
    private final BookCategoryRepo bookCategoryRepo;
    private Object bookId;


    @Override
    public List<Book> getAllBooks(int page, int size) {
        int offset = (page - 1) * size;
        return bookRepo.getAllBooks(offset, size);
    }

    @Override
    public Book addBook(BookRequest bookRequest) {
        Book book = new Book();
        BeanUtils.copyProperties(bookRequest, book);
        Author author = new Author();
        author.setAuthorId( bookRequest.getAuthorId() );
        book.setAuthor(author);
        if(bookRequest.getCategoryId() !=null){
            for(long categoryId: bookRequest.getCategoryId()){
                bookCategoryRepo.insertBookCategory((long) bookId,categoryId);
            }
        }
        return bookRepo.addBook(book);
    }

    @Override
    public Book updateBook(Long bookId, BookRequest bookRequest) {
        Book book = new Book();
        BeanUtils.copyProperties(bookRequest, book);
        Author author = new Author();
        author.setAuthorId(bookRequest.getAuthorId());
        book.setAuthor(author);
        bookRepo.updateBook(bookId,bookRequest);
        bookCategoryRepo.deleteBookCategory(Long.valueOf(bookId));

        if(bookRequest.getCategoryId() !=null){
            for(long categoryId: bookRequest.getCategoryId()){
                bookCategoryRepo.insertBookCategory((long) bookId,categoryId);
            }
        }
        return bookRepo.getBookById(bookId);
    }

    @Override
    public Book deleteBook(long bookId) {
        Book book = bookRepo.getBookById(bookId);

        BookCategoryRepo.deleteByBookId((long) bookId);

        bookRepo.deleteBook(bookId);
        return book;
    }

}