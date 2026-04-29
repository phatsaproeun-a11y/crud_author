package org.example.crud.repository;

import org.apache.ibatis.annotations.*;
import org.example.crud.model.entity.Author;
import org.example.crud.model.request.AuthorRequest;


import java.util.List;

@Mapper
public interface AuthorRepo {
    @Select(
            """
            select * from authors"""
    )
    @Results(id ="AuthorMapper",value={
            @Result(property="authorId", column="author_id"),
            @Result(property="authorName",column="author_name"),
            @Result(property="gender",column="gender")
    })

    List<Author> getAllAuthors();

    @Select("INSERT INTO authors(author_name,gender)) VALUES(#{reg.authorName},#{reg.gender}) RETURNING*")
    @ResultMap("AuthorMapper")

    Author createAuthor(@Param("reg") AuthorRequest authorRequest);

    @Select("""
           UPDATDE authors SET author_name=#{reg.authorName}, gender=#{gender} WHERE author_id=#{reg.authorId} RETURNING*""")
    @ResultMap("AuthorMapper")
    Author UpdateAuthor(@Param("author_id") Long authorId, @Param("reg") AuthorRequest authorRequest);

    @Select("""
            DELETE FROM authors WHERE author_id=#{authorId} RETURNING*""")
    @ResultMap("AuthorMapper")
    Author deleteAuthor(Long authorId);

    @Select("""
            SELECT * FROM authors WHERE author_id=#{reg.authorId}""")
    @ResultMap("AuthorMapper")
    Author getAuthorById(Long authorId);

}
