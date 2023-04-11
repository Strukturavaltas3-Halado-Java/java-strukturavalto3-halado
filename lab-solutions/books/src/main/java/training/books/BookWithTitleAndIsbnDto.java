package training.books;

import lombok.Data;

@Data
public class BookWithTitleAndIsbnDto {

    private Long id;

    private String isbn;

    private String title;

}
