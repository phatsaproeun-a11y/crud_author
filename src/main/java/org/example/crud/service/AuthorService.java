package org.example.crud.service;

import org.example.crud.model.entity.Author;
import org.example.crud.model.request.AuthorRequest;

import java.util.List;

public interface AuthorService {
    List<Author> getAllAuthors();

    Author createAuthor(AuthorRequest authorRequest);

    Author updateAuthor(Long AuthorId, AuthorRequest authorRequest);

    Author deleteAuthor(Long AuthorId);

    Author getAuthorById(Long AuthorId);


    List<Author> getAllAuthor();
}
