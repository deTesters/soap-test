package nl.deTesters.googledays.soaptest;

import io.restassured.response.Response;
import nl.deTesters.googledays.soaptest.car.Car;
import nl.deTesters.googledays.soaptest.car.VolkswagenCar;
import nl.deTesters.googledays.soaptest.restassured.WebServiceApplication;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.util.UUID;

public class RubenWebService extends WebServiceApplication {
    public static final String BASE_URL = "http://192.168.1.58:9000/api/messagebox/";

    public RubenWebService() {
        super(BASE_URL);
    }

    public Response sendCar(Car car) {
        String body = car.toString();
        return post("car/", body);
    }

    public Car getCar(String id) {
        // todo: make get call specific for id/type/whatever
        Response response = get("");

        StringReader stringReader = new StringReader(response.getBody().toString());
        Car car = null;
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Car.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            car = (Car) jaxbUnmarshaller.unmarshal(stringReader);
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        return car;
    }
}
