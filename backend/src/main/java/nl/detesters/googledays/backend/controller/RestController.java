package nl.detesters.googledays.backend.controller;

import nl.detesters.googledays.backend.model.car.Car;
import nl.detesters.googledays.backend.model.car.Cars;
import nl.detesters.googledays.backend.model.owner.Owner;
import nl.detesters.googledays.backend.service.Storage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import java.io.IOException;
import java.io.StringReader;

/**
 * Created by rubengeertsema on 08/09/16.
 */
@org.springframework.web.bind.annotation.RestController
public class RestController {

    private final Storage storage;

    @Autowired
    public RestController(Storage storage) {
        this.storage = storage;
    }

    @RequestMapping(value = "/api/car", method = RequestMethod.POST)
    public String addCar(HttpEntity<String> httpEntity) throws IOException {
        StringReader stringReader = new StringReader(httpEntity.getBody());
        Owner owner = null;

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Owner.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            owner = (Owner) jaxbUnmarshaller.unmarshal(stringReader);
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        Owner existing = storage.getOwner(owner.getId());
        if (existing == null) {
            storage.addOwner(owner);
        } else {
            for (Car car : owner.getCars().getCar()) {
                existing.getCars().saveCar(car);
            }
        }

        return "stored";
    }

    @ResponseBody
    @RequestMapping(value = "/api/car/{nameOwner}", method = RequestMethod.GET, produces = "application/xml")
    public Cars getCarsForOwner(@PathVariable("nameOwner") String nameOwner) throws IOException {
        return storage.getOwner(nameOwner).getCars();
    }
}