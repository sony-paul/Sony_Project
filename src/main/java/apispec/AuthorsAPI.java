package apispec;

import base.ApiBase;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class AuthorsAPI extends ApiBase {

    protected static RequestSpecification requestSpec;
    protected static ResponseSpecification responseSpec;

    static {
           requestSpec = new RequestSpecBuilder()
                    .setContentType("application/json")
                    .addHeader("Accept", "application/json")
                    .build();

            responseSpec = new ResponseSpecBuilder()
                    .expectStatusCode(200)  // default expected code
                    .build();
        }

    public static Response get(String endpoint) {
        return io.restassured.RestAssured
                .given()
                .spec(requestSpec)
                .when()
                .get(endpoint)
                .then()
                .spec(responseSpec)
                .extract()
                .response();
    }
}


