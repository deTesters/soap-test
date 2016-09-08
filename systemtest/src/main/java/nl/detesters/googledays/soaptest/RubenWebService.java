package nl.detesters.googledays.soaptest;

import io.restassured.response.Response;
import nl.detesters.googledays.soaptest.restassured.WebServiceApplication;

import java.util.UUID;

public class RubenWebService extends WebServiceApplication {
    public static final String BASE_URL = "http://192.168.1.58:9000/api/messagebox/";

    public RubenWebService() {
        super(BASE_URL);
    }

    public Response sendNewCar() {
        return post("car/", "new car: " + UUID.randomUUID().toString());
    }
}