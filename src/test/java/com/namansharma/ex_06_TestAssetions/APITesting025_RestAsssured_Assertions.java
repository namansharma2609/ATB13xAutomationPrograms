package com.namansharma.ex_06_TestAssetions;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import javax.print.attribute.standard.RequestingUserName;

public class APITesting025_RestAsssured_Assertions {

    RequestSpecification r;
    Response response;
    ValidatableResponse vr;
    String token;
    Integer bookingID;

    @Test
    public void test_CreateBooking_POST(){

        String payload = "{\n" +
                "    \"firstname\" : \"Naman\",\n" +
                "    \"lastname\" : \"Sharma\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2025-08-02\",\n" +
                "        \"checkout\" : \"2025-08-03\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";

        r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking");
        r.contentType(ContentType.JSON);
        r.body(payload);
        r.log().all();

        response = r.when().log().all().post();


        vr = response.then().log().all();
        vr.statusCode(200);

        vr.body("bookingid", Matchers.notNullValue());
        vr.body("booking.firstname",Matchers.equalTo("Naman"));
        vr.body("booking.lastname",Matchers.equalTo("Sharma"));
        vr.body("booking.depositpaid",Matchers.equalTo(true));
        vr.body("booking.bookingdates.checkin",Matchers.notNullValue());
    }


}
