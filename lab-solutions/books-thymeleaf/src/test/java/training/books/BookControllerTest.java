package training.books;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BookControllerTest {

    @Autowired
    WebTestClient testClient;

    @Autowired
    BookController bookController;

    @Autowired
    AuthorController authorController;

    @Test
    public void testFindIsbnById(){
        AuthorDto author  =  testClient.post()
                .uri("/api/authors")
                .bodyValue(new CreateAuthorCommand("John Doe"))
                .exchange()
                .expectStatus().isCreated()
                .expectBody(AuthorDto.class).returnResult().getResponseBody();

       Long bookId = testClient.post()
                .uri("/api/books/"+author.getId())
                .bodyValue(new CreateBookCommand("1234","Titanic"))
                .exchange()
                .expectBody(BookDto.class).returnResult().getResponseBody().getId();

        String isbn = testClient.get()
                .uri("/api/books/"+bookId+"/isbn")
                .exchange()
                .expectBody(String.class).returnResult().getResponseBody();

        assertEquals("1234",isbn);
    }

}