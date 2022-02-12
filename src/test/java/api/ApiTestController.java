package api;

import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import model.ApiTestModel;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.equalTo;

public class ApiTestController {
    ValidatableResponse validateResponse;

    //    @Test
    public void getDataById(ApiTestModel model) {
        baseURI = "https://jsonplaceholder.cypress.io";

        this.validateResponse = null;
        this.validateResponse = given()
                .get("/posts?id=" + model.getId())
                .then()
                .statusCode(200);
    }

    public void schemaValidatorTest() {
        this.validateResponse.assertThat().body(matchesJsonSchemaInClasspath("schemaApiTest.json"));
    }

    @Test
    public void postDataTest(ApiTestModel model) {
        JSONObject request = new JSONObject();
        request.put("title", model.getTitle());
        request.put("body", model.getBody());
        request.put("userId", model.getUserId());

        baseURI = "https://jsonplaceholder.cypress.io";

        this.validateResponse = null;
        this.validateResponse = given()
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(request.toJSONString())
                .when()
                .post("/posts")
                .then()
                .statusCode(201);
    }

    public void postValidateTitleValue(String title) {
        this.validateResponse.body("title", equalTo(title));
    }

    public void postValidateBodyValue(String body) {
        this.validateResponse.body("body", equalTo(body));
    }

    public void postValidateUserIdValue(Integer userId) {
        this.validateResponse.body("userId", equalTo(userId));
    }

}
