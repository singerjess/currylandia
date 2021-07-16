package com.currylandia.currylandia;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import liquibase.exception.DatabaseException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.jdbc.JdbcTestUtils;

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

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @AfterEach
    public void tearDown() throws DatabaseException {
        JdbcTestUtils.deleteFromTables(jdbcTemplate, "restaurants");
    }

    @Test
    public void givenARestaurantAdditionWhenGettingRestaurantsThenItShouldBeRetrieved() {
        Long id = Long.valueOf(1);
        String address = "loyola 123";
        String description = "comida vegana";
        String name = "lo de ivan";
        Map<String, String> restaurant = Map.of("name", name,
                "description", description, "address", address);

        assertIsExpectedRestaurant(given().
                body(restaurant).
                contentType(ContentType.JSON).
                when().
                post("/add"), id, address, description, name);

        when().
                get("/restaurants").
                then()
                .statusCode(200)
                .body("address", contains(address))
                .body("description", contains(description))
                .body("name", contains(name));
    }

    @Test
    public void givenARestaurantAdditionWhenGettingRestaurantByIdThenItShouldBeRetrieved() {
        Long id = 2L; //TODO: arreglar esta vergaa
        String address = "loyola 123";
        String description = "comida vegana";
        String name = "lo de ivan";
        Map<String, String> restaurant = Map.of("name", name,
                "description", description, "address", address);

        assertIsExpectedRestaurant(given().
                body(restaurant).
                contentType(ContentType.JSON).
                when().
                post("/add"), id, address, description, name);

        assertIsExpectedRestaurant(when().get("/restaurants/1"), id, address, description, name);
    }

    private void assertIsExpectedRestaurant(Response response, Long id, String address, String description, String name) {
        response.then().
                statusCode(200)
                .body("address", is(address))
                .body("description", is(description))
                .body("name", is(name));
    }

}
