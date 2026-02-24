package StepDefinitions;

import apispec.AuthorsAPI;
import base.ApiBase;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class AuthorAPISteps extends AuthorsAPI {
    private Response response;


    @Given("the API endpoint for authors is available")
    public void theAPIEndpointForAuthorsIsAvailable() {
        System.out.println("API Base URL: " + ApiBase.prop.getProperty("baseURL"));
    }

    @When("I send a GET request to the authors endpoint")
    public void iSendAGETRequestToTheAuthorsEndpoint() {
        response=AuthorsAPI.get(ApiBase.prop.getProperty("baseURL"));
    }

    @Then("the response status code should be {int}")
    public void theResponseStatusCodeShouldBe(int code) {
        Assert.assertEquals(response.statusCode(), code);
    }

    @And("the response should contain a valid personal name {string} and alternate name {string}")
    public void theResponseShouldContainAValidPersonalNameAndAlternateName(String expectedPersonalName, String expectedAlternateName) {
        String actualPersonalName=response.jsonPath().getString("personal_name");
        Assert.assertEquals(actualPersonalName,expectedPersonalName);

        List<String> actualAlternateName=response.jsonPath().getList("alternate_names");
        Assert.assertTrue( actualAlternateName.contains(expectedAlternateName));
    }
}
