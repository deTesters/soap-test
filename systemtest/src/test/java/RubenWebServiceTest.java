import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import nl.detesters.googledays.soaptest.RubenWebService;


public class RubenWebServiceTest {

    RubenWebService rubenWebService = new RubenWebService();

    @Test
    public void postTest() {
        Response response = rubenWebService.sendNewCar();
        Assert.assertEquals("Wrong statuscode returned by webservice", 200, response.getStatusCode());
    }
}