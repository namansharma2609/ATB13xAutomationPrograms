package com.namansharma.ex_01_RA_Basics;

import io.restassured.RestAssured;

import java.util.Scanner;

public class APITesting_Lab02_RA {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the pincode: ");

        String pincode = scanner.next();

        RestAssured.given()
                .baseUri("https://api.zippopotam.us")
                .basePath("\"/IN/\" + pincode")
                .when()
                .get()
                .then().log().all()
                .statusCode(200);
    }
}
