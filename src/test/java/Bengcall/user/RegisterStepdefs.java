package Bengcall.user;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

import java.io.File;
import static org.hamcrest.Matchers.equalTo;

public class RegisterStepdefs {
    @Steps
    BengcallAPIUsers bengcallAPIUsers;
    @Given("post register customer with valid credential")
    public void postRegisterCustomerWithValidCredential() {
        File jsonFiles = new File(BengcallAPIUsers.JSON_FILE+"/JsonRequestBody/Customer/POSTRegisterValidCustomer.json");
        bengcallAPIUsers.postRegisterCustomer(jsonFiles);
    }

    @When("send request post register customer valid path")
    public void sendRequestPostRegisterCustomer() {
        SerenityRest.when()
                .post(BengcallAPIUsers.POST_REGISTER_USER_VALID_PATH);
    }

    @And("Post register customer assert json validation")
    public void postRegisterUserAssertJsonValidation() {
        File jsonFile = new File(BengcallAPIUsers.JSON_FILE+"/JsonSchemaValidation/Customer/PostRegisterValidCustomerJsonSchemaValidation.json");
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonFile));
    }

    @Given("post register customer with invalid password less than 8 characters")
    public void postRegisterCustomerWithInvalidCredentialPasswordLessThanCharacters() {
        File jsonFiles = new File(BengcallAPIUsers.JSON_FILE+"/JsonRequestBody/Customer/POSTRegisterCustomerInvalidPassword.json");
        bengcallAPIUsers.postRegisterCustomer(jsonFiles);
    }

    @And("Post register user with invalid password assert json validation")
    public void postRegisterUserWithInvalidPasswordAssertJsonValidation() {
        File jsonFile = new File(BengcallAPIUsers.JSON_FILE+"/JsonSchemaValidation/Customer/ErrorMessageJsonSchemaValidation.json");
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonFile));
    }

    @Given("post register customer without credentials")
    public void postRegisterCustomerWithoutCredentials() {
        File jsonFiles = new File(BengcallAPIUsers.JSON_FILE+"/JsonRequestBody/Customer/POSTRegisterCustomerWithoutCredentials.json");
        bengcallAPIUsers.postRegisterCustomer(jsonFiles);
    }

    @When("send request post register customer invalid path")
    public void sendRequestPostRegisterCustomerInvalidPath() {
        SerenityRest.when()
                .post(BengcallAPIUsers.POST_REGISTER_USER_INVALID_PATH);
    }

    @And("Post register user with invalid path assert json validation")
    public void postRegisterUserWithInvalidPathAssertJsonValidation() {
        File jsonFile = new File(BengcallAPIUsers.JSON_FILE+"/JsonSchemaValidation/Customer/ErrorMessageJsonSchemaValidation.json");
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonFile));
    }

    @Given("post register customer with one field mandatory is empty")
    public void postRegisterCustomerWithOneFieldMandatoryIsEmpty() {
        File jsonFiles = new File(BengcallAPIUsers.JSON_FILE+"/JsonRequestBody/Customer/POSTRegisterCustomerOneField.json");
        bengcallAPIUsers.postRegisterCustomer(jsonFiles);
    }

    @Given("post register customer with two field mandatory is empty")
    public void postRegisterCustomerWithTwoFieldMandatoryIsEmpty() {
        File jsonFiles = new File(BengcallAPIUsers.JSON_FILE+"/JsonRequestBody/Customer/POSTRegisterCustomerTwoField.json");
        bengcallAPIUsers.postRegisterCustomer(jsonFiles);
    }

    @And("Response body should contain fullname {string}, email {string}, message {string}")
    public void responseBodyShouldContainUserMessage(String fullname, String email, String message) {
        SerenityRest.then()
                .body(BengcallAPIResponseUser.FULLNAME,equalTo(fullname))
                .body(BengcallAPIResponseUser.EMAIL,equalTo(email))
                .body(BengcallAPIResponseUser.MESSAGE,equalTo(message));
    }

    @And("Response body invalid credentials should contain message {string}")
    public void responseBodyInvalidPasswordAndFullnameShouldContainMessage(String message) {
        SerenityRest.then()
                .body(BengcallAPIResponseUser.MESSAGE,equalTo(message));
    }

    @And("Response body invalid path should contain message {string}")
    public void responseBodyInvalidPathShouldContainMessage(String message) {
        SerenityRest.then()
                .body(BengcallAPIResponseUser.MESSAGE,equalTo(message));
    }
}
