package org.example.crud.service.impl;

import org.example.crud.model.entity.Author;
import org.example.crud.model.request.AuthorRequest;
import org.example.crud.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class AuthorServiceImpl implements AuthorService {
    @Override
    public List<Author> getAllAuthors() {
        return List.of();
    }

    @Override
    public Author createAuthor(AuthorRequest authorRequest) {
        return null;
    }

    @Override
    public Author updateAuthor(Long AuthorId, AuthorRequest authorRequest) {
        return null;
    }

    @Override
    public Author deleteAuthor(Long AuthorId) {
        return null;
    }

    @Override
    public Author getAuthorById(Long AuthorId) {
        return null;
    }

    @Override
    public List<Author> getAllAuthor() {
        return List.of();
    }
}
