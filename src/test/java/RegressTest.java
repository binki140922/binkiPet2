import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.is;

public class RegressTest {

    String BASE_UTL = "https://reqres.in/api/register";

    @Test
    public void ResponseSuccessTest(){

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
    public void EmptyEmailTest(){

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
    public void EmptyPasswordTest(){

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
    public void LoginNotRegistrationUserTest(){

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
    public void BadRequestTest(){

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
