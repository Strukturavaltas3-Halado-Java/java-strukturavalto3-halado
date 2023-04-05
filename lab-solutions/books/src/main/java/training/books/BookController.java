package training.books;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/authors")
@AllArgsConstructor

public class BookController {

    private BookService bookService;

    @PostMapping("/{authorId}/books")
    public BookDto createBook(@PathVariable long authorId, @RequestBody CreateBookCommand command) {
        return bookService.createBook(authorId, command);
    }

    @GetMapping("/{authorId}/books")
    public List<BookDto> listBooks(@PathVariable long authorId) {
        return bookService.listBooks(authorId);
    }
}
