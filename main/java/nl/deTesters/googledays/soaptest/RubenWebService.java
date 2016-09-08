package nl.deTesters.googledays.soaptest;

import io.restassured.response.Response;
import nl.deTesters.googledays.soaptest.restassured.WebServiceApplication;
import org.junit.Assert;

import java.util.UUID;

public class RubenWebService extends WebServiceApplication {
    public static final String BASE_URL = "http://192.168.1.58:9000/api";

    public RubenWebService() {
        super(BASE_URL);
    }

    public Response sendNewCar() {
        return post("car/", "new car: " + UUID.randomUUID().toString());
    }
}
