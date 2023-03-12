package specs;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static helper.CustomAllureListener.withCustomTemplates;
import static io.restassured.RestAssured.with;

public class LoginSpec {

    public static RequestSpecification loginRequestSpec = with()
            .filter(withCustomTemplates())
            .log().uri()
            .log().headers()
            .log().body()
            .contentType(ContentType.JSON)
            .baseUri("https://reqres.in")
            .basePath("/api");



    public static ResponseSpecification loginResponseSpec = new ResponseSpecBuilder()
            .log(LogDetail.STATUS)
            .log(LogDetail.BODY)
            .build();
}
