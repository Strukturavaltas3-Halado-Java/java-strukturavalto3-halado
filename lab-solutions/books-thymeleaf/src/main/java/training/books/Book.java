package training.books;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Entity
@Table(name = "books")
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String isbn;

    private String title;

    @ManyToOne
    @ToString.Exclude
    private Author author;

    @Enumerated(EnumType.STRING)
    private Genre genre;

    public Book(String isbn, String title, Author author) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "isbn='" + isbn + '\'' +
                ", author'" + author.getName() + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
