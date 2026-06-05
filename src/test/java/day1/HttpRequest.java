package day1;


import org.testng.annotations.Test;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBodyExtractionOptions;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class HttpRequest {

    @Test
    void createProduct() {

        String requestBody = "{\n" +
                "  \"title\": \"New Product\",\n" +
                "  \"price\": 29.99\n" +
                "}";
        
      


        Response response =
        		given()
            .header("Content-Type", "application/json")
            .body(requestBody)

        .when()
            .post("https://fakestoreapi.com/products");

            response.then()
        

          
            .statusCode(201)
            .body("title", equalTo("New Product"))
            .body("price", equalTo(29.99f))
           
               
            
            .log().all();
       
		JsonPath jsonPath = response.jsonPath();
        String title = jsonPath.getString("title");
        System.out.println(title);
    }
}