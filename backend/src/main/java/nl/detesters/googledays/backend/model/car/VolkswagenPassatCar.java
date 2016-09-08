package nl.detesters.googledays.backend.model.car;

import nl.detesters.googledays.backend.model.engine.PetrolEngine;

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
