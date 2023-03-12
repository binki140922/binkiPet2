import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import model.LoginRequestModel;
import model.ResponseModel;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static specs.LoginSpec.loginRequestSpec;
import static specs.LoginSpec.loginResponseSpec;

public class RegressTest {

    @Test
    public void responseSuccessTest(){

        LoginRequestModel loginRequestModel = new LoginRequestModel();
        loginRequestModel.setEmail("eve.holt@reqres.in");
        loginRequestModel.setPassword("pistol");

        ResponseModel responseModel = RestAssured.given(loginRequestSpec)
                .body(loginRequestModel)
                .when()
                .post("/register")
                .then()
                .spec(loginResponseSpec)
                .statusCode(200)
                .extract().as(ResponseModel.class);

                assertThat(responseModel.getToken()).isEqualTo("QpwL5tke4Pnpja7X4");
                assertThat(responseModel.getId()).isEqualTo(4);
    }

    @Test
    public void emptyEmailTest() {

        LoginRequestModel loginRequestModel = new LoginRequestModel();
        loginRequestModel.setEmail("");
        loginRequestModel.setPassword("pistol");

        ResponseModel responseModel = RestAssured.given(loginRequestSpec)
                .body(loginRequestModel)
                .when()
                .post("/register")
                .then()
                .spec(loginResponseSpec)
                .statusCode(400)
                .extract().as(ResponseModel.class);

        assertThat(responseModel.getError()).isEqualTo("Missing email or username");
    }

    @Test
    public void emptyPasswordTest(){

        LoginRequestModel loginRequestModel = new LoginRequestModel();
        loginRequestModel.setEmail("eve.holt@reqres.in");
        loginRequestModel.setPassword("");

        ResponseModel responseModel = RestAssured.given(loginRequestSpec)
                .body(loginRequestModel)
                .when()
                .post("/register")
                .then()
                .spec(loginResponseSpec)
                .statusCode(400)
                .extract().as(ResponseModel.class);

        assertThat(responseModel.getError()).isEqualTo("Missing password");
    }

    @Test
    public void loginNotRegistrationUserTest(){

        LoginRequestModel loginRequestModel = new LoginRequestModel();
        loginRequestModel.setEmail("pistol");
        loginRequestModel.setPassword("eve.holt@reqres.in");

        ResponseModel responseModel = RestAssured.given(loginRequestSpec)
                .body(loginRequestModel)
                .when()
                .post("/register")
                .then()
                .spec(loginResponseSpec)
                .statusCode(400)
                .extract().as(ResponseModel.class);

        assertThat(responseModel.getError()).isEqualTo("Note: Only defined users succeed registration");
    }

    @Test
    public void badRequestTest(){

        LoginRequestModel loginRequestModel = new LoginRequestModel();
        loginRequestModel.setEmail("eve.holt@reqres.in");
        loginRequestModel.setPassword("pistol");

        ResponseModel responseModel = RestAssured.given(loginRequestSpec)
                .body(loginRequestModel)
                .contentType(ContentType.TEXT)
                .when()
                .post("/register")
                .then()
                .spec(loginResponseSpec)
                .statusCode(400)
                .extract().as(ResponseModel.class);

        assertThat(responseModel.getError()).isEqualTo("Missing email or username");
    }
}