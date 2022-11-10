package Bengcall.user;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.io.File;

public class BengcallAPIUser {
    public static final String BASE_URL = "https://project-edu.online";
    public static final String DIR = System.getProperty("user.dir");
    public static final String JSON_FILE = DIR+"/src/test/resources/Jsonfile";
    public static final String POST_REGISTER_USER_VALID_PATH = BASE_URL+"/register";
    public static final String POST_REGISTER_USER_INVALID_PATH = BASE_URL+"/registerr";
    public static final String POST_LOGIN_USER_VALID_PATH = BASE_URL+"/login";
    public static final String POST_LOGIN_USER_INVALID_PATH = BASE_URL+"/loginn";
    public static final String CUSTOMER_PROFILE_VALID_PATH = BASE_URL+"/users";
    public static final String CUSTOMER_PROFILE_INVALID_PATH = BASE_URL+"/userss";
    public static final String CUSTOMER_VEHICLES_VALID_PATH = BASE_URL+"/vehicle";
    public static final String CUSTOMER_VEHICLES_INVALID_PATH = BASE_URL+"/vehicless";
    public static final String CUSTOMER_SERVICES_VALID_PATH = BASE_URL+"/service/{id}";
    public static final String CUSTOMER_SERVICES_INVALID_PATH = BASE_URL+"/services/{id}";
    public static final String CUSTOMER_ALL_SERVICE_HISTORY_VALID_PATH = BASE_URL+"/history";
    public static final String CUSTOMER_ALL_SERVICE_HISTORY_INVALID_PATH = BASE_URL+"/historys";
    public static final String CUSTOMER_COMMENT_VALID_PATH = BASE_URL+"/comment/{id}";
    public static final String CUSTOMER_COMMENT_INVALID_PATH = BASE_URL+"/comments/{id}";
    public static final String POST_TRANSACTION_USER_VALID_PATH = BASE_URL+"/transaction";
    public static final String POST_TRANSACTION_USER_INVALID_PATH = BASE_URL+"/transactions";
    public static final String DETAIL_TRANSACTION_USER_VALID_PATH = BASE_URL+"/transaction/me";
    public static final String DETAIL_TRANSACTION_USER_INVALID_PATH = BASE_URL+"/transaction/meee";
    public static final String VEHICLE_SERVICE_VALID_PATH = BASE_URL+"/vehicleservice";
    public static final String VEHICLE_SERVICE_INVALID_PATH = BASE_URL+"/vehicleservices";
    public static final String VALID_TOKEN ="Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdXRob3JpemVkIjp0cnVlLCJleHBpcmVkIjoxNjY3ODAwMzUzLCJpZCI6MTMsInJvbGUiOjB9.OrhV5_xGREdSiNoEz244du2sOJjMh34Gx7xtuysyRb0";
    public static final String EXPIRED_TOKEN ="Bearer eyeeeerwJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdXRob3JpemVkIjp0cnVlLCJleHBpcmVkIjoxNjY3NzkyNzM2LCJpZCI6Miwicm9sZSI6MX0.bIdQ95WTl2ArvKn7RSptNgBBPZ08W2iPPJbxjefSRVE";
    public static final String TOKEN_ON_CUSTOMER_ACCOUNT_NOT_EXIST ="Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdXRob3JpemVkIjp0cnVlLCJleHBpcmVkIjoxNjY3NzEyNjYxLCJpZCI6Nywicm9sZSI6MH0.BsCCA7kROz9yldDro-l-kjNP7RoF13l1-fyRbDWdeSA";

    @Step("Post register customer")
    public void postRegisterCustomer(File jsonFile){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(jsonFile);
    }

    @Step("Post login customer")
    public void postLoginCustomer(File jsonFile){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(jsonFile);
    }

    @Step("Get customer profile with valid token")
    public void getCustomerProfileValidToken(){
        SerenityRest.given()
                .header("Authorization",VALID_TOKEN);
    }

    @Step("Get customer profile with expired token")
    public void getCustomerProfileExpiredToken(){
        SerenityRest.given()
                .header("Authorization",EXPIRED_TOKEN);
    }

    @Step("Put update customer profile valid token")
    public void putUpdateCustomerProfileValidToken(File jsonFile){
        SerenityRest.given()
                .header("Authorization",VALID_TOKEN)
                .contentType(ContentType.JSON)
                .body(jsonFile);
    }

    @Step("Put update customer profile expired token")
    public void putUpdateCustomerProfileExpiredToken(File jsonFile){
        SerenityRest.given()
                .header("Authorization",EXPIRED_TOKEN)
                .contentType(ContentType.JSON)
                .body(jsonFile);
    }

    @Step("Deactivate customer account with valid token")
    public void deleteCustomerAccountValidToken(){
        SerenityRest.given()
                .header("Authorization",VALID_TOKEN);
    }

    @Step("Deactivate customer account with expired token")
    public void deleteCustomerAccountExpiredToken(){
        SerenityRest.given()
                .header("Authorization",EXPIRED_TOKEN);
    }

    @Step("Deactivate customer account on customer account is already delete")
    public void deleteCustomerAccountIsNotExist(){
        SerenityRest.given()
                .header("Authorization",TOKEN_ON_CUSTOMER_ACCOUNT_NOT_EXIST);
    }

    @Step("Get vehicles with valid token")
    public void getVehiclesValidToken(){
        SerenityRest.given()
                .header("Authorization",VALID_TOKEN);
    }

    @Step("Get vehicles with expired token")
    public void getVehiclesExpiredToken(){
        SerenityRest.given()
                .header("Authorization",EXPIRED_TOKEN);
    }

    @Step("Get services with valid token and valid id")
    public void getServicesValidToken(int id){
        SerenityRest.given()
                .header("Authorization",VALID_TOKEN)
                .pathParam("id", id);
    }

    @Step("Get services with valid token and invalid id")
    public void getServicesValidTokenAndInvalidId(String id){
        SerenityRest.given()
                .header("Authorization",VALID_TOKEN)
                .pathParam("id", id);
    }

    @Step("Get services with expired token and invalid id")
    public void getServicesExpiredTokenAndInvalidId(int id){
        SerenityRest.given()
                .header("Authorization",EXPIRED_TOKEN)
                .pathParam("id", id);
    }
    @Step("Get all service history with valid token")
    public void getAllServiceHistoryValidToken(){
        SerenityRest.given()
                .header("Authorization",VALID_TOKEN);
    }

    @Step("Get all service history with expired token")
    public void getAllServiceHistoryExpiredToken(){
        SerenityRest.given()
                .header("Authorization",EXPIRED_TOKEN);
    }

    @Step("Post Create new transaction with valid token")
    public void postCreateNewTransactionWithValidToken(File jsonFile){
        SerenityRest.given()
                .header("Authorization",VALID_TOKEN)
                .contentType(ContentType.JSON)
                .body(jsonFile);
    }
    @Step("Post Create new transaction with expired token")
    public void postCreateNewTransactionWithExpiredToken(File jsonFile){
        SerenityRest.given()
                .header("Authorization",EXPIRED_TOKEN)
                .contentType(ContentType.JSON)
                .body(jsonFile);
    }

    @Step("Get detail transaction with valid token")
    public void getDetailTransactionValidToken() {
        SerenityRest.given()
                .header("Authorization", VALID_TOKEN);
    }

    @Step("Get detail transaction with expired token")
    public void getDetailTransactionExpiredToken() {
        SerenityRest.given()
                .header("Authorization", EXPIRED_TOKEN);
    }
    @Step("Get vehicle service with valid token")
    public void getVehicleServiceValidToken(){
        SerenityRest.given()
                .header("Authorization",VALID_TOKEN);
    }

    @Step("Get vehicle service with expired token")
    public void getVehicleServiceExpiredToken(){
        SerenityRest.given()
                .header("Authorization",EXPIRED_TOKEN);
    }
}
