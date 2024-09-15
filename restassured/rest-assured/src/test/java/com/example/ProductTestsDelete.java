package com.example;


import org.junit.Test;
import static io.restassured.RestAssured.*;


public class ProductTestsDelete {

    @Test
    public void testDeleteUser() {
        // ID of the user to delete
        int userId = 3;
        System.out.println("Deleted user"+userId);
        // Send DELETE request
        given().
            header("Content-Type", "application/json").  // Set the content type as JSON
        when().
            delete("https://reqres.in/api/users/" + userId).  // Send DELETE request to delete user with specified ID
        then().
            assertThat().
            statusCode(204);  // Check that the status code is 204 (No Content)
    }
}
