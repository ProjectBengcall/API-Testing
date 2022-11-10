package Bengcall.user;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class HistoryUserStepdefs {
    @Steps
    BengcallAPIUser bengcallAPIUser;
    @Given("Get all service history with valid token")
    public void getAllServiceHistoryWithValidToken() {
        bengcallAPIUser.getAllServiceHistoryValidToken();
    }

    @When("send request get all service history valid path")
    public void sendRequestGetAllServiceHistoryValidPath() {
        SerenityRest.when()
                .get(BengcallAPIUser.CUSTOMER_ALL_SERVICE_HISTORY_VALID_PATH);
    }

    @And("Get all service history assert json validation")
    public void getAllServiceHistoryAssertJsonValidation() {
        File jsonFile = new File(BengcallAPIUser.JSON_FILE+"/JsonSchemaValidation/Customer/History/GetUserAllServiceHistoryValidTokenJsonSchemaValidation.json");
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonFile));
    }

    @When("send request get all service history invalid path")
    public void sendRequestGetAllServiceHistoryInvalidPath() {
        SerenityRest.when()
                .get(BengcallAPIUser.CUSTOMER_ALL_SERVICE_HISTORY_INVALID_PATH);
    }

    @And("response body message {string}")
    public void responseBodyMessage(String message) {
        SerenityRest.then()
                .body(BengcallAPIResponseUser.MESSAGE,equalTo(message));
    }

    @Given("Get all service history with expired token")
    public void getAllServiceHistoryWithExpiredToken() {
        bengcallAPIUser.getAllServiceHistoryExpiredToken();
    }
}
