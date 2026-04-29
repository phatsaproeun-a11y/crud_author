package org.example.crud.repository;


import org.apache.ibatis.annotations.*;
import org.example.crud.model.entity.Book;
import org.example.crud.model.request.BookRequest;

import java.util.List;

@Mapper
public interface BookRepo {
    @Results(id = "BookMapper", value = {
            @Result(property = "bookId", column = "books_id"),
            @Result(property = "title", column = "title"),
            @Result(property = "categoryId",column = "category_id"),
            @Result(property = "categoryName",column = "category_name"),
            @Result(
                    property = "publishedDate",
                    column = "published_date",
                    javaType = java.sql.Timestamp.class
            ),

            @Result(property = "author", column = "authors_id",
                    one = @One(select = "org.example.test_crud.repository.AuthorRepo.getAuthorById"),
                    many=@Many(select = "org.example.crud.repository.BookCategoryRepo.getAllCategoryByBookId")
            )
    })

    //   SELECT ALL BOOKS
    @Select("SELECT * FROM books OFFSET #{offset} LIMIT #{size}")
    List<Book> getAllBooks(int offset, int size);

    //    INSERT BOOK
    @Select("INSERT INTO books(title, published_date, authors_id) VALUES (#{title}, #{publishedDate}, #{author.authorId}) RETURNING *")
    @ResultMap("BookMapper")
    Book addBook(Book book);

    //    UPDATE BOOK
    @Select("""
     update books set title = #{req.title}, published_date = #{req.publishedDate}, authors_id = #{req.authorId}
     where books_id = #{books_id} returning *
    """)
    @ResultMap("BookMapper")
    Book updateBook(@Param("books_id") Long bookId, @Param("req") BookRequest bookRequest);

    //    GET BOOK BY ID
    @Select("""
        select * from books where books_id = #{bookId}
    """)
    @ResultMap("BookMapper")
    Book getBookById(Long bookId);

    //    DELETE MOTHODS
    @Select("DELETE FROM books WHERE books_id = #{bookId} RETURNING *")
    @ResultMap("BookMapper")
    Book deleteBook(Long bookId);
}
