package com.namansharma.ex_03_TestNG_AllureReport;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class APITesting_Lab06_TestCase {

    String pincode;

    @Test
    // valid pincode
    public void test_tc1_pincode_valid(){
        pincode = "110048";

        RestAssured.given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/" + pincode)
                .when()
                .then()
                .log().all().statusCode(200);
    }

    @Test
    // use of special characters @,#,$
    public void test_tc2_pincode_invalid(){
        pincode = "@";

        RestAssured.given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/" + pincode)
                .when()
                .then()
                .log().all().statusCode(404);
    }

    @Test
    // blank pincode
    public void test_tc3_pincode_invalid(){
        pincode = " ";

        RestAssured.given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/" + pincode)
                .when()
                .then()
                .log().all().statusCode(200);
    }
}
