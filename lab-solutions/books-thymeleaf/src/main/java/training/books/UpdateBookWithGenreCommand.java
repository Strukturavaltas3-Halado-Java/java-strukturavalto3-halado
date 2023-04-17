package training.books;

import lombok.Getter;

@Getter
public class UpdateBookWithGenreCommand {

    @ValidGenre
    private String genre;
}
