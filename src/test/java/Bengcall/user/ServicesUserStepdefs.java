package Bengcall.user;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class ServicesUserStepdefs {
    @Steps
    BengcallAPIUser bengcallAPIUser;
    @Given("Get see avalaible services with valid id vehicle {int}")
    public void getSeeAvalaibleServicesWithValidIdVehicleId(int id) {
        bengcallAPIUser.getServicesValidToken(id);
    }

    @And("Get all services assert json validation")
    public void getAllServicesAssertJsonValidation() {
        File jsonFile = new File(BengcallAPIUser.JSON_FILE+"/JsonSchemaValidation/Customer/Service/GetUserServiceValidTokenJsonSchemaValidation.json");
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonFile));
    }

    @And("Response body should contain message {string}, id {int}, service name {string}, price {int}, vehicle id {int}")
    public void responseBodyShouldContainMessageIdServiceNamePriceVehicleId(String message, int id, String serviceName, int price, int vehicleId) {
        SerenityRest.then()
                .body(BengcallAPIResponseUser.MESSAGE, equalTo(message))
                .body(BengcallAPIResponseUser.SERVICE_ID, equalTo(id))
                .body(BengcallAPIResponseUser.SERVICE_NAME, equalTo(serviceName))
                .body(BengcallAPIResponseUser.PRICE, equalTo(price))
                .body(BengcallAPIResponseUser.VEHICLE_ID, equalTo(vehicleId));

    }

    @When("send request get services type customer with valid path")
    public void sendRequestGetServicesTypeCustomerWithValidPath() {
        SerenityRest.when()
                .get(BengcallAPIUser.CUSTOMER_SERVICES_VALID_PATH);
    }

    @Given("Get see avalaible services with invalid id vehicle {string}")
    public void getSeeAvalaibleServicesWithIdVehicleDoesNotExist(String invalidId) {
        bengcallAPIUser.getServicesValidTokenAndInvalidId(invalidId);
    }

    @Given("Get see avalaible services with valid id vehicle does not exist {int}")
    public void getSeeAvalaibleServicesWithValidIdVehicleDoesNotExist(int id) {
        bengcallAPIUser.getServicesValidToken(id);
    }

    @When("send request get services type customer with invalid path")
    public void sendRequestGetServicesTypeCustomerWithInvalidPath() {
        SerenityRest.when()
                .get(BengcallAPIUser.CUSTOMER_SERVICES_INVALID_PATH);
    }

    @Given("Get see avalaible services with valid id vehicle {int} and expired token")
    public void getSeeAvalaibleServicesWithValidIdVehicleAndExpiredToken(int id) {
        bengcallAPIUser.getServicesExpiredTokenAndInvalidId(id);
    }
}
