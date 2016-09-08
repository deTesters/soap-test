package nl.deTesters.googledays.soaptest.car;

import nl.deTesters.googledays.soaptest.engine.PetrolEngine;

import java.util.UUID;

public class VolkswagenPassatCar extends Car {
    private static final String MAKE = "Volkswagen";
    private static final String MODEL = "Passat";

    public VolkswagenPassatCar() {
        setId(UUID.randomUUID().toString());
        setMake(MAKE);
        setModel(MODEL);
        setEngine(new PetrolEngine(1800));
    }
}
