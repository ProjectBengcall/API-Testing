package Bengcall.user;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class CommentUserStepdefs {
    @Given("Create comment service with input id {int} and comment {string} and valid token")
    public void createCommentServiceWithIdAndComment(int id, String comment) {
        SerenityRest.given().log().all()
                .header("Authorization",BengcallAPIUser.VALID_TOKEN)
                .pathParam("id", id)
                .formParams("comment",comment);

    }
    @When("send request post comment with valid path")
    public void sendRequestPostCommentWithValidPath() {
        SerenityRest.when()
                .put(BengcallAPIUser.CUSTOMER_COMMENT_VALID_PATH);
    }


    @And("Put comment assert json validation")
    public void putCommentAssertJsonValidation() {
        File jsonFile = new File(BengcallAPIUser.JSON_FILE+"/JsonSchemaValidation/Customer/Comment/PutCommentUserValidTokenJsonSchemaValidation.json");
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonFile));

    }

    @When("send request post comment with invalid path")
    public void sendRequestPostCommentWithInvalidPath() {
        SerenityRest.when()
                .put(BengcallAPIUser.CUSTOMER_COMMENT_INVALID_PATH);
    }

    @And("response body message {string}, comment {string}")
    public void responseBodyMessageComment(String message, String comment) {
        SerenityRest.then()
                .body(BengcallAPIResponseUser.MESSAGE,equalTo(message))
                .body(BengcallAPIResponseUser.COMMENT,equalTo(comment));
    }

    @Given("Create comment service with input id {int} and comment {string} and expired token")
    public void createCommentServiceWithInputIdAndCommentAndExpiredToken(int id, String comment) {
        SerenityRest.given().log().all()
                .header("Authorization",BengcallAPIUser.EXPIRED_TOKEN)
                .pathParam("id", id)
                .formParams("comment",comment);
    }

    @Given("Create comment service with input id {string} and comment {string} and valid token")
    public void createCommentServiceWithInputIdAndCommentAndValidToken(String id, String comment) {
        SerenityRest.given().log().all()
                .header("Authorization",BengcallAPIUser.VALID_TOKEN)
                .pathParam("id", id)
                .formParams("comment",comment);
    }
}
