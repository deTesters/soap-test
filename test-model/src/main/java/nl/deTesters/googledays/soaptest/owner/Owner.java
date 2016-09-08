package nl.deTesters.googledays.soaptest.owner;

import nl.deTesters.googledays.soaptest.car.Cars;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
public class Owner {
    @XmlElement(required = true, name = "cars")
    protected Cars cars;
    @XmlAttribute(name = "id")
    protected String id;

    /**
     * Gets the value of the cars property.
     *
     * @return
     *     possible object is
     *     {@link Cars }
     *
     */
    public Cars getCars() {
        return cars;
    }

    /**
     * Sets the value of the cars property.
     *
     * @param value
     *     allowed object is
     *     {@link Cars }
     *
     */
    public void setCars(Cars value) {
        this.cars = value;
    }

    /**
     * Gets the value of the id property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setId(String value) {
        this.id = value;
    }

}
