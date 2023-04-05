package training.books;

import lombok.Data;

@Data
public class CreateBookCommand {

    private String isbn;

    private String title;
}
