package Bengcall.user;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class TransactionStepdefs {
    @Steps
    BengcallAPIUser bengcallAPIUser;
    @Given("Post create new transaction with input all field mandatory")
    public void posrCreateNewTransactionWithInputAllFieldMandatory() {
        File jsonFiles = new File(BengcallAPIUser.JSON_FILE+"/JsonRequestBody/Customer/Transaction/POSTCreateTransactionInputAllFiledMandatory.json");
        bengcallAPIUser.postCreateNewTransactionWithValidToken(jsonFiles);
    }

    @When("send request post create transaction with valid path")
    public void sendRequestPostCreateTransactionWithValidPath() {
        SerenityRest.when()
                .post(BengcallAPIUser.POST_TRANSACTION_USER_VALID_PATH);
    }

    @And("Post create new transaction assert json validation")
    public void postCreateNewTransactionAssertJsonValidation() {
        File jsonFile = new File(BengcallAPIUser.JSON_FILE+"/JsonSchemaValidation/Customer/Transaction/PostCreateNewTransactionInputAllFieldMandatoryJsonSchemaValidation.json");
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonFile));
    }

    @Given("Post create new transaction with input all field mandatory and expired token")
    public void postCreateNewTransactionWithInputAllFieldMandatoryAndExpiredToken() {
        File jsonFiles = new File(BengcallAPIUser.JSON_FILE+"/JsonRequestBody/Customer/Transaction/POSTCreateTransactionInputAllFiledMandatory.json");
        bengcallAPIUser.postCreateNewTransactionWithExpiredToken(jsonFiles);
    }

    @Given("Post create new transaction without input all field mandatory")
    public void postCreateNewTransactionWithoutInputAllFieldMandatory() {
        File jsonFiles = new File(BengcallAPIUser.JSON_FILE+"/JsonRequestBody/Customer/Transaction/POSTCreateTransactionWithoutInputAllFiledMandatory.json");
        bengcallAPIUser.postCreateNewTransactionWithValidToken(jsonFiles);
    }

    @Given("Post create new transaction with one field mandatory is empty")
    public void postCreateNewTransactionWithOneFieldMandatoryIsEmpty() {
        File jsonFiles = new File(BengcallAPIUser.JSON_FILE+"/JsonRequestBody/Customer/Transaction/POSTCreateTransactionOneFieldMandatoryIsEmpty.json");
        bengcallAPIUser.postCreateNewTransactionWithValidToken(jsonFiles);
    }

    @Given("Post create new transaction with two field mandatory is empty")
    public void postCreateNewTransactionWithTwoFieldMandatoryIsEmpty() {
        File jsonFiles = new File(BengcallAPIUser.JSON_FILE+"/JsonRequestBody/Customer/Transaction/POSTCreateTransactionTwoFieldMandatoryIsEmpty.json");
        bengcallAPIUser.postCreateNewTransactionWithValidToken(jsonFiles);
    }

    @Given("Post create new transaction with three field mandatory is empty")
    public void postCreateNewTransactionWithThreeFieldMandatoryIsEmpty() {
        File jsonFiles = new File(BengcallAPIUser.JSON_FILE+"/JsonRequestBody/Customer/Transaction/POSTCreateTransactionThreeFieldMandatoryIsEmpty.json");
        bengcallAPIUser.postCreateNewTransactionWithValidToken(jsonFiles);
    }

    @Given("Get ongoing user transaction with valid token")
    public void getUserSTransactionWithValidToken() {
        bengcallAPIUser.getDetailTransactionValidToken();
    }

    @When("send request get ongoing user transaction valid path")
    public void sendRequestGetDetailTransactionValidPath() {
        SerenityRest.when()
                .get(BengcallAPIUser.DETAIL_TRANSACTION_USER_VALID_PATH);
    }

    @And("Get ongoing user transaction assert json validation")
    public void getOngoingTransactionTransactionAssertJsonValidation() {
        File jsonFile = new File(BengcallAPIUser.JSON_FILE+"/JsonSchemaValidation/Customer/Transaction/GetDetailTransactionJsonSchemaValidation.json");
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonFile));
    }

    @When("send request get ongoing user transaction invalid path")
    public void sendRequestGetDetailTransactionInvalidPath() {
        SerenityRest.when()
                .get(BengcallAPIUser.DETAIL_TRANSACTION_USER_INVALID_PATH);
    }

    @Given("Get ongoing user transaction with expired token")
    public void getUserSTransactionWithExpiredToken() {
        bengcallAPIUser.getDetailTransactionExpiredToken();
    }

    @And("Response body success should contain message {string}")
    public void responseBodyValidCredentialsShouldContainMessage(String message) {
        SerenityRest.then()
                .body(BengcallAPIResponseUser.MESSAGE,equalTo(message));
    }

    @Given("Get detail user's transaction with id {int} and valid token")
    public void getDetailUserSTransactionWithValidId(int id) {
        bengcallAPIUser.getOngoingUserTransactionValidIdAndValidToken(id);
    }

    @When("send requeat get detail transaction with valid path")
    public void sendRequeatGetDetailTransactionWithValidPath() {
        SerenityRest.when()
                .get(BengcallAPIUser.ONGOING_USER_TRANSACTION_USER_VALID_PATH);
    }

    @And("Get detail transaction assert json validation")
    public void getDetailTransactionAssertJsonValidation() {
        File jsonFile = new File(BengcallAPIUser.JSON_FILE+"/JsonSchemaValidation/Customer/Transaction/GetOngoingUserTransactionJsonSchemaValidation.json");
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonFile));
    }

    @Given("Get detail user's transaction with invalid id {string} and valid token")
    public void getDetailUserSTransactionWithInvalidId(String id) {
        bengcallAPIUser.getOngoingUserTransactionInvalididAndValidToken(id);
    }

    @When("send requeat get detail transaction with invalid path")
    public void sendRequeatGetDetailTransactionWithInvalidPath() {
        SerenityRest.when()
                .get(BengcallAPIUser.ONGOING_USER_TRANSACTION_USER_INVALID_PATH);
    }

    @Given("Get detail user's transaction with id {int} and expired token")
    public void getDetailUserSTransactionWithIdAndExpiredToken(int id) {
        bengcallAPIUser.getOngoingUserTransactionValidIdAndExpiredToken(id);
    }
}
