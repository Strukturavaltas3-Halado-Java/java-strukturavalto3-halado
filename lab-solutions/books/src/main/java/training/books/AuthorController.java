package training.books;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/authors")
@AllArgsConstructor
public class AuthorController {

    private AuthorService authorService;

    @PostMapping
    public AuthorDto createAuthor(@RequestBody CreateAuthorCommand command) {
        return authorService.createAuthor(command);
    }

    @GetMapping
    public List<AuthorDto> listAuthors() {
        return authorService.listAuthors();
    }
}
