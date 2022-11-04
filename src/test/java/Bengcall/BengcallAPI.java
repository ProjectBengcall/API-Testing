package Bengcall;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.io.File;

public class BengcallAPI {
    public static final String BASE_URL = "https://project-edu.online";
    public static final String DIR = System.getProperty("user.dir");
    public static final String JSON_FILE = DIR+"/src/test/resources/Jsonfile";
    public static final String POST_REGISTER_USER_VALID_PATH = BASE_URL+"/register";
    public static final String POST_REGISTER_USER_INVALID_PATH = BASE_URL+"/registerr";
    public static final String POST_LOGIN_USER_VALID_PATH = BASE_URL+"/login";
    public static final String POST_LOGIN_USER_INVALID_PATH = BASE_URL+"/loginn";
    public static final String GET_CUSTOMER_PROFILE= BASE_URL+"/users";
    public static final String VALID_TOKEN ="Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdXRob3JpemVkIjp0cnVlLCJleHBpcmVkIjoxNjY3NjUyNjk3LCJpZCI6Nywicm9sZSI6MH0.OFMaSO6opAxl1qCwR8hQxCLGLouE809zsz-EJ14EXyE";

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
}
