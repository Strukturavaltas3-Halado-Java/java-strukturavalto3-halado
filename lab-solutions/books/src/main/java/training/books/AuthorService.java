package training.books;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AuthorService {

    private AuthorRepository authorRepository;

    private BooksConverter converter;

    public AuthorDto createAuthor(CreateAuthorCommand command) {
        Author author = new Author(command.getName().toUpperCase());
        authorRepository.save(author);
        return converter.convert(author);
    }

    public List<AuthorDto> listAuthors() {
        return converter.convert(authorRepository.findAll());
    }
}
