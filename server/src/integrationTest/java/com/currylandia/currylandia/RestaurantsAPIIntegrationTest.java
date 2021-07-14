package com.currylandia.currylandia;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.is;

public class RestaurantsAPIIntegrationTest extends IntegrationTest {

    @BeforeEach
    public void setUp() {
        super.setUp();
    }

    @Test
    public void givenARestaurantAdditionWhenGettingRestaurantsThenItShouldBeRetrieved() {
        String address = "loyola 123";
        String description = "comida vegana";
        String name = "lo de ivan";
        Map<String, String> restaurant = Map.of("name", name,
                "description", description, "address", address);

        assertIsExpectedRestaurant(given().
                body(restaurant).
                contentType(ContentType.JSON).
                when().
                post("/agregar"), address, description, name);

        when().
                get("/restaurantes").
                then()
                .statusCode(200)
                .body("address", contains(address))
                .body("description", contains(description))
                .body("name", contains(name));
    }

    private void assertIsExpectedRestaurant(Response response, String address, String description, String name) {
        response.then().
                statusCode(200)
                .body("address", is(address))
                .body("description", is(description))
                .body("name", is(name));
    }

}
