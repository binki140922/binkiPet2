package settings.util;

import io.restassured.RestAssured;
import settings.config.TestConfiguration;
import settings.helpers.CustomAllureListener;

import static java.lang.String.format;

public class BrowserstackUtil {

    public static String getUrlVideo(String sessionId) {
        String url = format("https://api.browserstack.com/app-automate/sessions/%s.json", sessionId);

        return RestAssured.given()
                .log().all()
                .filter(CustomAllureListener.withCustomTemplates())
                .auth().basic(TestConfiguration.login, TestConfiguration.userPassword)
                .when()
                .get(url)
                .then()
                .log().all()
                .statusCode(200)
                .extract().path("automation_session.video_url");
    }
}
