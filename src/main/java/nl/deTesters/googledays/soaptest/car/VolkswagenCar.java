package nl.deTesters.googledays.soaptest.car;

import nl.deTesters.googledays.soaptest.engine.PetrolEngine;

import java.util.UUID;

public class VolkswagenCar extends Car {
    private static final String NAME = "Volkswagen";

    public VolkswagenCar() {
        setId(UUID.randomUUID().toString());
        setName(NAME);
        setEngine(new PetrolEngine());
    }
}
