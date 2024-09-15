package com.example;


import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;


public class ProductTestsGet {

	@Test
    public void testGetAllProducts() {
        // Send GET request and store the response
        Response response = given().
        when().get("https://reqres.in/api/users").then().
            assertThat().
            statusCode(200).  // Verify status code is 200
            extract().response();  // Extract the response for further validation

        // Log the entire response for debugging purposes
        System.out.println("Response: " + response.asString());

        // Verify that the data array has users
        int totalUsers = response.path("data.size()");
        System.out.println("Number of users in data: " + totalUsers);

        // Ensure there is at least one user
        assert(totalUsers > 0);
        
        // You can also extract specific fields from the response
        String firstUserName = response.path("data[0].first_name");
        System.out.println("First user's name: " + firstUserName);

        // Validate that the first user's name is not null or empty
        assert(firstUserName != null && !firstUserName.isEmpty());
        
        String firstUserEmail = response.path("data[0].email");
        System.out.println("firstUserEmail: " + firstUserEmail);
        assert(firstUserEmail != null && !firstUserEmail.isEmpty());
        
        String secondUserLastName = response.path("data[1].last_name");
        System.out.println("secondUserLastName: " + secondUserLastName);
        assert(secondUserLastName != null && !secondUserLastName.isEmpty());
    }
}
