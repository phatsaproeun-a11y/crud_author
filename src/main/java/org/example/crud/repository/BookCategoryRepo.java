package org.example.crud.repository;

import org.apache.ibatis.annotations.*;
import org.example.crud.model.entity.Book;
import org.example.crud.model.entity.Category;

import java.util.List;

@Mapper
public interface  BookCategoryRepo  {
    static void deleteByBookId(long bookId) {
    }

    @Select(
            """
    select c.category_id,c.category_name,from book_category bc 
        inner join category c on bc.category_id=c.category_id where book_id=#{bookId}
"""
    )

    @Results(id="BookCategoryMampper", value={
            @Result(property = "categoryId",column = "category_id"),
            @Result(property = "categoryName",column = "category_name"),
            @Result(property = "bookId",column = "book_id")
    })
    List<Category> getAllCategoryByBookId(long bookId);

    @Insert(
            """
    insert into book_category(book_id,category_id) values (#{bookId},#{categoryId})
""")

    @ResultMap("BookCategoryMapper")
    void insertBookCategory(long bookId, long categoryId);

    @Delete("""
DELETE  FROM book_category WHERE book_id=#{bookId}
""")
    @ResultMap("BookCategoryMapper")
    void deleteBookCategory(long aLong);
}
