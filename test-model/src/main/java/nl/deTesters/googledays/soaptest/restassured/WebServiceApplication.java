package nl.deTesters.googledays.soaptest.restassured;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

/**
 * REST-assured class
 */
public abstract class WebServiceApplication {
    private final String baseUrl;

    public WebServiceApplication(String baseUrl){
        this.baseUrl = baseUrl;
    }
    
    /**
     * returns the response of a post
     * @param path url path that is appended to the baseUrl
     * @param body body that is send with the post
     * @param params params that are inserted in the header of the request
     * @return the response
     */
    protected Response post(String path, String body, Map<String, String> params){
        return RestAssured.
                given().body(body).params(params).
                when().post(baseUrl + path).
                thenReturn();
    }

    /**
     * returns the response of a post
     * @param path url path that is appended to the baseUrl
     * @param body body that is send with the post
     * @return the response
     */
    protected Response post(String path, String body){
        return post(path, body, new HashMap<String, String>());
    }

    /**
     * returns the response of a get
     * @param path url path that is appended to the baseUrl
     * @param params params that are inserted in the header of the request
     * @return the response
     */
    protected Response get(String path, Map<String, String> params){
        return RestAssured.
                given().params(params).
                when().get(baseUrl + path).
                thenReturn();
    }

    /**
     * returns the response of a get without parameters
     * @param path url path that is appended to the baseUrl
     * @return the response
     */
    protected Response get(String path){
        return get(path, new HashMap<String, String>());
    }
}