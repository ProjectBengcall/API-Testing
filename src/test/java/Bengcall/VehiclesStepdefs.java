package Bengcall;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class VehiclesStepdefs {
    @Steps
    BengcallAPI bengcallAPI;
    @Given("Get See all types of vehicles available to be serviced with valid token")
    public void getSeeAllTypesOfVehiclesAvailableToBeServicedWithValidToken() {
        bengcallAPI.getVehiclesValidToken();
    }

    @When("send request get vehicles valid path")
    public void sendRequestGetVehiclesValidPath() {
        SerenityRest.when()
                .get(BengcallAPI.CUSTOMER_VEHICLES_VALID_PATH);
    }

    @And("Get vehicles assert json validation")
    public void getVehiclesAssertJsonValidation() {
        File jsonFile = new File(BengcallAPI.JSON_FILE+"/JsonSchemaValidation/Customer/GetCustomerVehiclesValidTokenJsonSchemaValidation.json");
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonFile));
    }

    @Given("Get See all types of vehicles available to be serviced with expired token")
    public void getSeeAllTypesOfVehiclesAvailableToBeServicedWithExpiredToken() {
        bengcallAPI.getVehiclesExpiredToken();
    }

    @When("send request get vehicles invalid path")
    public void sendRequestGetVehiclesInvalidPath() {
        SerenityRest.when()
                .get(BengcallAPI.CUSTOMER_VEHICLES_INVALID_PATH);
    }

    @And("Response body should contain message {string}, data pertama id {int}, data pertama name {string}")
    public void responseBodyShouldContainMessageDataIdDataName(String message, int id, String name) {
        SerenityRest.then()
                .body(BengcallAPIResponse.MESSAGE, equalTo(message))
                .body(BengcallAPIResponse.DATA_ID, equalTo(id))
                .body(BengcallAPIResponse.DATA_NAME,equalTo(name));
    }
}
