package training.books;

import lombok.Data;

@Data
public class BookDto {

    private Long id;

    private String isbn;

    private String title;

    private AuthorDto author;
}
