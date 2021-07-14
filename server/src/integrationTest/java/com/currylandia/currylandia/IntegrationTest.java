package com.currylandia.currylandia;


import com.currylandia.currylandia.repository.RestaurantRepository;
import io.restassured.RestAssured;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.TestPropertySourceUtils;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;


@ActiveProfiles("integration-test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ContextConfiguration(initializers = IntegrationTest.DockerPostgresDataSourceInitializer.class)
@Testcontainers
public abstract class IntegrationTest {

    @LocalServerPort
    int applicationPort;

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Container
    public static PostgreSQLContainer<?> postgresDBContainer = new PostgreSQLContainer<>("postgres:13.2");

    @BeforeClass
    public static void setUpPostgres() {
        postgresDBContainer.start();
    }

    @AfterClass
    public static void tearDownPostgres() {
        postgresDBContainer.stop();
    }

    @BeforeEach
    public void setUp() {
        RestAssured.port = applicationPort;
    }

    public static PostgreSQLContainer<?> getPostgresDBContainer() {
        return postgresDBContainer;
    }

    public static class DockerPostgresDataSourceInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

        @Override
        public void initialize(ConfigurableApplicationContext applicationContext) {

            TestPropertySourceUtils.addInlinedPropertiesToEnvironment(
                    applicationContext,
                    "spring.datasource.url=" + postgresDBContainer.getJdbcUrl(),
                    "spring.datasource.username=" + postgresDBContainer.getUsername(),
                    "spring.datasource.password=" + postgresDBContainer.getPassword()
            );
        }
    }
}
