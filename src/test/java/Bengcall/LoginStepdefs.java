package Bengcall;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

import java.io.File;

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

    @And("Post login user assert json validation")
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

    @And("Post login user with one credential empthy assert json validation")
    public void postLoginUserWithEmailEmpthyAssertJsonValidation() {
        File jsonFile = new File(BengcallAPI.JSON_FILE+"/JsonSchemaValidation/Customer/ErrorMessageJsonSchemaValidation.json");
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonFile));
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

    @And("Post login user with invalid path assert json validation")
    public void postLoginUserWithInvalidPathAssertJsonValidation() {
        File jsonFile = new File(BengcallAPI.JSON_FILE+"/JsonSchemaValidation/Customer/ErrorMessageJsonSchemaValidation.json");
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonFile));
    }
}
