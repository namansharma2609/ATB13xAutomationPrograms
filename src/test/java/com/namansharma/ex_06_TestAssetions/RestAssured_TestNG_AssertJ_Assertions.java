package com.namansharma.ex_06_TestAssetions;

import static org.assertj.core.api.Assertions.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;


import static org.hamcrest.MatcherAssert.assertThat;

public class RestAssured_TestNG_AssertJ_Assertions {
    RequestSpecification r;
    Response response;
    ValidatableResponse validatableResponse;
    Integer bookingID;
    String token;

    @Test
    public void test_POST(){

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

        // Get Validate response to perform validation
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);


        validatableResponse.body("bookingid", Matchers.notNullValue());
        validatableResponse.body("booking.firstname",Matchers.equalTo("Naman"));
        validatableResponse.body("booking.lastname", Matchers.equalTo("Sharma"));
        validatableResponse.body("booking.depositpaid", Matchers.equalTo(true));

        // Extraction
        // Concept #1 - Normal( TestNG or Assertj) IS IMP
        bookingID = response.then().extract().path("bookingid");
        String firstname = response.then().extract().path("booking.firstname");
        String lastname = response.then().extract().path("booking.lastname");


        // Concept #2 - (Jsonpath class) Another mechanism to extract the Keys, value by JSON Path
        JsonPath jp = new JsonPath(response.asString());
        String bookingID1 = jp.getString("bookingid");

//        assertThat(jp.getInt("bookingid")).isEqualTo(5164);
//        assertThat(jp.getString("booking.firstname")).isEqualTo("pramod");
//        assertThat(jp.getString("booking.lastname")).isEqualTo("Dutta");
//        assertThat(jp.getInt("booking.totalprice")).isEqualTo(3000);
//        assertThat(jp.getBoolean("booking.depositpaid")).isTrue();


        // TestNG - Extract the details of the firstname, bookingId, lastname from Response.
        // TestNG Assertions - 75%
        // SoftAssert vs HardAssert (90%)
        // This means that if any assertion fails,
        // the remaining statements in that test method will not be executed.
        Assert.assertEquals(firstname,"Naman");
        Assert.assertEquals(lastname,"Sharma");
        Assert.assertNotNull(bookingID);

    }
}
