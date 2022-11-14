package Bengcall.Admin;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import java.io.File;
import static net.serenitybdd.rest.SerenityRest.*;
import static org.hamcrest.Matchers.equalTo;
public class TransactionAdminStepdefs {

    @Steps
    BengcallAdminAPI bengcallAdminAPI;

    @Given("Get detail transaction data on admin with valid id {}")
    public void getDetailTransactionDataOnAdminWithValidId (int id) {
        bengcallAdminAPI.getDetailTransactionOnAdminWithIdAndToken(id);}

    @When("Send request get detail transaction on admin")
    public void sendRequestGetDetailTransactionOnAdmin() {
        when().get(BengcallAdminAPI.GET_DETAIL_TRANSACTION_ADMIN);}

    @And("Get detail transaction data on admin assert json validation")
    public void getDetailTransactionDataOnAdminWithValidIdAssertJsonValidation() {
        File jsonFile = new File(BengcallAdminAPI
                .JSON_FILE+"/JsonSchemaValidation/Admin/Transaction" +
                "/GetAdminDetailTransactionJsonSchemaValidation.json");
        SerenityRest
                .then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonFile));}

    @And("Get detail transaction data on admin response contain {}")
    public void getDetailTransactionDataOnAdminResponseContain (String message)
    {SerenityRest
                .then()
                .body(ResponseAdmin.MESSAGE, equalTo(message));}

    @Given("Get detail transaction data on admin with token")
    public void getDetailTransactionDataOnAdminWithToken() {
        bengcallAdminAPI.getDetailTransactionAdminInvalidPath();}

    @When("Send request get detail transaction on admin with invalid path")
    public void sendRequestGetDetailTransactionOnAdminWithInvalidPath() {
        SerenityRest
                .when()
                .get(BengcallAdminAPI.GET_DETAIL_TRANSACTION_ADMIN_INVALID_PATH);}

    @And("Get detail transaction data on admin invalid data assert json validation")
    public void getDetailTransactionDataOnAdminInvalidDataAssertJsonValidation() {
        File jsonFile = new File(BengcallAdminAPI
                .JSON_FILE+"/JsonSchemaValidation/Admin/Transaction" +
                "/GetAdminDetailTransactionInvalidJsonSchemaValidation.json");
        SerenityRest
                .then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonFile));}

    @And("Get detail transaction data on admin response contain message {}")
    public void getDetailTransactionDataOnAdminResponseContainMessageNotFound(String message) {
        SerenityRest
                .then()
                .body(ResponseAdmin.MESSAGE, equalTo(message));}

    @Given("Get detail transaction data on admin with special character and valid token {}")
    public void getDetailTransactionDataOnAdminWithSpecialCharacterAndValidToken(String character) {
        bengcallAdminAPI.getDetailTransactionAdminSpecialCharacter(character);}

    @When("Send request get detail transaction on admin with special character")
    public void sendRequestGetDetailTransactionOnAdminWithSpecialCharacter() {
        SerenityRest
                .when()
                .get(BengcallAdminAPI.GET_DETAIL_TRANSACTION_ADMIN_SPEC_CHAR);}


    @Given("Get detail transaction data on admin with invalid token {}")
    public void getDetailTransactionDataOnAdminWithInvalidToken(int id) {
        bengcallAdminAPI.getDetailTransactionWithInvalidToken(id);}

    @Given("Get all transaction on admin valid token")
    public void getAllTransactionOnAdminValidToken() {
        bengcallAdminAPI.adminValidToken();}

    @When("Send request get all transaction data on admin")
    public void sendRequestGetAllTransactionDataOnAdmin() {
        SerenityRest
                .when()
                .get(BengcallAdminAPI.GET_TRANSACTION_ADMIN_VALID_PATH);}

    @And("Get all transaction on admin with valid path assert json validation")
    public void getAllTransactionOnAdminWithValidPathAssertJsonValidation() {
        File jsonFile = new File(BengcallAdminAPI
                .JSON_FILE+"/JsonSchemaValidation/Admin/Transaction" +
                "/GetAdminAllTransactionJsonSchemaValidation.json");
       SerenityRest
                .then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonFile));}

    @And("Get all transaction on admin response contain {}")
    public void getAllTransactionOnAdminResponseContain( String message){
        SerenityRest
                .then()
                .body(ResponseAdmin.MESSAGE, equalTo(message));}

    @When("Send request get all transaction data on admin with invalid path")
    public void sendRequestGetAllTransactionDataOnAdminWithInvalidPath(){
        SerenityRest
                .when()
                .get(BengcallAdminAPI.GET_TRANSACTION_ADMIN_INVALID_PATH);}

    @And("Get all transaction on admin invalid assert json validation")
    public void getAllTransactionOnAdminInvalidAssertJsonValidation(){
        File jsonFile = new File(BengcallAdminAPI
                .JSON_FILE+"/JsonSchemaValidation/Admin/Transaction" +
                "/GetAdminDetailTransactionInvalidJsonSchemaValidation.json");
        SerenityRest
                .then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonFile));}

    @Given("Get all transaction on admin invalid token")
    public void getAllTransactionOnAdminInvalidToken() {
        bengcallAdminAPI.adminInvalidToken();}

    @Given("Set update transaction data on admin with valid token and form data {}")
    public void setUpdateTransactionDataOnAdminWithValidTokenAndFormData(int id) {
     bengcallAdminAPI.updateTransactionAdmin(id);
        SerenityRest
                .given()
                .log()
                .all()
                .header("Authorization",BengcallAdminAPI.VALID_ADMIN_TOKEN)
                .contentType("multipart/form-data")
                .multiPart("other","Ganti spion")
                .multiPart("additional","20000")
                .multiPart("status","3")
                .when().put("https://project-edu.online/admin/transaction/1")
                .then().statusCode(201);}

    @When("Send request update transaction data on admin")
    public void sendRequestUpdateTransactionDataOnAdmin() {
        SerenityRest
                .when()
                .put(BengcallAdminAPI.PUT_TRANSACTION_ADMIN);}

    @And("Update transaction data on admin assert json validation")
    public void updateTransactionDataOnAdminAssertJsonValidation() {
        File jsonFile = new File(BengcallAdminAPI
                .JSON_FILE+"/JsonSchemaValidation/Admin/Transaction" +
                "/PutAdminUpdateTransactionDataJsonSchemaValidation.json");
        SerenityRest
                .then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonFile));}

    @And("Update transaction data on admin response contain {} {} with message {}")
    public void updateTransactionDataOnAdminResponseContain(int invoice, int status, String message) {
        SerenityRest
                .then()
                .body(ResponseAdmin.INVOICE,equalTo(invoice))
                .body(ResponseAdmin.STATUS,equalTo(status))
                .body(ResponseAdmin.MESSAGE, equalTo(message));}

    @Given("Cancel transaction on admin with valid id {}")
    public void cancelTransactionOnAdminWithValidId(int id) {
        bengcallAdminAPI.cancelTransactionOnAdmin(id);}

    @When("Send request cancel transaction data on admin")
    public void sendRequestCancelTransactionDataOnAdmin() {
        SerenityRest
                .when()
                .delete(BengcallAdminAPI.DELETE_CANCEL_TRANSACTION_ADMIN);}

    @And("Cancel transaction on admin assert json validation")
    public void cancelTransactionOnAdminAssertJsonValidation() {
        File jsonFile = new File(BengcallAdminAPI
                .JSON_FILE+"/JsonSchemaValidation/Admin/Transaction" +
                "/DeleteCancelAdminTransactionJsonSchemaValidation.json");
        then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonFile));}

    @And("Cancel transaction on admin response contain {}")
    public void cancelTransactionOnAdminResponseContain(String message) {
        SerenityRest
                .then()
                .body(ResponseAdmin.MESSAGE, equalTo(message));}

    @Given("Cancel transaction on admin with special character id {}")
    public void cancelTransactionOnAdminWithSpecialCharacterId(String id) {
        bengcallAdminAPI.cancelTransactionAdminWithSpecCharacterId(id);}

    @Given("Cancel transaction on admin with invalid token and valid {}")
    public void cancelTransactionOnAdminWithInvalidToken(int id) {
        bengcallAdminAPI.cancelTransactionAdminInvalidToken(id);}


    @Given("Set update transaction data on admin with invalid id special character {}")
    public void setUpdateTransactionDataOnAdminWithInvalidIdSpecialCharacter(String character) {
        bengcallAdminAPI.updateTransactionInvalidIdSpecCharacter(character);
        SerenityRest
                .given()
                .log()
                .all()
                .header("Authorization",BengcallAdminAPI.VALID_ADMIN_TOKEN)
                .contentType("multipart/form-data")
                .multiPart("other","Ganti spion")
                .multiPart("additional","20000")
//                .multiPart("status","0")
                .when().put("https://project-edu.online/admin/transaction/HAHA")
                .then().statusCode(500);}

    @When("Send request update transaction data on admin with invalid id")
    public void sendRequestUpdateTransactionDataOnAdminWithInvalidId() {
        SerenityRest
                .when()
                .put(BengcallAdminAPI.PUT_TRANSACTION_ADMIN_INVALID);}

    @And("Update transaction invalid data on admin assert json validation")
    public void updateTransactionInvalidDataOnAdminAssertJsonValidation() {
        File jsonFile = new File(BengcallAdminAPI
                .JSON_FILE+"/JsonSchemaValidation/Admin/Transaction" +
                "/PostAdminUpdateTransactionInvalidJsonSchemaValidation.json");
        then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonFile));}

    @And("Update transaction invalid data on admin response contain {}")
    public void updateTransactionInvalidDataOnAdminResponseContain(String message) {
        SerenityRest
                .then()
                .body(ResponseAdmin.MESSAGE, equalTo(message));}


    @Given("Set update transaction data on admin with valid {} and invalid token")
    public void setUpdateTransactionDataOnAdminWithInvalidToken(int id) {
        bengcallAdminAPI.updateTransactionAdminInvalidToken(id);
        SerenityRest
                .given()
                .log()
                .all()
                .header("Authorization",BengcallAdminAPI.INVALID_ADMIN_TOKEN)
                .contentType("multipart/form-data")
                .multiPart("other","Ganti spion")
                .multiPart("additional","20000")
//                .multiPart("status","0")
                .when().put("https://project-edu.online/admin/transaction/11")
                .then().statusCode(401);}


    @Given("Set update transaction data on admin empty value data with id {}")
    public void setUpdateTransactionDataOnAdminEmptyValueDataWithId(int id) {
        bengcallAdminAPI.updateTransactionAdmin(id);
        SerenityRest
                .given()
                .log()
                .all()
                .header("Authorization",BengcallAdminAPI.VALID_ADMIN_TOKEN)
                .contentType("multipart/form-data")
                .multiPart("other","")
                .multiPart("additional","")
//                .multiPart("status","0")
                .when().put("https://project-edu.online/admin/transaction/11")
                .then().statusCode(201);}


}
