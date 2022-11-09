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






}