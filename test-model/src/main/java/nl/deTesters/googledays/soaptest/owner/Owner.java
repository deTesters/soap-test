package nl.deTesters.googledays.soaptest.owner;

import nl.deTesters.googledays.soaptest.car.Car;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
public class Owner {
    private List<Car> cars;
    private String id;


    public List<Car> getCars() {
        return cars;
    }

    @XmlElement
    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public String getId() {
        return id;
    }

    @XmlAttribute
    public void setId(String id) {
        this.id = id;
    }
}
