package Bengcall;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

import java.io.File;

public class UsersStepdefs {
    @Steps
    BengcallAPI bengcallAPI;
    @Given("Get a customer profile with valid token")
    public void getACustomerProfileWithValidToken() {
        bengcallAPI.getCustomerProfileValidToken();
    }

    @When("send request customer profile valid path")
    public void sendRequestGetCustomerProfile() {
        SerenityRest.when()
                .get(BengcallAPI.CUSTOMER_PROFILE_VALID_PATH);
    }

    @And("Get customer profile assert json validation")
    public void getCustomerProfileAssertJsonValidation() {
        File jsonFile = new File(BengcallAPI.JSON_FILE+"/JsonSchemaValidation/Customer/GetCustomerProfileValidTokenJsonSchemaValidation.json");
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonFile));
    }

    @Given("Get a customer profile with expired token")
    public void getACustomerProfileWithExpiredToken() {
        bengcallAPI.getCustomerProfileExpiredToken();
    }

    @And("Get customer profile expired token assert json validation")
    public void getCustomerProfileExpiredTokenAssertJsonValidation() {
        File jsonFile = new File(BengcallAPI.JSON_FILE+"/JsonSchemaValidation/Customer/ErrorMessageJsonSchemaValidation.json");
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonFile));
    }

    @When("send request customer profile invalid path")
    public void sendRequestGetCustomerProfileInvalidPath() {
        SerenityRest.when()
                .get(BengcallAPI.CUSTOMER_PROFILE_INVALID_PATH);
    }

    @And("Get customer profile invalid path assert json validation")
    public void getCustomerProfileInvalidPathAssertJsonValidation() {
        File jsonFile = new File(BengcallAPI.JSON_FILE+"/JsonSchemaValidation/Customer/ErrorMessageJsonSchemaValidation.json");
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonFile));
    }

    @Given("Update customer profile with valid token")
    public void updateUserProfileWithValidToken() {
        File jsonFiles = new File(BengcallAPI.JSON_FILE+"/JsonRequestBody/Customer/PUTUpdateCustomerProfileValidCredentials.json");
        bengcallAPI.putUpdateCustomerProfileValidToken(jsonFiles);
    }

    @And("Put update customer profile valid token assert json validation")
    public void putUpdateCustomerProfileValidTokenAssertJsonValidation() {
        File jsonFile = new File(BengcallAPI.JSON_FILE+"/JsonSchemaValidation/Customer/PutUpdateCustomerProfileValidTokenJsonSchemaValidation.json");
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonFile));
    }

    @Given("Update a customer profile with expired token")
    public void updateACustomerProfileWithExpiredToken() {
        File jsonFiles = new File(BengcallAPI.JSON_FILE+"/JsonRequestBody/Customer/PUTUpdateCustomerProfileValidCredentials.json");
        bengcallAPI.putUpdateCustomerProfileExpiredToken(jsonFiles);
    }

    @Given("Update customer profile with password less than 8 characters")
    public void updateCustomerProfileWithPasswordLessThanCharacters() {
        File jsonFiles = new File(BengcallAPI.JSON_FILE+"/JsonRequestBody/Customer/PUTUpdateCustomerProfilePasswordLess.json");
        bengcallAPI.putUpdateCustomerProfileValidToken(jsonFiles);
    }

    @Given("Deactivate customer account with valid token")
    public void deactivateCustomerAccountWithValidToken() {
        bengcallAPI.deleteCustomerProfileValidToken();
    }

    @Given("Deactivate customer account with invalid token")
    public void deactivateCustomerAccountWithInvalidToken() {
        bengcallAPI.deleteCustomerProfileExpiredToken();
    }
}
