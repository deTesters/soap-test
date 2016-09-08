import io.restassured.response.Response;
import nl.deTesters.googledays.soaptest.RubenWebService;
import nl.deTesters.googledays.soaptest.car.VolkswagenCar;
import org.junit.Assert;
import org.junit.Test;


public class RubenWebServiceTest {
    RubenWebService rubenWebService = new RubenWebService();

    @Test
    public void postVolkswagenTest() {
        VolkswagenCar car = new VolkswagenCar();

        Response response = rubenWebService.sendCar(car);
        Assert.assertEquals("Wrong statuscode returned by webservice", 200, response.getStatusCode());
    }


}
