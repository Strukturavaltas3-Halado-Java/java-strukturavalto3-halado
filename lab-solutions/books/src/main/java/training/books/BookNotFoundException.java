package training.books;

public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException(long id) {
        super("Cannot find book with id:"+id);
    }
}
