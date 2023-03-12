import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.is;

public class RegressTest {

    String BASE_UTL = "https://reqres.in/api/register";

    @Test
    public void responseSuccessTest(){

        String data = "{\"email\": \"eve.holt@reqres.in\",     \"password\": \"pistol\"}";
        RestAssured.given()
                .log().uri()
                .contentType(ContentType.JSON)
                .body(data)
                .when()
                .post(BASE_UTL)
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .body("id",is(4))
                .body("token", is("QpwL5tke4Pnpja7X4"));
    }

    @Test
    public void emptyEmailTest(){

        String data = "{\"email\": \"\",     \"password\": \"pistol\"}";
        RestAssured.given()
                .log().uri()
                .contentType(ContentType.JSON)
                .body(data)
                .when()
                .post(BASE_UTL)
                .then()
                .log().status()
                .log().body()
                .statusCode(400)
                .body("error", is("Missing email or username"));
    }

    @Test
    public void emptyPasswordTest(){

        String data = "{\"email\": \"eve.holt@reqres.in\",     \"password\": \"\"}";
        RestAssured.given()
                .log().uri()
                .contentType(ContentType.JSON)
                .body(data)
                .when()
                .post(BASE_UTL)
                .then()
                .log().status()
                .log().body()
                .statusCode(400)
                .body("error", is("Missing password"));
    }

    @Test
    public void loginNotRegistrationUserTest(){

        String data = "{\"email\": \"pistol\",     \"password\": \"eve.holt@reqres.in\"}";
        RestAssured.given()
                .log().uri()
                .contentType(ContentType.JSON)
                .body(data)
                .when()
                .post(BASE_UTL)
                .then()
                .log().status()
                .log().body()
                .statusCode(400)
                .body("error", is("Note: Only defined users succeed registration"));
    }

    @Test
    public void badRequestTest(){

        String data = "{\"email\": \"pistol\",     \"password\": \"eve.holt@reqres.in\"}";
        RestAssured.given()
                .log().uri()
                .body(data)
                .when()
                .post(BASE_UTL)
                .then()
                .log().status()
                .log().body()
                .statusCode(400)
                .body("error", is("Missing email or username"));
    }
}
