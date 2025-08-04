import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;

public class AuthIntegrationTest {

    @BeforeAll
    static void setUp() {
        RestAssured.baseURI = "http://localhost:4004";
    }

    @Test
    public void shouldReturnOKWithValidToken() {
//        arrange, act, assert for trigger the thing we are testing
//        arrange
        String loginPayload = """
                    {
                        "email": "testuser@test.com",
                        "password": "password123"
                    }
                """;
//        act

        Response response = given()
                .contentType("application/json")
                .body(loginPayload)
                .when()
                .post("/auth/login")
//                assert
                .then()
                .statusCode(200)
                .body("token", notNullValue())
                .extract()
                .response();

        System.out.println("Generated Token " + response.jsonPath().getString("token"));




    }

    @Test
    public void shouldReturnUnauthorizedOnInvalidLogin() {
//        arrange, act, assert for trigger the thing we are testing
//        arrange
        String loginPayload = """
                    {
                        "email": "test_user@test.com",
                        "password": "xpassword123"
                    }
                """;
//        act

        given()
                .contentType("application/json")
                .body(loginPayload)
                .when()
                .post("/auth/login")
//                assert
                .then()
                .statusCode(401);


    }
}
