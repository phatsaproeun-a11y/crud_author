package org.example.crud.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.security.Timestamp;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    private  Long bookId;
    private  String title;
    private  Timestamp publishedDate;
    private  Author author;

    private List<Category> categories;
}
