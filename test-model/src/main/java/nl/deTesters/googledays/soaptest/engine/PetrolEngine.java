package nl.deTesters.googledays.soaptest.engine;

public class PetrolEngine extends Engine {
    private static final EngineType ENGINE_TYPE = EngineType.Petrol;

    public PetrolEngine(int volume){
        setType(ENGINE_TYPE);
        setVolume(volume);
    }
}
