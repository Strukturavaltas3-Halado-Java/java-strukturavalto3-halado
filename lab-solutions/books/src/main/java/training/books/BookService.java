package training.books;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class BookService {

    private BookRepository bookRepository;

    private AuthorRepository authorRepository;

    private BooksConverter booksConverter;


    public List<BookDto> listBooks(long authorId) {
        List<Book> books = bookRepository.findByAuthorId(authorId);
        log.info("Books: {}", books);
        return booksConverter.convertBooks(books);
    }

    public BookDto createBook(long authorId, CreateBookCommand command) {
        Author author = authorRepository.getReferenceById(authorId); // Nincs SQL!
        System.out.println(author.getId());
        Book book = new Book(command.getIsbn(), command.getTitle(), author);
        bookRepository.save(book);
        return booksConverter.convert(book);
    }

    public List<BookByTitleDto> listBooksByTitle(String titleFragment) {
        return booksConverter.convertBooksWithAuthor(bookRepository.findByTitle("%" + titleFragment + "%"));
    }

    public String getBookIsbnById(long id) {
        Book book = bookRepository.findById(id).orElseThrow(()->new BookNotFoundException(id));
        return book.getIsbn();
    }
}
