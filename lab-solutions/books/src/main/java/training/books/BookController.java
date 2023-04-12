package training.books;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
@AllArgsConstructor

public class BookController {

    private BookService bookService;

    @PostMapping("/{authorId}")
    public BookDto createBook(@PathVariable long authorId, @RequestBody CreateBookCommand command) {
        return bookService.createBook(authorId, command);
    }

    @GetMapping("/{authorId}")
    public List<BookDto> listBooks(@PathVariable long authorId) {
        return bookService.listBooks(authorId);
    }

    @GetMapping
    public List<BookByTitleDto> listBooksByTitle(@RequestParam String titleFragment) {
        return bookService.listBooksByTitle(titleFragment);
    }

    @GetMapping("/{id}/isbn")
    public String findBookIsbnById(@PathVariable("id") long id){
        return bookService.getBookIsbnById(id);
    }
}
