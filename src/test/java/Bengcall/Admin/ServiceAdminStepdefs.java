package Bengcall.Admin;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import java.io.File;
import static org.hamcrest.Matchers.equalTo;

public class ServiceAdminStepdefs {
    @Steps
    BengcallAdminAPI bengcallAdminAPI;

    @Given("Set view all service information type on admin with valid token and id {}")
    public void setViewAllAerviceInformationTypeOnAdminWithValidTokenAndId(int id){
        bengcallAdminAPI.getAllServiceTypeOnAdminWithIdAndtoken(id);}

    @When("Send request get all service information on admin")
    public void sendRequestGetAllServiceInformationOnAdmin() {
        SerenityRest.when().get(BengcallAdminAPI.GET_ALL_SERVICE_TYPE_ADMIN);}

    @And("Get all service information on admin assert json validation")
    public void getAllServiceInformationOnAdminAssertJsonValidation() {
        File jsonFile = new File(BengcallAdminAPI
                .JSON_FILE+"/JsonSchemaValidation/Admin/Service" +
                "/GetAdminAllServiceInformationJsonSchemaValidation.json");
        SerenityRest
                .then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonFile));}

    @And("Get all service information on admin response contain {}")
    public void getAllServiceInformationOnAdminResponseContain(String message) {
        SerenityRest
                .then()
                .body(ResponseAdmin.MESSAGE, equalTo(message));}

    @Given("Set view all service information type on admin with special character on path {}")
    public void setViewAllServiceInformationTypeOnAdminWithSpecialCharacterOnPath(String character) {
        bengcallAdminAPI.getAllServiceTypeInformationOnAdminWithSpecCharacter(character);}

    @When("Send request get all service information on admin with special character id")
    public void sendRequestGetAllServiceInformationOnAdminWithSpecialCharacterId() {
        SerenityRest
                .when()
                .get(BengcallAdminAPI.GET_ALL_SERVICE_TYPE_ADMIN_SPEC_CHARACTER);}

    @And("Get all service information on admin invalid id assert json validation")
    public void getAllServiceInformationOnAdminInvalidIdAssertJsonValidation() {
        File jsonFile = new File(BengcallAdminAPI
                .JSON_FILE+"/JsonSchemaValidation/Admin/Service" +
                "/AdminAllServiceInvalidJsonSchemaValidation.json");
        SerenityRest
                .then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonFile));}

    @Given("Set Create new service on admin request body")
    public void setCreateNewServiceOnAdminRequestBody() {
        File jsonFiles = new File(BengcallAdminAPI
                .JSON_FILE+"/JsonRequestBody/Admin/Service" +
                "/PostAdminCreateNewService.json");
        bengcallAdminAPI.PostCreateServiceOnAdmin(jsonFiles);}

    @When("Send request create new service on admin")
    public void sendRequestCreateNewServiceOnAdmin() {
        SerenityRest
                .when()
                .post(BengcallAdminAPI.POST_CREATE_SERVICE_ADMIN);}

    @And("Post create new service type on admin assert json validation")
    public void postCreateNewServiceTypeOnAdminAssertJsonValidation() {
        File jsonFile = new File(BengcallAdminAPI
                .JSON_FILE+"/JsonSchemaValidation/Admin/Service" +
                "/PostAdminCreateServiceTypeJsonSchemaValidation.json");
        SerenityRest
                .then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonFile));}

    @And("Post create new service on admin response contain {}  {}  {}  {} and {}")
    public void postCreateNewServiceOnAdminResponseContain
            (int id ,String service_name,int price,int vehicle_id,String message) {
        SerenityRest
                .then()
                .body(ResponseAdmin.ID,equalTo(id))
                .body(ResponseAdmin.SERVICE_NAME,equalTo(service_name))
                .body(ResponseAdmin.Price, equalTo(price))
                .body(ResponseAdmin.VEHICLE_ID,equalTo(vehicle_id))
                .body(ResponseAdmin.MESSAGE, equalTo(message));}

    @Given("Set create new service on admin request body empty vehicle id value")
    public void setCreateNewServiceOnAdminRequestBodyEmptyVehicleIdValue() {
        File jsonFiles = new File(BengcallAdminAPI
                .JSON_FILE+"/JsonRequestBody/Admin/Service" +
                "/PostAdminCreateNewServiceEmptyVehicleId.json");
        bengcallAdminAPI.PostCreateServiceOnAdmin(jsonFiles);}

    @And("Post create new service on admin invalid data assert json validation")
    public void postCreateNewVehicleOnAdminInvalidDataAssertJsonValidation() {
        File jsonFile = new File(BengcallAdminAPI
                .JSON_FILE+"/JsonSchemaValidation/Admin/Service" +
                "/PostAdminCreateNewVehicleInvalidJsonSchemaValidation.json");
        SerenityRest
                .then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonFile));}

    @And("Post create new service on admin invalid response contain {}")
    public void postCreateNewServiceOnAdminInvalidResponseContainCannotBindInput(String message) {
        SerenityRest
                .then()
                .body(ResponseAdmin.MESSAGE, equalTo(message));}

    @Given("Set create new service on admin request body empty service name value")
    public void setCreateNewServiceOnAdminRequestBodyEmptyServiceNameValue() {
        File jsonFiles = new File(BengcallAdminAPI
                .JSON_FILE+"/JsonRequestBody/Admin/Service" +
                "/PostAdminCreateNewServiceEmptyServiceName.json");
        bengcallAdminAPI.PostCreateServiceOnAdmin(jsonFiles);}

    @Given("Set create new service on admin request body empty price value")
    public void setCreateNewServiceOnAdminRequestBodyEmptyPriceValue() {
        File jsonFiles = new File(BengcallAdminAPI
                .JSON_FILE+"/JsonRequestBody/Admin/Service" +
                "/PostAdminCreateNewServiceEmptyPrice.json");
        bengcallAdminAPI.PostCreateServiceOnAdmin(jsonFiles);}


    @Given("Set create new service on admin request body with all empty values")
    public void setCreateNewServiceOnAdminRequestBodyWithAllEmptyValues() {
        File jsonFiles = new File(BengcallAdminAPI
                .JSON_FILE+"/JsonRequestBody/Admin/Service" +
                "/PostAdminCreateNewServiceEmptyPrice.json");
        bengcallAdminAPI.PostCreateServiceOnAdmin(jsonFiles);}

    @Given("Set delete service type on admin with valid token and id {}")
    public void setDeleteServiceTypeOnAdminWithValidTokenAndId(int id) {
        bengcallAdminAPI.deleteServiceOnAdminWithTokenAndid(id);}

    @When("Send request delete service type on admin")
    public void sendRequestDeleteServiceTypeOnAdmin() {
        SerenityRest
                .when()
                .delete(BengcallAdminAPI.DELETE_SERVICE_ADMIN);}

    @And("Delete service on admin assert json validation")
    public void deleteServiceOnAdminAssertJsonValidation() {
        File jsonFile = new File(BengcallAdminAPI
                .JSON_FILE+"/JsonSchemaValidation/Admin/Service"+
                "/DeleteServiceAdminJsonSchemaValidation.json");
        SerenityRest
                .then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonFile));}

    @And("Delete service on admin response contain {}")
    public void deleteServiceOnAdminResponseContain(String message) {
        SerenityRest
                .then()
                .body(ResponseAdmin.MESSAGE, equalTo(message));}

    @Given("Set delete service type on admin token")
    public void setDeleteServiceTypeOnAdminToken() {
        bengcallAdminAPI.deleteServicedminWithoutId();}

    @When("Send request delete service type on admin without id")
    public void sendRequestDeleteServiceTypeOnAdminWithoutId() {
        SerenityRest
                .when()
                .delete(BengcallAdminAPI.DELETE_SERVICE_ADMIN_NO_ID);}

    @Given("Set delete service type on admin with special character {}")
    public void setDeleteServiceTypeOnAdminWithSpecialCharacter(String character) {
        bengcallAdminAPI.deleteServiceTypeAdminSpecCharacter(character);}

    @When("Send request delete service type special character")
    public void sendRequestDeleteServiceTypeSpecialCharacter() {
        SerenityRest
                .when()
                .delete(BengcallAdminAPI.DELETE_SERVICE_ADMIN_SPEC_CHARACTER);}

}
