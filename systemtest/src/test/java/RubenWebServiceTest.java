import io.restassured.response.Response;
import nl.deTesters.googledays.soaptest.RubenWebService;
import nl.deTesters.googledays.soaptest.car.VolkswagenPassatCar;
import nl.deTesters.googledays.soaptest.owner.Owner;
import org.junit.Assert;
import org.junit.Test;


public class RubenWebServiceTest {
    RubenWebService rubenWebService = new RubenWebService();

    @Test
    public void postVolkswagenTest() {
        Owner owner = new Owner();
        owner.setId("theo");

        VolkswagenPassatCar car = new VolkswagenPassatCar();
        owner.getCars().saveCar(car);

        VolkswagenPassatCar car2 = new VolkswagenPassatCar();
        car2.setMake("Polo");
        owner.getCars().saveCar(car2);

        Response response = rubenWebService.sendCar(owner);
        Assert.assertEquals("Wrong statuscode returned by webservice", 200, response.getStatusCode());
    }


}
