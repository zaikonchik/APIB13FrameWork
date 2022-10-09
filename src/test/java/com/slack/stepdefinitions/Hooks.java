package com.slack.stepdefinitions;

import io.cucumber.java.Before;
import io.restassured.RestAssured;

public class Hooks {
    @Before
    public void setUp(){
        RestAssured.baseURI="https://slack.com";
        RestAssured.basePath="/api/chat.postMessage";

    }
}
