package Bengcall;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

import java.io.File;
import static org.hamcrest.Matchers.equalTo;

public class LoginStepdefs {
    @Steps
    BengcallAPI bengcallAPI;
    @Given("post login customer with valid credentials")
    public void postLoginCustomerWithValidCredentials() {
        File jsonFiles = new File(BengcallAPI.JSON_FILE+"/JsonRequestBody/Customer/POSTLoginValidCustomer.json");
        bengcallAPI.postLoginCustomer(jsonFiles);
    }

    @When("send request post login customer valid path")
    public void sendRequestPostLoginCustomerValidPath() {
        SerenityRest.when()
                .post(BengcallAPI.POST_LOGIN_USER_VALID_PATH);
    }

    @And("Post login customer success assert json validation")
    public void postLoginUserAssertJsonValidation() {
        File jsonFile = new File(BengcallAPI.JSON_FILE+"/JsonSchemaValidation/Customer/PostLoginValidCustomerJsonSchemaValidation.json");
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonFile));
    }

    @Given("post Login customer with email field is empty")
    public void postLoginCustomerWithEmailFieldIsEmpty() {
        File jsonFiles = new File(BengcallAPI.JSON_FILE+"/JsonRequestBody/Customer/POSTLoginInvalidEmailEmpty.json");
        bengcallAPI.postLoginCustomer(jsonFiles);
    }

    @Given("post Login customer with password field is empty")
    public void postLoginCustomerWithPasswordFieldIsEmpty() {
        File jsonFiles = new File(BengcallAPI.JSON_FILE+"/JsonRequestBody/Customer/POSTLoginInvalidPasswoedEmpty.json");
        bengcallAPI.postLoginCustomer(jsonFiles);
    }

    @Given("post Login customer without credentials")
    public void postLoginCustomerWithoutCredentials() {
        File jsonFiles = new File(BengcallAPI.JSON_FILE+"/JsonRequestBody/Customer/POSTLoginWithoutCredentials.json");
        bengcallAPI.postLoginCustomer(jsonFiles);
    }

    @When("send request post login customer invalid path")
    public void sendRequestPostLoginCustomerInvalidPath() {
        SerenityRest.when()
                .post(BengcallAPI.POST_LOGIN_USER_INVALID_PATH);
    }

    @And("response body failed assert json validation")
    public void responseBodyFailedAssertJsonValidation() {
        File jsonFile = new File(BengcallAPI.JSON_FILE+"/JsonSchemaValidation/Customer/ErrorMessageJsonSchemaValidation.json");
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonFile));
    }

    @And("Response body should contain message {string}, fullname {string}, images {string}, role {int},  token {string}")
    public void responseBodyShouldContainMessageFullnameImagesRoleToken(String message, String fullname, String images, int role, String token) {
        SerenityRest.then()
                .body(BengcallAPIResponse.MESSAGE,equalTo(message))
                .body(BengcallAPIResponse.FULLNAME,equalTo(fullname))
                .body(BengcallAPIResponse.IMAGES,equalTo(images))
                .body(BengcallAPIResponse.ROLE, equalTo(role))
                .body(BengcallAPIResponse.TOKEN, equalTo(token));

    }
}
