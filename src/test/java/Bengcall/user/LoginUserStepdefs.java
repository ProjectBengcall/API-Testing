package Bengcall.user;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

import java.io.File;
import static org.hamcrest.Matchers.equalTo;

public class LoginUserStepdefs {
    @Steps
    BengcallAPIUser bengcallAPIUser;
    @Given("post login customer with valid credentials")
    public void postLoginCustomerWithValidCredentials() {
        File jsonFiles = new File(BengcallAPIUser.JSON_FILE+"/JsonRequestBody/Customer/Login/POSTLoginUserValidUser.json");
        bengcallAPIUser.postLoginCustomer(jsonFiles);
    }

    @When("send request post login customer valid path")
    public void sendRequestPostLoginCustomerValidPath() {
        SerenityRest.when()
                .post(BengcallAPIUser.POST_LOGIN_USER_VALID_PATH);
    }

    @And("Post login customer success assert json validation")
    public void postLoginUserAssertJsonValidation() {
        File jsonFile = new File(BengcallAPIUser.JSON_FILE+"/JsonSchemaValidation/Customer/Login/PostLoginValidUserJsonSchemaValidation.json");
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonFile));
    }

    @Given("post Login customer with email field is empty")
    public void postLoginCustomerWithEmailFieldIsEmpty() {
        File jsonFiles = new File(BengcallAPIUser.JSON_FILE+"/JsonRequestBody/Customer/Login/POSTLoginUserInvalidEmailEmpty.json");
        bengcallAPIUser.postLoginCustomer(jsonFiles);
    }

    @Given("post Login customer with password field is empty")
    public void postLoginCustomerWithPasswordFieldIsEmpty() {
        File jsonFiles = new File(BengcallAPIUser.JSON_FILE+"/JsonRequestBody/Customer/Login/POSTLoginUserInvalidPasswordEmpty.json");
        bengcallAPIUser.postLoginCustomer(jsonFiles);
    }

    @Given("post Login customer without credentials")
    public void postLoginCustomerWithoutCredentials() {
        File jsonFiles = new File(BengcallAPIUser.JSON_FILE+"/JsonRequestBody/Customer/Login/POSTLoginUserWithoutCredentials.json");
        bengcallAPIUser.postLoginCustomer(jsonFiles);
    }

    @When("send request post login customer invalid path")
    public void sendRequestPostLoginCustomerInvalidPath() {
        SerenityRest.when()
                .post(BengcallAPIUser.POST_LOGIN_USER_INVALID_PATH);
    }

    @And("response body failedd assert json validation")
    public void responseBodyFailedAssertJsonValidation() {
        File jsonFile = new File(BengcallAPIUser.JSON_FILE+"/JsonSchemaValidation/Customer/ErrorMessageJsonSchemaValidation.json");
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonFile));
    }

    @And("Response body should contain message {string}, fullname {string}, role {int}")
    public void responseBodyShouldContainMessageFullnameImagesRoleToken(String message, String fullname, int role) {
        SerenityRest.then()
                .body(BengcallAPIResponseUser.MESSAGE,equalTo(message))
                .body(BengcallAPIResponseUser.FULLNAME,equalTo(fullname))
                .body(BengcallAPIResponseUser.ROLE, equalTo(role));
    }
}
