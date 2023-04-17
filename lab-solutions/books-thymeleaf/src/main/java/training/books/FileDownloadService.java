package training.books;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.core.io.PathResource;
import org.springframework.stereotype.Service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@Service
@AllArgsConstructor
public class FileDownloadService {

    private BookRepository bookRepository;

    @SneakyThrows
    public PathResource getfileWithAllBooks(String fileName) {
        List<Book> books = bookRepository.findAll();
        List<String> booksToFile = books.stream()
                .map(b -> b.toString())
                .toList();
        Files.write(Path.of("src/main/resources/" + fileName), booksToFile);
        return new PathResource("src/main/resources/" + fileName);
    }
}
