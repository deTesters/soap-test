package nl.detesters.googledays.backend.model.car;

import nl.detesters.googledays.backend.model.engine.Engine;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.StringWriter;


@XmlRootElement(name = "car")
public abstract class Car {

    protected String make;
    protected String model;
    protected Engine engine;
    protected String id;

    /**
     * Gets the value of the make property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getMake() {
        return make;
    }

    /**
     * Sets the value of the make property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    @XmlElement(required = true, name = "make")
    public void setMake(String value) {
        this.make = value;
    }

    /**
     * Gets the value of the model property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getModel() {
        return model;
    }

    /**
     * Sets the value of the model property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    @XmlElement(required = true, name = "model")
    public void setModel(String value) {
        this.model = value;
    }

    /**
     * Gets the value of the engine property.
     *
     * @return possible object is
     * {@link Engine }
     */
    public Engine getEngine() {
        return engine;
    }

    /**
     * Sets the value of the engine property.
     *
     * @param value allowed object is
     *              {@link Engine }
     */
    @XmlElement(required = true, name = "engine")
    public void setEngine(Engine value) {
        this.engine = value;
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
            JAXBContext jaxbContext = JAXBContext.newInstance(Car.class);
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
