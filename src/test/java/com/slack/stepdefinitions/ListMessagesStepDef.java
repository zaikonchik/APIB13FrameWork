package com.slack.stepdefinitions;

import com.slack.utils.CommonUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;

public class ListMessagesStepDef {
    Response response;
    @When("When user list messages")
    public void whenUserListMessages() {
        RestAssured.basePath="api/conversations.history";
        response= RestAssured.given()
                .accept(ContentType.JSON)
                .header("Authorization", CommonUtils.readProp("token"))
                .queryParam("channel",CommonUtils.readProp("channel"))
                .when().get()
                .then().log().all().extract().response();



    }
    @Then("status code should be {int}")
    public void statusCodeShouldBe(Integer expectedStatusCode) {
       Integer actualStatusCode= response.getStatusCode();
        Assert.assertEquals(expectedStatusCode,actualStatusCode);

    }
    @Then("user's message is in the of messages")
    public void userSMessageIsInTheOfMessages() {


    }
}
