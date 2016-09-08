package nl.deTesters.googledays.soaptest.car;

import nl.deTesters.googledays.soaptest.engine.Engine;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.StringWriter;

@XmlRootElement
public abstract class Car {
    String make;
    String model;
    String id;
    Engine engine;

    public String getId() {
        return id;
    }

    @XmlAttribute
    public void setId(String id) {
        this.id = id;
    }

    public String getMake() {
        return make;
    }

    @XmlElement
    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    @XmlElement
    public void setModel(String model) {
        this.model = model;
    }

    public Engine getEngine() {
        return engine;
    }

    @XmlElement
    public void setEngine(Engine engine) {
        this.engine = engine;
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
