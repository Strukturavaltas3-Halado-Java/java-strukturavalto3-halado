package training.books;

import lombok.Data;

import java.util.List;

@Data
public class AuthorDto {

    private Long id;

    private String name;

    private List<BookWithTitleAndIsbnDto> books;
}
