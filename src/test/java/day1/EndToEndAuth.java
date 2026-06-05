package day1;

import org.testng.annotations.Test;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class EndToEndAuth {

    @Test
    void authFlow() {
    	System.out.println("CI/CD implementd");
    	System.out.println("CI/CD implementd new");
        // Login Request Body
        String loginBody = "{\n" +
                "  \"username\": \"mor_2314\",\n" +
                "  \"password\": \"83r5^_\"\n" +
                "}";

        // Generate Token
        Response loginResponse =

                given()
                    .header("Content-Type", "application/json")
                    .body(loginBody)

                .when()
                    .post("https://fakestoreapi.com/auth/login");

        // Extract Token
        String token = loginResponse.jsonPath().getString("token");

        System.out.println("Generated Token: " + token);

        // Use Token
        given()
            .header("Authorization", "Bearer " + token)

        .when()
            .get("https://fakestoreapi.com/products")

        .then()
            .statusCode(200)
            .log().all();
    }
}