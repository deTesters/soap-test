package nl.deTesters.googledays.soaptest.car;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public void saveCar(Car car){
        for(int i = 0; i < getCar().size(); i++){
            Car existingCar = getCar().get(i);
            if (existingCar.getId().equals(car.getId())){
                getCar().remove(i);
            }
            getCar().add(car);
        }
    }

    public Car getCar(String id){
        Car car = null;
        for(Car existingCar : getCar()){
            if (existingCar.getId().equals(id)){
                car = existingCar;
            }
        }
        return car;
    }
}
