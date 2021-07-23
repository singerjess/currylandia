package com.currylandia.currylandia;

import com.currylandia.currylandia.controller.domain.UserDTO;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.contains;

public class LoginAPIIntegrationTest extends IntegrationTest {

    @BeforeEach
    public void setUp() {
        super.setUp();
    }

    @Test
    public void givenARegisteredUserWhenLoggingInThenTheUserTokenShouldBeRetrievend(){
        given().body(new UserDTO(null, "pepe", "jose")).
                contentType(ContentType.JSON).
                when().
                post("/register").
                then()
                .statusCode(200);
        given().body(new UserDTO(null, "pepe", "jose")).
                contentType(ContentType.JSON).
                when().
                post("/login").
                then()
                .statusCode(200);
    }
}
