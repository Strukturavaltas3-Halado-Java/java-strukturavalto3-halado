package training.books;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findByAuthorId(long authorId);

    @Query("select b from Book b where b.title like :title")
    List<Book> findByTitle(@Param("title") String titleFragment);
}
