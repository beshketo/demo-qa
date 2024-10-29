import io.restassured.http.ContentType;
import lms.ithillel.ua.User;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.net.http.HttpRequest;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;

import static org.hamcrest.Matchers.equalTo;

public class ApiTest {
    HttpRequest request;
    @BeforeTest
    public void setUp() {
    }

    @Test
    public void getAllBooksTest() {

        RestAssured.given()
                .when()
                .baseUri("https://demoqa.com/BookStore/v1/Books")
                .contentType(ContentType.JSON)
                .then()
                .statusCode(200).body("status", equalTo("Success"))
                .body("books", Matchers.notNullValue());
    }

    @Test
    public void authorisedUser(){

        RestAssured.given()
                .when()
                .baseUri("https://demoqa.com/")
                .contentType(ContentType.JSON)
                .body(getRequestBody(generateUser()))
                .when()
                .post("/Account/v1/Authorized")
                .then()
                .statusCode(200)
                .body(Matchers.equalTo("true"));

    }

    @Test
    public void generateToken(){
        RestAssured.given()
                .when()
                .baseUri("https://demoqa.com/")
                .contentType(ContentType.JSON)
                .body(getRequestBody(generateUser()))
                .when()
                .post("/Account/v1/GenerateToken")
                .then()
                .statusCode(200)
                .body("token", Matchers.notNullValue())
                .body("expires", Matchers.notNullValue())
                .log().all();;
    }

    @Test
    public void getFirstBooksTest() {
        String isbn = "9781449325862";
        String expectedTitle = "Git Pocket Guide";
        RestAssured.given()
                .when()
                .baseUri("https://demoqa.com/BookStore/v1/Book?ISBN=" + isbn)
                .contentType(ContentType.JSON)
                .then()
                .statusCode(200).body("status", equalTo("Success"))
                .body("isbn", Matchers.containsString(isbn))
                .body("title", Matchers.containsString(expectedTitle));
    }


    private String getRequestBody(Object o) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(o);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public User generateUser(){
        return new User("John1234", "Ntesttest77!!");
    }

}




