package Bengcall;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

import java.io.File;

public class RegisterStepdefs {
    @Steps
    BengcallAPI bengcallAPI;
    @Given("post register customer with valid credential")
    public void postRegisterCustomerWithValidCredential() {
        File jsonFiles = new File(BengcallAPI.JSON_FILE+"/JsonRequestBody/Customer/POSTRegisterValidCustomer.json");
        bengcallAPI.postRegisterCustomer(jsonFiles);
    }

    @When("send request post register customer valid path")
    public void sendRequestPostRegisterCustomer() {
        SerenityRest.when()
                .post(BengcallAPI.POST_REGISTER_USER_VALID_PATH);
    }

    @And("Post register user assert json validation")
    public void postRegisterUserAssertJsonValidation() {
        File jsonFile = new File(BengcallAPI.JSON_FILE+"/JsonSchemaValidation/Customer/PostRegisterValidCustomerJsonSchemaValidation.json");
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonFile));
    }

    @Given("post register customer with invalid password less than 8 characters")
    public void postRegisterCustomerWithInvalidCredentialPasswordLessThanCharacters() {
        File jsonFiles = new File(BengcallAPI.JSON_FILE+"/JsonRequestBody/Customer/POSTRegisterCustomerInvalidPassword.json");
        bengcallAPI.postRegisterCustomer(jsonFiles);
    }

    @And("Post register user with invalid password assert json validation")
    public void postRegisterUserWithInvalidPasswordAssertJsonValidation() {
        File jsonFile = new File(BengcallAPI.JSON_FILE+"/JsonSchemaValidation/Customer/ErrorMessageJsonSchemaValidation.json");
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonFile));
    }

    @Given("post register customer without credentials")
    public void postRegisterCustomerWithoutCredentials() {
        File jsonFiles = new File(BengcallAPI.JSON_FILE+"/JsonRequestBody/Customer/POSTRegisterCustomerWithoutCredentials.json");
        bengcallAPI.postRegisterCustomer(jsonFiles);
    }

    @When("send request post register customer invalid path")
    public void sendRequestPostRegisterCustomerInvalidPath() {
        SerenityRest.when()
                .post(BengcallAPI.POST_REGISTER_USER_INVALID_PATH);
    }

    @And("Post register user with invalid path assert json validation")
    public void postRegisterUserWithInvalidPathAssertJsonValidation() {
        File jsonFile = new File(BengcallAPI.JSON_FILE+"/JsonSchemaValidation/Customer/ErrorMessageJsonSchemaValidation.json");
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonFile));
    }

    @Given("post register customer with one field mandatory is empty")
    public void postRegisterCustomerWithOneFieldMandatoryIsEmpty() {
        File jsonFiles = new File(BengcallAPI.JSON_FILE+"/JsonRequestBody/Customer/POSTRegisterCustomerOneField.json");
        bengcallAPI.postRegisterCustomer(jsonFiles);
    }

    @Given("post register customer with two field mandatory is empty")
    public void postRegisterCustomerWithTwoFieldMandatoryIsEmpty() {
        File jsonFiles = new File(BengcallAPI.JSON_FILE+"/JsonRequestBody/Customer/POSTRegisterCustomerTwoField.json");
        bengcallAPI.postRegisterCustomer(jsonFiles);
    }
}
