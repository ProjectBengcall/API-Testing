package Bengcall.Admin;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import java.io.File;


public class BengcallAdminAPI {
    public static final String BASE_URL = "https://project-edu.online";
    public static final String DIR = System.getProperty("user.dir");
    public static final String JSON_FILE = DIR + "/src/test/resources/Jsonfile";
    public static final String POST_LOGIN_ADMIN = BASE_URL+"/login";
    public static final String GET_ALL_VEHICLE_ADMIN = BASE_URL+"/vehicle";
    public static final String GET_ALL_VEHICLE_ADMIN_INVALID_PATH = BASE_URL+"/vehicless";
    public static final String POST_CREATE_VEHICLE_ADMIN =BASE_URL +"/admin/vehicle";
    public static final String DELETE_VEHICLE_TYPE_ADMIN = BASE_URL+"/admin/vehicle/{id}";
    public static final String DELETE_VEHICLE_TYPE_ADMIN_NO_ID = BASE_URL+"/admin/vehicle";
    public static final String DELETE_VEHICLE_TYPE_ADMIN_SPEC_CHARACTER = BASE_URL+"/admin/vehicle/{character}";
    public static final String GET_ALL_SERVICE_TYPE_ADMIN = BASE_URL+"/service/{id}";
    public static final String GET_ALL_SERVICE_TYPE_ADMIN_SPEC_CHARACTER = BASE_URL + "/service/{character}";
    public static final String POST_CREATE_SERVICE_ADMIN = BASE_URL+"/admin/service";
    public static final String DELETE_SERVICE_ADMIN = BASE_URL+"/admin/service/{id}";
    public static final String DELETE_SERVICE_ADMIN_NO_ID = BASE_URL+"/admin/service";
    public static final String DELETE_SERVICE_ADMIN_SPEC_CHARACTER = BASE_URL+"/admin/service/{character}";
    public static final String GET_DETAIL_TRANSACTION_ADMIN = BASE_URL+"/transaction/{id}";
    public static final String GET_DETAIL_TRANSACTION_ADMIN_INVALID_PATH = BASE_URL+"/transactionss";
    public static final String GET_DETAIL_TRANSACTION_ADMIN_SPEC_CHAR = BASE_URL + "/transaction/{character}";
    public static final String GET_TRANSACTION_ADMIN_VALID_PATH = BASE_URL+ "/admin/transaction";
    public static final String GET_TRANSACTION_ADMIN_INVALID_PATH = BASE_URL+ "/admin/transaction/dhuaar";
    public static final String PUT_TRANSACTION_ADMIN  = BASE_URL+ "/admin/transaction/1";
    public static final String PUT_TRANSACTION_ADMIN_INVALID = BASE_URL+ "/admin/transaction/HAHA";
    public static final String DELETE_CANCEL_TRANSACTION_ADMIN = BASE_URL+ "/admin/transaction/{id}";
    public static final String GET_VEHICLESERVICE_ADMIN = BASE_URL + "/admin/vehicleservice";
    public static final String GET_VEHICLESERVICE_INVALID_PATH_ADMIN = BASE_URL + "/admin/vehicleservicess";
    public static final String VALID_ADMIN_TOKEN = "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdXRob3JpemVkIjp0cnVlLCJleHBpcmVkIjoxNj" +
            "Y4MDEyMjY0LCJpZCI6Miwicm9sZSI6MX0.CrYp4cqKypDxgZ_ewG6BlfBrZE3C3eL5rg7uyH_0_d4";
    public static final String INVALID_ADMIN_TOKEN = "Bearer JIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdXRob3JpemVkIjp0cnVlLCJleHBpcmVkIjoxNjY4MDEyMjY0LCJpZCI6Miwicm9sZSI6MX0.CrYp4cqKypDxgZ_ewG6BlfBrZE3C3eL5rg7uyH_0_d4";

    @Step("Post login admin")
    public void postLoginAdmin(File jsonFile) {
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(jsonFile);}

    @Step("Get all vehicles type admin valid token")
    public void getAllVehiclesTypeAdminValidToken(){
        SerenityRest.given()
                .header("Authorization",VALID_ADMIN_TOKEN);}

    @Step ("Get all vehicle type admin invalid token")
    public void getAllVehicleTypeAdminInvalidToken(){
        SerenityRest.given()
                .header("Authorization",INVALID_ADMIN_TOKEN);}

    @Step ("Post create new vehicle on admin with token")
    public void postCreateNewVehicleOnAdminWithToken (File jsonFile) {
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(jsonFile)
                .header("Authorization",VALID_ADMIN_TOKEN);}

    @Step ("Post create new vehicle with invalid token")
    public void postCreateNewVehicleWithInvalidToken (File jsonFile) {
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(jsonFile)
                .header("Authorization",INVALID_ADMIN_TOKEN);}

    @Step ("Delete vehicle type admin")
    public void deleteVehicleTypeAdmin (int id){
        SerenityRest.given()
                .header("Authorization",VALID_ADMIN_TOKEN)
                .pathParam("id", id);}

    @Step ("Delete vehicle admin without id")
    public void deleteVehicleAdminWithoutId (){
        SerenityRest.given()
                .header("Authorization",VALID_ADMIN_TOKEN);}

    @Step ("Delete vehicle type admin with spec character")
    public void deleteVehicleTypeAdminWithSpecCharacter (String character){
        SerenityRest.given()
                .header("Authorization",VALID_ADMIN_TOKEN)
                .pathParam("character", character);}


    @Step ("Get all service type on admin with id and token")
    public void getAllServiceTypeOnAdminWithIdAndtoken (int id) {
        SerenityRest.given()
                .header("Authorization",VALID_ADMIN_TOKEN)
                .pathParam("id", id);}

    @Step ("Get all service type information on admin with spec character")
    public void getAllServiceTypeInformationOnAdminWithSpecCharacter (String character){
        SerenityRest.given()
                .header("Authorization",VALID_ADMIN_TOKEN)
                .pathParam("character", character);}

    @Step ("Post create service on admin")
    public void PostCreateServiceOnAdmin (File jsonFile) {
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(jsonFile)
                .header("Authorization",VALID_ADMIN_TOKEN);}

    @Step ("Delete service on admin with token and id")
    public void deleteServiceOnAdminWithTokenAndid (int id){
        SerenityRest.given()
                .header("Authorization",VALID_ADMIN_TOKEN)
                .pathParam("id", id);}

    @Step ("Delete service admin without id")
    public void deleteServicedminWithoutId (){
        SerenityRest.given()
                .header("Authorization",VALID_ADMIN_TOKEN);}

    @Step ("Delete service type admin spec character")
    public void deleteServiceTypeAdminSpecCharacter (String character){
        SerenityRest.given()
                .header("Authorization",VALID_ADMIN_TOKEN)
                .pathParam("character", character);}

    @Step ("Get detail transaction on admin with id and token")
    public void getDetailTransactionOnAdminWithIdAndToken (int id) {
        SerenityRest.given()
                .header("Authorization",VALID_ADMIN_TOKEN)
                .pathParam("id", id);}

   @Step ("Get detail transaction admin invalid path")
    public void getDetailTransactionAdminInvalidPath (){
       SerenityRest.given()
               .header("Authorization",VALID_ADMIN_TOKEN);}

    @Step("Get detail transaction admin special character")
    public void getDetailTransactionAdminSpecialCharacter (String character){
        SerenityRest.given()
                .header("Authorization",VALID_ADMIN_TOKEN)
                .pathParam("character", character);}

    @Step ("Get detail transaction with invalid token")
    public void getDetailTransactionWithInvalidToken (int id) {
        SerenityRest.given()
                .header("Authorization",INVALID_ADMIN_TOKEN)
                .pathParam("id", id);}

    @Step ("Admin Valid Token")
    public void adminValidToken () {
        SerenityRest.given()
                .header("Authorization",VALID_ADMIN_TOKEN);}

    @Step ("Admin invalid token")
    public void adminInvalidToken (){
        SerenityRest.given()
                .header("Authorization",INVALID_ADMIN_TOKEN);}

    @Step ("Update transaction admin")
    public void updateTransactionAdmin (int id){
        SerenityRest.given().pathParam("id", id);}

    @Step ("Update transaction invalid id spec character")
    public void updateTransactionInvalidIdSpecCharacter (String character)
    {SerenityRest.given().pathParam("character", character);}

    @Step ("Update transaction admin invalid token")
    public void updateTransactionAdminInvalidToken (int id){
        SerenityRest.given()
                .pathParam("id", id);}

    @Step ("Cancel transaction on admin")
    public void cancelTransactionOnAdmin (int id) {
        SerenityRest.given()
                .header("Authorization",VALID_ADMIN_TOKEN)
                .pathParam("id", id);}

    @Step ("Cancel transaction admin with spec character id")
    public void cancelTransactionAdminWithSpecCharacterId ( String id) {
        SerenityRest.given()
                .header("Authorization",VALID_ADMIN_TOKEN)
                .pathParam("id", id);}

    @Step ("Cancel transaction admin invalid token")
    public void cancelTransactionAdminInvalidToken (int id){
        SerenityRest.given()
                .header("Authorization",INVALID_ADMIN_TOKEN)
                .pathParam("id", id);}








}