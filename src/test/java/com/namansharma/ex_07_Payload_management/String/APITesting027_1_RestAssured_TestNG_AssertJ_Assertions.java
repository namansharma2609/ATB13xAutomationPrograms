package com.namansharma.ex_07_Payload_management.String;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITesting027_1_RestAssured_TestNG_AssertJ_Assertions {

    RequestSpecification r;
    Response response;
    ValidatableResponse validatableResponse;

    @Test
    public void test_POST(){
        String name ="Naman";

        String payload = "{\n" +
                "    \"firstname\" : \""+name+"\",\n" +
                "    \"lastname\" : \"Sharma\",\n" +
                "    \"totalprice\" : 123,\n" +
                "    \"depositpaid\" : false,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2024-01-01\",\n" +
                "        \"checkout\" : \"2024-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Lunch\"\n" +
                "}";
    }
}
