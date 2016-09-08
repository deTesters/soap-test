package nl.detesters.googledays.backend.model.owner;

import nl.detesters.googledays.backend.model.car.Cars;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.StringWriter;

@XmlRootElement
public class Owner {

    protected Cars cars;
    protected String id;

    /**
     * Gets the value of the cars property.
     *
     * @return possible object is
     * {@link Cars }
     */
    public Cars getCars() {
        if (cars == null){
            cars = new Cars();
        }
        return cars;
    }

    /**
     * Sets the value of the cars property.
     *
     * @param value allowed object is
     *              {@link Cars }
     */
    @XmlElement(required = true, name = "cars")
    public void setCars(Cars value) {
        this.cars = value;
    }

    /**
     * Gets the value of the id property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    @XmlAttribute(required = true, name = "id")
    public void setId(String value) {
        this.id = value;
    }

    @Override
    public String toString() {
        StringWriter stringWriter = new StringWriter();
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Owner.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            // output pretty printed
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            jaxbMarshaller.marshal(this, stringWriter);
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        return stringWriter.toString();
    }
}
