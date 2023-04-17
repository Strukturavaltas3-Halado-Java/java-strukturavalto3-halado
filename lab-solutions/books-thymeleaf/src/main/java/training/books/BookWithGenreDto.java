package training.books;

import lombok.Data;

@Data
public class BookWithGenreDto {

    private Long id;

    private String isbn;

    private String title;

    private Genre genre;
}
