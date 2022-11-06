package Bengcall;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.in;

public class ServicesCustomerStepdefs {
    @Steps
    BengcallAPI bengcallAPI;
    @Given("Get see avalaible services with valid id vehicle {int}")
    public void getSeeAvalaibleServicesWithValidIdVehicleId(int id) {
        bengcallAPI.getServicesValidToken(id);

    }

    @And("Get all services assert json validation")
    public void getAllServicesAssertJsonValidation() {
        File jsonFile = new File(BengcallAPI.JSON_FILE+"/JsonSchemaValidation/Customer/GetCustomerServiceValidTokenJsonSchemaValidation.json");
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonFile));
    }

    @And("Response body should contain message {string}, id {int}, service name {string}, price {int}, vehicle id {int}")
    public void responseBodyShouldContainMessageIdServiceNamePriceVehicleId(String message, int id, String serviceName, int price, int vehicleId) {
        SerenityRest.then()
                .body(BengcallAPIResponse.MESSAGE, equalTo(message))
                .body(BengcallAPIResponse.SERVICE_ID, equalTo(id))
                .body(BengcallAPIResponse.SERVICE_NAME, equalTo(serviceName))
                .body(BengcallAPIResponse.PRICE, equalTo(price))
                .body(BengcallAPIResponse.VEHICLE_ID, equalTo(vehicleId));

    }

    @When("send request get services type customer with valid path")
    public void sendRequestGetServicesTypeCustomerWithValidPath() {
        SerenityRest.when()
                .get(BengcallAPI.CUSTOMER_SERVICES_VALID_PATH);
    }

    @Given("Get see avalaible services with invalid id vehicle {string}")
    public void getSeeAvalaibleServicesWithIdVehicleDoesNotExist(String invalidId) {
        bengcallAPI.getServicesValidTokenAndInvalidId(invalidId);
    }

    @Given("Get see avalaible services with valid id vehicle does not exist {int}")
    public void getSeeAvalaibleServicesWithValidIdVehicleDoesNotExist(int id) {
        bengcallAPI.getServicesValidToken(id);
    }

    @When("send request get services type customer with invalid path")
    public void sendRequestGetServicesTypeCustomerWithInvalidPath() {
        SerenityRest.when()
                .get(BengcallAPI.CUSTOMER_SERVICES_INVALID_PATH);
    }

    @Given("Get see avalaible services with valid id vehicle {int} and expired token")
    public void getSeeAvalaibleServicesWithValidIdVehicleAndExpiredToken(int id) {
        bengcallAPI.getServicesExpiredTokenAndInvalidId(id);

    }
}
