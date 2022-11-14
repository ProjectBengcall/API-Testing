package Bengcall.Admin;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import java.io.File;
import static org.hamcrest.Matchers.equalTo;

public class LoginAdminStepdefs {

    @Steps
    BengcallAdminAPI bengcallAdminAPI;

    @Given("Admin login with valid request data")
    public void adminLoginWithValidRequestData (){
        File jsonFiles = new File(BengcallAdminAPI
                .JSON_FILE+"/JsonRequestBody/Admin/Login/PostAdminLoginCustomer.json");
        bengcallAdminAPI.postLoginAdmin (jsonFiles);}

    @When("Send request admin login")
    public void sendRequestAdminLogin(){
        SerenityRest
                .when()
                .post(BengcallAdminAPI.POST_LOGIN_ADMIN);}

    @And("Post admin login valid credentials assert json validation")
    public void postAdminLoginValidCredentialsAssertJsonValidation(){
        File jsonFile = new File(BengcallAdminAPI
                .JSON_FILE+"/JsonSchemaValidation/Admin/Login/PostAdminLoginJsonSchemaValidation.json");
        SerenityRest
                .then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonFile));}

    @Given("Admin login with invalid request data")
    public void adminLoginWithInvalidRequestData(){
        File jsonFiles = new File(BengcallAdminAPI
                .JSON_FILE+"/JsonRequestBody/Admin/Login/PostAdminLoginUnregistered.json");
        bengcallAdminAPI.postLoginAdmin (jsonFiles);}

    @And("Post admin login valid credentials response should contain fullname {} role {} and message {}")
    public void postAdminLoginValidCredentialsResponseShouldContainFullnameRoleAndMessage(String fullname, int role, String message) {
        SerenityRest
                .then()
                .body(ResponseAdmin.FULLNAME, equalTo(fullname))
                .body(ResponseAdmin.ROLE, equalTo(role))
                .body(ResponseAdmin.MESSAGE, equalTo(message));}

    @And("Post admin login invalid credentials assert json validation")
    public void postAdminLoginInvalidCredentialsAssertJsonValidation(){
        File jsonFile = new File(BengcallAdminAPI
                .JSON_FILE+ "/JsonSchemaValidation/Admin/Login/PostAdminLoginInvalidJsonSchemaValidation.json");
        SerenityRest
                .then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonFile));}

    @Given("Admin login with empty email value")
    public void adminLoginWithEmptyEmailValue(){
        File jsonFiles = new File(BengcallAdminAPI
                .JSON_FILE+"/JsonRequestBody/Admin/Login/PostAdminLoginEmptyEmail.json");
        bengcallAdminAPI.postLoginAdmin (jsonFiles);}

    @And("Post admin login with invalid value assert json validation")
    public void postAdminLoginWithInvalidValueAssertJsonValidation(){
        File jsonFile = new File(BengcallAdminAPI
                .JSON_FILE+"/JsonSchemaValidation/Admin/Login/PostAdminLoginInvalidJsonSchemaValidation.json");
        SerenityRest
                .then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonFile));}

    @Given("Admin login with empty password value")
    public void adminLoginWithEmptyPasswordValue(){
        File jsonFiles = new File(BengcallAdminAPI
                .JSON_FILE+"/JsonRequestBody/Admin/Login/PostAdminLoginEmptyPassword.json");
        bengcallAdminAPI.postLoginAdmin (jsonFiles);}

    @Given("Admin login with special character")
    public void adminLoginWithSpecialCharacter() {
        File jsonFiles = new File(BengcallAdminAPI
                .JSON_FILE+"/JsonRequestBody/Admin/Login/PostAdminLoginSpecialChar.json");
        bengcallAdminAPI.postLoginAdmin (jsonFiles);}

    @Given("Admin login with empty email and password value")
    public void adminLoginWithEmptyEmailAndPasswordValue() {
        File jsonFiles = new File(BengcallAdminAPI
                .JSON_FILE+"/JsonRequestBody/Admin/Login/PostAdminLoginEmptyEmailAndPassword.json");
        bengcallAdminAPI.postLoginAdmin (jsonFiles);}

    @And("Post admin login invalid response should contain {}")
    public void postAdminLoginInvalidResponseShouldContain(String message) {
        SerenityRest.then()
                .body(ResponseAdmin.MESSAGE, equalTo(message));}


}
