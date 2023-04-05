package training.books;

import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BooksConverter {

    AuthorDto convert(Author author);

    BookDto convert(Book book);

    List<AuthorDto> convert(List<Author> all);

    List<BookDto> convertBooks(List<Book> books);
}
