package Bengcall.user;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;


import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class UsersUserStepdefs {
    @Steps
    BengcallAPIUser bengcallAPIUser;
    @Given("Get a customer profile with valid token")
    public void getACustomerProfileWithValidToken() {
        bengcallAPIUser.getCustomerProfileValidToken();
    }

    @When("send request get customer profile valid path")
    public void sendRequestGetCustomerProfile() {
        SerenityRest.when()
                .get(BengcallAPIUser.CUSTOMER_PROFILE_VALID_PATH);
    }

    @When("send request put customer profile valid path")
    public void sendRequestPutCustomerProfile() {
        SerenityRest.when()
                .put(BengcallAPIUser.CUSTOMER_PROFILE_VALID_PATH);
    }

    @When("send request delete customer profile valid path")
    public void sendRequestDeleteCustomerProfile() {
        SerenityRest.when()
                .delete(BengcallAPIUser.CUSTOMER_PROFILE_VALID_PATH);
    }

    @And("Get customer profile assert json validation")
    public void getCustomerProfileAssertJsonValidation() {
        File jsonFile = new File(BengcallAPIUser.JSON_FILE+"/JsonSchemaValidation/Customer/User/GetUserProfileValidTokenJsonSchemaValidation.json");
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonFile));
    }

    @Given("Get a customer profile with expired token")
    public void getACustomerProfileWithExpiredToken() {
        bengcallAPIUser.getCustomerProfileExpiredToken();
    }

    @And("Get customer profile expired token assert json validation")
    public void getCustomerProfileExpiredTokenAssertJsonValidation() {
        File jsonFile = new File(BengcallAPIUser.JSON_FILE+"/JsonSchemaValidation/Customer/ErrorMessageJsonSchemaValidation.json");
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonFile));
    }

    @When("send request get customer profile invalid path")
    public void sendRequestGetCustomerProfileInvalidPath() {
        SerenityRest.when()
                .get(BengcallAPIUser.CUSTOMER_PROFILE_INVALID_PATH);
    }

    @When("send request put customer profile invalid path")
    public void sendRequestPutCustomerProfileInvalidPath() {
        SerenityRest.when()
                .put(BengcallAPIUser.CUSTOMER_PROFILE_INVALID_PATH);
    }

    @When("send request delete customer profile invalid path")
    public void sendRequestDeleteCustomerProfileInvalidPath() {
        SerenityRest.when()
                .delete(BengcallAPIUser.CUSTOMER_PROFILE_INVALID_PATH);
    }

    @And("Get customer profile invalid path assert json validation")
    public void getCustomerProfileInvalidPathAssertJsonValidation() {
        File jsonFile = new File(BengcallAPIUser.JSON_FILE+"/JsonSchemaValidation/Customer/ErrorMessageJsonSchemaValidation.json");
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonFile));
    }

    @Given("Update customer profile with valid token and input fullname {string}, email {string}, password {string} and image")
    public void updateUserProfileWithValidTokenAndValidCredential(String fullname, String email, String password) {
        SerenityRest.given().log().all()
                .header("Authorization",BengcallAPIUser.VALID_TOKEN)
                .formParams("fullname",fullname)
                .formParams("email",email)
                .formParams("password",password)
                .multiPart("images",new File("src/test/resources/JsonFile/JsonRequestBody/Customer/bc.png"));
    }

    @And("Put update customer profile valid token assert json validation")
    public void putUpdateCustomerProfileValidTokenAssertJsonValidation() {
        File jsonFile = new File(BengcallAPIUser.JSON_FILE+"/JsonSchemaValidation/Customer/User/PutUpdateUserProfileValidTokenJsonSchemaValidation.json");
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonFile));
    }

    @Given("Update a customer profile with expired token")
    public void updateACustomerProfileWithExpiredToken() {
        SerenityRest.given().log().all()
                .header("Authorization",BengcallAPIUser.EXPIRED_TOKEN)
                .formParams("fullname","Jeny")
                .formParams("email","jeny@gmail.com")
                .formParams("password","jenyjeny1")
                .multiPart("images",new File("src/test/resources/JsonFile/JsonRequestBody/Customer/bc.png"));
    }

    @Given("Update customer profile with password less than 8 characters")
    public void updateCustomerProfileWithPasswordLessThanCharacters() {
        SerenityRest.given().log().all()
                .header("Authorization",BengcallAPIUser.VALID_TOKEN)
                .formParams("fullname","Rono")
                .formParams("email","rono@gmail.com")
                .formParams("password","rono1")
                .multiPart("images",new File("src/test/resources/JsonFile/JsonRequestBody/Customer/bc.png"));
    }

    @Given("Deactivate customer account with valid token")
    public void deactivateCustomerAccountWithValidToken() {
        bengcallAPIUser.deleteCustomerAccountValidToken();
    }

    @Given("Deactivate customer account with invalid token")
    public void deactivateCustomerAccountWithInvalidToken() {
        bengcallAPIUser.deleteCustomerAccountExpiredToken();
    }

    @And("Delete customer accound assert json validation")
    public void deleteCustomerAccoundAssertJsonValidation() {
        File jsonFile = new File(BengcallAPIUser.JSON_FILE+"/JsonSchemaValidation/Customer/User/DeleteUserAccountValidTokenJsonSchemaValidation.json");
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonFile));
    }

    @Given("Deactivate customer account on customer account is already delete")
    public void deactivateCustomerAccountOnCustomerAccountIsAlreadyDelete() {
        bengcallAPIUser.deleteCustomerAccountIsNotExist();
    }

    @And("Response body should contain message {string}, fullname {string}, images {string}, email {string}")
    public void responseBodyShouldContainMessageIdFullnameImagesEmail(String message, String fullname, String images, String email) {
        SerenityRest.then()
                .body(BengcallAPIResponseUser.MESSAGE, equalTo(message))
                .body(BengcallAPIResponseUser.FULLNAME, equalTo(fullname))
                .body(BengcallAPIResponseUser.IMAGES, equalTo(images))
                .body(BengcallAPIResponseUser.EMAIL, equalTo(email));
    }

//    @And("Response body should contain message {string}, fullname {string}, images {string}, email {string}")
//    public void responseBodyShouldContainMessageFullnameImagesEmail(String message, String fullname, String images, String email) {
//        SerenityRest.then()
//                .body(BengcallAPIResponseUser.MESSAGE, equalTo(message))
//                .body(BengcallAPIResponseUser.FULLNAME, equalTo(fullname))
//                .body(BengcallAPIResponseUser.IMAGES, equalTo(images))
//                .body(BengcallAPIResponseUser.EMAIL, equalTo(email));
//    }

    @And("Response body delete account should contain message {string}")
    public void responseBodyShouldContainMessage(String message) {
        SerenityRest.then()
                .body(BengcallAPIResponseUser.MESSAGE, equalTo(message));
    }

//    @Given("Update customer profile with valid token and formdata")
//    public void updateCustomerProfileWithFullnameEmailPasswordAndImage() {
//        String file1_new1 = System.getProperty("user.dir") + \src\main\resources\ImageUpload\1.jpg
//
//        given().headers("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdXRob3JpemVkIjp0cnVlLCJleHBpcmVkIjoxNjY4MDAwNDkxLCJpZCI6MTMsInJvbGUiOjB9.ox7vUZEzeWBhwSshnBOp70L0F0KhO4x249V7NPBFTuM")
//                .contentType("multipart/form-data")
//                .multiPart("fullname","Jeny")
//                .multiPart("email","jeny@gmail.com")
//                .multiPart("password", "jenyjeny1")
//                .multiPart("images", new File("src/test/resources/JsonFile/JsonRequestBody/Customer/addasd.png"))
//                .when().put("https://project-edu.online/users")
//                .then().statusCode(201);
//    }

    @And("Response body should contain message {string}, id {int} fullname {string}, images {string}, email {string}")
    public void responseBodyShouldContainMessageIdFullnameImagesEmail(String message, int id, String fullname, String images, String email) {
        SerenityRest.then()
                .body(BengcallAPIResponseUser.MESSAGE, equalTo(message))
                .body(BengcallAPIResponseUser.ID,equalTo(id))
                .body(BengcallAPIResponseUser.FULLNAME, equalTo(fullname))
                .body(BengcallAPIResponseUser.IMAGES, equalTo(images))
                .body(BengcallAPIResponseUser.EMAIL, equalTo(email));
    }

    @And("Response body should contain message {string}, fullname {string}, email {string}")
    public void responseBodyShouldContainMessageFullnameEmail(String message, String fullname, String email) {
        SerenityRest.then()
                .body(BengcallAPIResponseUser.MESSAGE, equalTo(message))
                .body(BengcallAPIResponseUser.FULLNAME, equalTo(fullname))
                .body(BengcallAPIResponseUser.EMAIL, equalTo(email));

    }

    @Given("Update customer profile without input all mandatory field")
    public void updateCustomerProfileWithoutInputAllMandatoryField() {
        SerenityRest.given().log().all()
                .header("Authorization",BengcallAPIUser.VALID_TOKEN)
                .formParams("fullname","")
                .formParams("email","")
                .formParams("password","");
                //.multiPart("images",new File(""));
    }
}
