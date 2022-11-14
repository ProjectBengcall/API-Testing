package Bengcall.Admin;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import java.io.File;
import static org.hamcrest.Matchers.equalTo;
public class VehicleAdminStepdefs {

    @Steps
    BengcallAdminAPI bengcallAdminAPI;

    @Given("Get view all vehicle type on admin with valid path")
    public void getviewAllVehicleTypeOnAdminWithValidPath (){
        bengcallAdminAPI.getAllVehiclesTypeAdminValidToken();}


    @When("Send request view all vehicle type on admin")
    public void sendRequestViewAllVehicleTypeOnAdmin() {
        SerenityRest
                .when()
                .get(BengcallAdminAPI.GET_ALL_VEHICLE_ADMIN);}


    @And("View all vehicle type on admin assert json validation")
    public void viewAllVehicleTypeOnAdminAssertJsonValidation() {
        File jsonFile = new File(BengcallAdminAPI
                .JSON_FILE+"/JsonSchemaValidation/Admin/Vehicle" +
                "/GetAdminAllVehicleJsonSchemaValidation.json");
        SerenityRest
                .then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonFile));}

    @And("Get view all vehicle type on admin response contain {}")
    public void getViewAllVehicleTypeOnAdminResponseContain(String message) {
        SerenityRest
                .then()
                .body(ResponseAdmin.MESSAGE, equalTo(message));}

    @Given("Get view all vehicle type on admin with invalid path")
    public void getViewAllVehicleTypeWithInvalidPath() {
        bengcallAdminAPI.getAllVehiclesTypeAdminValidToken();}

    @When("Send request view all vehicle type on admin invalid path")
    public void sendRequestViewAllVehicleTypeOnAdminInvalidPath() {
        SerenityRest
                .when()
                .get(BengcallAdminAPI.GET_ALL_VEHICLE_ADMIN_INVALID_PATH);}

    @And("View all vehicle type on admin with invalid data assert json validation")
    public void viewAllVehicleTypeOnAdminWithInvalidPathAssertJsonValidation() {
        File jsonFile = new File(BengcallAdminAPI
                .JSON_FILE+"/JsonSchemaValidation/Admin/Vehicle" +
                "/GetAdminAllVehicleInvalidJsonSchemaValidation.json");
        SerenityRest
                .then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonFile));}

    @Given("Get view all vehicle type on admin with invalid token")
    public void getViewAllVehicleTypeOnAdminWithInvalidToken(){
        bengcallAdminAPI.getAllVehicleTypeAdminInvalidToken();}

    @Given("Set create vehicle type on admin request data")
    public void setCreateVehicleTypeOnAdminRequestData() {
        File jsonFiles = new File(BengcallAdminAPI
                .JSON_FILE+"/JsonRequestBody/Admin/Vehicle" +
                "/PostAdminCreateNewVehicle.json");
        bengcallAdminAPI.postCreateNewVehicleOnAdminWithToken(jsonFiles);}

    @When("Send request create new vehicle type on admin")
    public void sendRequestCreateNewVehicleTypeOnAdmin() {
        SerenityRest
                .when()
                .post(BengcallAdminAPI.POST_CREATE_VEHICLE_ADMIN);}

    @And("Post create new vehicle on admin with valid data assert json validation")
    public void postCreateNewVehicleOnAdminWithValidDataAssertJsonValidation() {
        File jsonFile = new File(BengcallAdminAPI
                .JSON_FILE+"/JsonSchemaValidation/Admin/Vehicle" +
                "/PostAdminCreateNewVehicleJsonSchemaValidation.json");
        SerenityRest
                .then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonFile));}

    @Given("Set create vehicle type on admin empty value request data")
    public void setCreateVehicleTypeOnAdminEmptyValueRequestData() {
        File jsonFiles = new File(BengcallAdminAPI
                .JSON_FILE+"/JsonRequestBody/Admin/Vehicle" +
                "/PostAdminCreateNewVehicleEmptyValue.json");
        bengcallAdminAPI.postCreateNewVehicleOnAdminWithToken(jsonFiles);}

    @And("Post create new vehicle with on admin with invalid data assert json validation")
    public void postCreateNewVehicleWithOnAdminWithInvalidDataAssertJsonValidation() {
        File jsonFile = new File(BengcallAdminAPI
                .JSON_FILE+"/JsonSchemaValidation/Admin/Vehicle" +
                "/PostAdminCreateNewVehicleInvalidJsonSchemaValidation.json");
        SerenityRest
                .then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonFile));}

    @And("Post create create new vehicle type on admin response contain {}")
    public void postCreateCreateNewVehicleTypeOnAdminResponseContain(String message) {
        SerenityRest
                .then()
                .body(ResponseAdmin.MESSAGE, equalTo(message));}

    @Given("Set create vehicle type on admin special character value request data")
    public void setCreateVehicleTypeOnAdminSpecialCharacterValueRequestData() {
        File jsonFiles = new File(BengcallAdminAPI
                .JSON_FILE+"/JsonRequestBody/Admin/Vehicle" +
                "/PostAdminCreateNewVehicleSpecCharacter.json");
        bengcallAdminAPI.postCreateNewVehicleOnAdminWithToken(jsonFiles);}

    @Given("Set create vehicle type on admin value request data with invalid token")
    public void setCreateVehicleTypeOnAdminValueRequestDataWithInvalidToken() {
        File jsonFiles = new File(BengcallAdminAPI
                .JSON_FILE+"/JsonRequestBody/Admin/Vehicle" +
                "/PostAdminCreateNewVehicle.json");
        bengcallAdminAPI.postCreateNewVehicleWithInvalidToken(jsonFiles);}

    @Given("Delete vehicle type on admin with valid id {}")
    public void deleteVehicleTypeOnAdminWithValidId(int id) {
        bengcallAdminAPI.deleteVehicleTypeAdmin(id);}

    @When("Send delete new vehicle type on admin")
    public void sendDeleteNewVehicleTypeOnAdmin() {
        SerenityRest
                .when()
                .delete(BengcallAdminAPI.DELETE_VEHICLE_TYPE_ADMIN);}

    @And("Delete vehicle type on admin assert json validation")
    public void deleteVehicleTypeOnAdminAssertJsonValidation() {
        File jsonFile = new File(BengcallAdminAPI
                .JSON_FILE+"/JsonSchemaValidation/Admin/Vehicle" +
                "/PostAdminCreateNewVehicleInvalidJsonSchemaValidation.json");
        SerenityRest
                .then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonFile));}

    @And("Delete new vehicle type on admin response contain {}")
    public void deleteNewVehicleTypeOnAdminResponseContain(String message) {
        SerenityRest
                .then()
                .body(ResponseAdmin.MESSAGE, equalTo(message));}

    @Given("Set valid admin token")
    public void setValidAdminToken() {
        bengcallAdminAPI.deleteVehicleAdminWithoutId();}

    @When("Send delete new vehicle type on admin without id")
    public void sendDeleteNewVehicleTypeOnAdminWithoutId() {
        SerenityRest
                .when()
                .delete(BengcallAdminAPI.DELETE_VEHICLE_TYPE_ADMIN_NO_ID);}


    @Given("Delete vehicle type on admin with special character on id {}")
    public void deleteVehicleTypeOnAdminWithSpecialCharacterOnId(String character) {
        bengcallAdminAPI.deleteVehicleTypeAdminWithSpecCharacter(character);}

    @When("Send delete new vehicle type on admin with special character")
    public void sendDeleteNewVehicleTypeOnAdminWithSpecialCharacter() {
        SerenityRest
                .when()
                .delete(BengcallAdminAPI.DELETE_VEHICLE_TYPE_ADMIN_SPEC_CHARACTER);}

    @Given("Delete vehicle type on admin with deleted id {}")
    public void deleteVehicleTypeOnAdminWithDeletedId(int id) {
        bengcallAdminAPI.deleteVehicleTypeAdmin(id);
    }
}
