package Bengcall.user;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

import java.io.File;

public class VehicleServiceStepdefs {
    @Steps
    BengcallAPIUser bengcallAPIUser;
    @Given("Get all service on a vehicle with valid token")
    public void getAllServiceOnAVehicleWithValidToken() {
        bengcallAPIUser.getVehicleServiceValidToken();
    }

    @When("send request get all service on a vehicle with valid path")
    public void sendRequestGetAllServiceOnAVehicleWithValidPath() {
        SerenityRest.when()
                .get(BengcallAPIUser.VEHICLE_SERVICE_VALID_PATH);
    }

    @And("Get service on vehicle assert json validation")
    public void getServiceOnVehicleAssertJsonValidation() {
        File jsonFile = new File(BengcallAPIUser.JSON_FILE+"/JsonSchemaValidation/Customer/VehicleService/GetVehicleServiceValidTokenJsonSchemaValidation.json");
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonFile));

    }

    @Given("Get all service on a vehicle with expired token")
    public void getAllServiceOnAVehicleWithExpiredToken() {
        bengcallAPIUser.getVehicleServiceExpiredToken();
    }

    @When("send request get all service on a vehicle with invalid path")
    public void sendRequestGetAllServiceOnAVehicleWithInvalidPath() {
        SerenityRest.when()
                .get(BengcallAPIUser.VEHICLE_SERVICE_INVALID_PATH);
    }
}
