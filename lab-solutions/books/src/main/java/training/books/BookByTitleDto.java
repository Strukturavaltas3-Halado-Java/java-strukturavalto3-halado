package training.books;

import lombok.Data;

@Data
public class BookByTitleDto {

    private Long id;

    private String isbn;

    private String title;

    private AuthorWithIdAndNameDto author;
}
