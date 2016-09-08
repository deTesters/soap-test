import io.restassured.response.Response;
import nl.deTesters.googledays.soaptest.RubenWebService;
import org.junit.Assert;
import org.junit.Test;


public class RubenWebServiceTest {
    RubenWebService rubenWebService = new RubenWebService();

    @Test
    public void postTest() {
        Response response = rubenWebService.sendNewCar();
        Assert.assertEquals(200, response.getStatusCode());
    }

}
