package nl.deTesters.googledays.soaptest.car;

import nl.deTesters.googledays.soaptest.engine.Engine;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.*;
import java.io.StringWriter;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "make",
        "model",
        "engine"
})
@XmlRootElement(name = "car")
public class Car {

    @XmlElement(required = true)
    protected String make;
    @XmlElement(required = true)
    protected String model;
    @XmlElement(required = true)
    protected Engine engine;
    @XmlAttribute(name = "id")
    protected String id;

    /**
     * Gets the value of the make property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getMake() {
        return make;
    }

    /**
     * Sets the value of the make property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setMake(String value) {
        this.make = value;
    }

    /**
     * Gets the value of the model property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getModel() {
        return model;
    }

    /**
     * Sets the value of the model property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setModel(String value) {
        this.model = value;
    }

    /**
     * Gets the value of the engine property.
     *
     * @return
     *     possible object is
     *     {@link Engine }
     *
     */
    public Engine getEngine() {
        return engine;
    }

    /**
     * Sets the value of the engine property.
     *
     * @param value
     *     allowed object is
     *     {@link Engine }
     *
     */
    public void setEngine(Engine value) {
        this.engine = value;
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

    @Override
    public String toString() {
        StringWriter stringWriter = new StringWriter();
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(this.getClass());
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
