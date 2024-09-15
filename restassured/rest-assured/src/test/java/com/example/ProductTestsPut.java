package com.example;


import io.restassured.response.Response;
import org.junit.Test;
import static io.restassured.RestAssured.*;


import java.util.HashMap;
import java.util.Map;

public class ProductTestsPut {

    @Test
    public void testUpdateUser() {
        // Prepare the request body as a Map (you can also use a JSON string)
        Map<String, Object> requestBody = new HashMap<String, Object>();
        requestBody.put("name", "JJ Doe");
        requestBody.put("job", "Software Tester");

        // Send PUT request and store the response
        Response response = given().
            header("Content-Type", "application/json").
            body(requestBody).
        when().
            put("https://reqres.in/api/users/2").  // Update user with ID 2
        then().
            assertThat().
            statusCode(200).  // Ensure the status code is 200
            extract().response();  // Extract the response for further validation

        // Log the entire response for debugging
        System.out.println("Response: " + response.asString());

        // Verify that the response contains the updated data
        String updatedName = response.path("name");
        String updatedJob = response.path("job");
        System.out.println("Updated Name: " + updatedName);
        System.out.println("Updated Job: " + updatedJob);

        // Validate that the name and job are updated correctly
        assert(updatedName.equals("JJ Doe"));
        assert(updatedJob.equals("Software Tester"));
    }
}
