package nl.detesters.googledays.backend.service;

import nl.detesters.googledays.backend.model.owner.Owner;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by rubengeertsema on 08/09/16.
 */
@Component
public class Storage {

    private Map<String, Owner> storage = new HashMap<>();

    public Owner getOwner(String id) {
        return storage.get(id);
    }

    public void addOwner(Owner owner) {
        this.storage.put(owner.getId(), owner);
    }
}