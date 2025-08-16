package com.namansharma.ex_04_RestAssured_HTTP_Methods.GET;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITesting009_GET_NonBDDStyle {
    RequestSpecification r;
    Response response;
    ValidatableResponse  vr;
    String pincode;

    @Test
    public void test_NBDD_GET(){
        pincode = "560048";

        //Part 1
        r = RestAssured.given();
        r.baseUri("https://api.zippopotam.us");
        r.basePath("/IN/"+pincode);

        //Part 2
        response = r.when().log().all().get();

        //Part3
        vr = response.then().log().all();
        vr.statusCode(200);
    }

    @Test
    public void test_NBDD_GET_Negative(){
        pincode = "@";

        //Part 1
        r = RestAssured.given();
        r.baseUri("https://api.zippopotam.us");
        r.basePath("/IN/"+pincode);

        //Part 2
        response = r.when().log().all().get();

        //Part3
        vr = response.then().log().all();
        vr.statusCode(404);
    }

}
