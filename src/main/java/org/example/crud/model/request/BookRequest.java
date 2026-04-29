package org.example.crud.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.crud.model.entity.Category;

import java.sql.Timestamp;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookRequest {
    private String title;
    private Timestamp publishedDate;
    private Long authorId;

    private List<Category> categories;

    public long[] getCategoryId() {
            long[] categoryId = new long[categories.size()];
            return categories.stream().mapToLong(Category::getCategoryId).toArray();
    }
}
