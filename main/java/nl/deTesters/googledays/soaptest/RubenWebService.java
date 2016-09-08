package nl.deTesters.googledays.soaptest;

import nl.deTesters.googledays.soaptest.restassured.WebServiceApplication;

public class RubenWebService extends WebServiceApplication {
    public static final String BASE_URL = "http://192.168.1.58:9000/api";

    public RubenWebService(){
        super(BASE_URL);
    }
}
