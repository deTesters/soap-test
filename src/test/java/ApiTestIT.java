import io.restassured.RestAssured;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpStatus;
import org.hamcrest.Matchers;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class ApiTestIT {

    private static String baseUrl = "http://192.168.1.58:9000/api/messagebox/";

    private String testData;

    private void loadTestDataFromFile(String filePath) {
        try {
            testData = IOUtils.toString(ApiTestIT.class.getResourceAsStream(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Before
    public void cleanup() {
        RestAssured.delete(baseUrl);
    }

    @Test
    public void doAPostWithBodyWithoutType() {
        loadTestDataFromFile("message.xml");
        RestAssured.given()
                .body(testData)
                .when()
                .post(baseUrl)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .and()
                .body(Matchers.equalTo("stored"));
    }

    @Test
    public void doAPostWithBodyWithTypeOne() {
        String type = "one";
        loadTestDataFromFile("message.xml");
        RestAssured.given()
                .body(testData)
                .when()
                .post(baseUrl + type)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .and()
                .body(Matchers.equalTo("stored"));
    }

    @Test
    public void doAPostWithBodyWithTypeTwo() {
        String type = "two";
        loadTestDataFromFile("message.xml");
        RestAssured.given()
                .body(testData)
                .when()
                .post(baseUrl + type)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .and()
                .body(Matchers.equalTo("stored"));
}
    @Test
    public void getPostedMessage(){
        doAPostWithBodyWithoutType();
        String result = RestAssured.get(baseUrl).path("messages.content").toString();
        String expected = "[[<test>test content</test>]]";
        assertEquals(expected,result);

    }
}