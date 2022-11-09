package Bengcall.Admin;

import io.cucumber.java.en.Then;
import net.serenitybdd.rest.SerenityRest;

public class StatusCode {
    @Then("Api should return response {int} OK")
    public void apiShouldReturnResponseOK(int ok) {
        SerenityRest.then()
                .statusCode(ok);
    }

    @Then("Api should return response {int} Accepted")
    public void apiShouldReturnResponseAccepted(int accepted) {
        SerenityRest.then()
                .statusCode(accepted);
    }

    @Then("Api should return response {int} Created")
    public void apiShouldReturnResponseCreated(int created) {
        SerenityRest.then()
                .statusCode(created);
    }

    @Then("Api should return response {int} Bad Request")
    public void apiShouldReturnResponseBadRequest(int badRequest) {
        SerenityRest.then()
                .statusCode(badRequest);
    }

    @Then("Api should return response {int} Not Found")
    public void apiShouldReturnResponseNotFound(int notFound) {
        SerenityRest.then()
                .statusCode(notFound);
    }
    @Then("Api should return response {int} Unauthorized")
    public void apiShouldReturnResponseUnauthorized(int unauthorized) {
        SerenityRest.then()
                .statusCode(unauthorized);
    }

    @Then("Api should return response {int} Method Not Allowed")
    public void apiShouldReturnResponseIntMethodNotAllowed(int Method_Not_Allowed) {
        SerenityRest.then()
                .statusCode(Method_Not_Allowed);
    }
}
