package training.books;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
@RequestMapping("/authors")
@AllArgsConstructor
public class AuthorThymeleafController {

    private AuthorService service;

    @GetMapping("/{id}")
    public ModelAndView findAuthorById(@PathVariable("id") long id) {
        AuthorDto author = service.getAuthorWithBooks(id);
        Map<String, Object> model = Map.of(
                "author", author.getName(),
                "booksOfAuthor", author.getBooks()
        );
        return new ModelAndView("books", model);
    }
}
