package Bengcall.Admin;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import java.io.File;
import static org.hamcrest.Matchers.equalTo;

public class VehicleServiceAdminStepdefs {

    @Steps
    BengcallAdminAPI bengcallAdminAPI;

    @Given("Get all service on a vehicle with valid token")
    public void getAllServiceOnAVehicleWithValidToken() {
        bengcallAdminAPI.adminValidToken();}

    @When("send request get all service on a vehicle with valid path")
    public void sendRequestGetAllServiceOnAVehicleWithValidPath() {
        SerenityRest
                .when()
                .get(BengcallAdminAPI.GET_VEHICLESERVICE_ADMIN);}

    @And("Get service on vehicle assert json validation")
    public void getServiceOnVehicleAssertJsonValidation() {
        File jsonFile = new File(BengcallAdminAPI
                .JSON_FILE+"/JsonSchemaValidation/Admin/VehicleService" +
                "/GetAdminVehicleServiceJsonSchemaValidation.json");
        SerenityRest
                .then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonFile));}

    @And("Response body success should contain message {}")
    public void responseBodySuccessShouldContainMessage(String message) {
        SerenityRest
                .then()
                .body(ResponseAdmin.MESSAGE, equalTo(message));}

    @Given("Get all service on a vehicle with invalid token")
    public void getAllServiceOnAVehicleWithInvalidToken() {
        bengcallAdminAPI.adminInvalidToken();}

    @And("response body failed assert json validation")
    public void responseBodyFailedAssertJsonValidation() {
        File jsonFile = new File(BengcallAdminAPI
                .JSON_FILE+"/JsonSchemaValidation/Admin/VehicleService" +
                "/GetAdminVehicleServiceInvalidJsonSchemaValidation.json");
        SerenityRest
                .then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonFile));}

    @And("Response body invalid path should contain message {}")
    public void responseBodyInvalidPathShouldContainMessage(String message) {
        SerenityRest
                .then()
                .body(ResponseAdmin.MESSAGE, equalTo(message));}

    @When("send request get all service on a vehicle with invalid path")
    public void sendRequestGetAllServiceOnAVehicleWithInvalidPath() {
        SerenityRest
                .when()
                .get(BengcallAdminAPI.GET_VEHICLESERVICE_INVALID_PATH_ADMIN);}

    @And("Post create new vehicle on admin response contain {} and message {}")
    public void postCreateNewVehicleOnAdminResponseContain(String name_vehicle, String message) {
        SerenityRest
                .then()
                .body(ResponseAdmin.NAME_VEHICLE,equalTo(name_vehicle))
                .body(ResponseAdmin.MESSAGE, equalTo(message));}
}
