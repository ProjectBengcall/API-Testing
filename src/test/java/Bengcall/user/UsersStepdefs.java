package Bengcall.user;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

import java.io.File;
import static org.hamcrest.Matchers.equalTo;

public class UsersStepdefs {
    @Steps
    BengcallAPIUsers bengcallAPI;
    @Given("Get a customer profile with valid token")
    public void getACustomerProfileWithValidToken() {
        bengcallAPI.getCustomerProfileValidToken();
    }

    @When("send request get customer profile valid path")
    public void sendRequestGetCustomerProfile() {
        SerenityRest.when()
                .get(BengcallAPIUsers.CUSTOMER_PROFILE_VALID_PATH);
    }
    @When("send request put customer profile valid path")
    public void sendRequestPutCustomerProfile() {
        SerenityRest.when()
                .put(BengcallAPIUsers.CUSTOMER_PROFILE_VALID_PATH);
    }
    @When("send request delete customer profile valid path")
    public void sendRequestDeleteCustomerProfile() {
        SerenityRest.when()
                .delete(BengcallAPIUsers.CUSTOMER_PROFILE_VALID_PATH);
    }

    @And("Get customer profile assert json validation")
    public void getCustomerProfileAssertJsonValidation() {
        File jsonFile = new File(BengcallAPIUsers.JSON_FILE+"/JsonSchemaValidation/Customer/GetCustomerProfileValidTokenJsonSchemaValidation.json");
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
        File jsonFile = new File(BengcallAPIUsers.JSON_FILE+"/JsonSchemaValidation/Customer/ErrorMessageJsonSchemaValidation.json");
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonFile));
    }

    @When("send request get customer profile invalid path")
    public void sendRequestGetCustomerProfileInvalidPath() {
        SerenityRest.when()
                .get(BengcallAPIUsers.CUSTOMER_PROFILE_INVALID_PATH);
    }
    @When("send request put customer profile invalid path")
    public void sendRequestPutCustomerProfileInvalidPath() {
        SerenityRest.when()
                .put(BengcallAPIUsers.CUSTOMER_PROFILE_INVALID_PATH);
    }
    @When("send request delete customer profile invalid path")
    public void sendRequestDeleteCustomerProfileInvalidPath() {
        SerenityRest.when()
                .delete(BengcallAPIUsers.CUSTOMER_PROFILE_INVALID_PATH);
    }

    @And("Get customer profile invalid path assert json validation")
    public void getCustomerProfileInvalidPathAssertJsonValidation() {
        File jsonFile = new File(BengcallAPIUsers.JSON_FILE+"/JsonSchemaValidation/Customer/ErrorMessageJsonSchemaValidation.json");
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonFile));
    }

    @Given("Update customer profile with valid token")
    public void updateUserProfileWithValidToken() {
        File jsonFiles = new File(BengcallAPIUsers.JSON_FILE+"/JsonRequestBody/Customer/PUTUpdateCustomerProfileValidCredentials.json");
        bengcallAPI.putUpdateCustomerProfileValidToken(jsonFiles);
    }

    @And("Put update customer profile valid token assert json validation")
    public void putUpdateCustomerProfileValidTokenAssertJsonValidation() {
        File jsonFile = new File(BengcallAPIUsers.JSON_FILE+"/JsonSchemaValidation/Customer/PutUpdateCustomerProfileValidTokenJsonSchemaValidation.json");
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonFile));
    }

    @Given("Update a customer profile with expired token")
    public void updateACustomerProfileWithExpiredToken() {
        File jsonFiles = new File(BengcallAPIUsers.JSON_FILE+"/JsonRequestBody/Customer/PUTUpdateCustomerProfileValidCredentials.json");
        bengcallAPI.putUpdateCustomerProfileExpiredToken(jsonFiles);
    }

    @Given("Update customer profile with password less than 8 characters")
    public void updateCustomerProfileWithPasswordLessThanCharacters() {
        File jsonFiles = new File(BengcallAPIUsers.JSON_FILE+"/JsonRequestBody/Customer/PUTUpdateCustomerProfilePasswordLess.json");
        bengcallAPI.putUpdateCustomerProfileValidToken(jsonFiles);
    }

    @Given("Deactivate customer account with valid token")
    public void deactivateCustomerAccountWithValidToken() {
        bengcallAPI.deleteCustomerAccountValidToken();
    }

    @Given("Deactivate customer account with invalid token")
    public void deactivateCustomerAccountWithInvalidToken() {
        bengcallAPI.deleteCustomerAccountExpiredToken();
    }

    @And("Delete customer accound assert json validation")
    public void deleteCustomerAccoundAssertJsonValidation() {
        File jsonFile = new File(BengcallAPIUsers.JSON_FILE+"/JsonSchemaValidation/Customer/DeleteCustomerAccountValidTokenJsonSchemaValidation.json");
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonFile));
    }

    @Given("Deactivate customer account on customer account is already delete")
    public void deactivateCustomerAccountOnCustomerAccountIsAlreadyDelete() {
        bengcallAPI.deleteCustomerAccountIsNotExist();
    }

    @And("Response body should contain message {string}, id {int} fullname {string}, images {string}, email {string}")
    public void responseBodyShouldContainMessageIdFullnameImagesEmail(String message, int id, String fullname, String images, String email) {
        SerenityRest.then()
                .body(BengcallAPIResponseUser.MESSAGE, equalTo(message))
                .body(BengcallAPIResponseUser.ID, equalTo(id))
                .body(BengcallAPIResponseUser.FULLNAME, equalTo(fullname))
                .body(BengcallAPIResponseUser.IMAGES, equalTo(images))
                .body(BengcallAPIResponseUser.EMAIL, equalTo(email));
    }

    @And("Response body should contain message {string}, fullname {string}, images {string}, email {string}")
    public void responseBodyShouldContainMessageFullnameImagesEmail(String message, String fullname, String images, String email) {
        SerenityRest.then()
                .body(BengcallAPIResponseUser.MESSAGE, equalTo(message))
                .body(BengcallAPIResponseUser.FULLNAME, equalTo(fullname))
                .body(BengcallAPIResponseUser.IMAGES, equalTo(images))
                .body(BengcallAPIResponseUser.EMAIL, equalTo(email));
    }

    @And("Response body delete account should contain message {string}")
    public void responseBodyShouldContainMessage(String message) {
        SerenityRest.then()
                .body(BengcallAPIResponseUser.MESSAGE, equalTo(message));
    }
}
