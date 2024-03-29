package training.books;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/authors")
@AllArgsConstructor
public class AuthorController {

    private AuthorService authorService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AuthorDto createAuthor(@RequestBody CreateAuthorCommand command) {
        return authorService.createAuthor(command);
    }

    @GetMapping
    public List<AuthorDto> listAuthors() {
        return authorService.listAuthors();
    }

    @GetMapping("/{id}")
    public AuthorDto getAuthorWithBooks(@PathVariable("id") long id) {
        return authorService.getAuthorWithBooks(id);
    }
}
