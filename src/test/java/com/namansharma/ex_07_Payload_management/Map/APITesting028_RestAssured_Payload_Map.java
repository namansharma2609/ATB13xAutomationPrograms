package com.namansharma.ex_07_Payload_management.Map;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import java.util.LinkedHashMap;
import java.util.Map;

public class APITesting028_RestAssured_Payload_Map {
    RequestSpecification r;
    Response response;
    ValidatableResponse validatableResponse;
    Integer bookingID;


    @Test
    public void test_POST(){

        //Using Map, we are creating JSON payload

        Map<String,Object> jsonBodyUsingMap = new LinkedHashMap<>();
        jsonBodyUsingMap.put("firstname","Naman");
        jsonBodyUsingMap.put("lastname","Sharma");
        jsonBodyUsingMap.put("depositpaid",true);
        jsonBodyUsingMap.put("totalprice",2000);

        Map <String,Object> bookingDatesMap = new LinkedHashMap<>();
        bookingDatesMap.put("checkin","2025-08-16");
        bookingDatesMap.put("checkout","2025-08-22");

        jsonBodyUsingMap.put("bookingdates",bookingDatesMap);
        jsonBodyUsingMap.put("additionalNeeds","Breakfast");

        System.out.println(jsonBodyUsingMap);


        r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking");
        r.contentType(ContentType.JSON);
        r.body(jsonBodyUsingMap).log().all();


        response = r.when().log().all().post();

        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);


        validatableResponse.body("bookingid", Matchers.notNullValue());
        validatableResponse.body("booking.firstname", Matchers.equalTo("Naman"));
        validatableResponse.body("booking.lastname", Matchers.equalTo("Sharma"));
        validatableResponse.body("booking.depositpaid", Matchers.equalTo(true));
    }
}
