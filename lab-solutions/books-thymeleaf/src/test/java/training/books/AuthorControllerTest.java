package training.books;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.net.URI;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Sql(statements = {"delete from books", "delete from authors"})
class AuthorControllerTest {

    @Autowired
    WebTestClient testClient;

    @Autowired
    AuthorController controller;

    @Test
    void createAuthor(){
       AuthorDto author  =  testClient.post()
                .uri("/api/authors")
                .bodyValue(new CreateAuthorCommand("John Doe"))
                .exchange()
                .expectStatus().isCreated()
                .expectBody(AuthorDto.class).returnResult().getResponseBody();

       assertEquals("JOHN DOE", author.getName());
       assertNotNull(author.getId());
    }

}