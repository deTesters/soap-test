package nl.deTesters.googledays.soaptest.car;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "car"
})
@XmlRootElement(name = "cars")
public class Cars {

    protected List<Car> car;

    /**
     * Gets the value of the car property.
     */
    public List<Car> getCar() {
        if (car == null) {
            car = new ArrayList<Car>();
        }
        return this.car;
    }

}
