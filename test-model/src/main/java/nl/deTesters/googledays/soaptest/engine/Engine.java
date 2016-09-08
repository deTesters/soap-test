package nl.deTesters.googledays.soaptest.engine;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public abstract class Engine {
    EngineType engineType;
    EngineState engineState = EngineState.STOPPED;
    int volume;

    public void start() {
        if (engineState == EngineState.STOPPED) {
            engineState = EngineState.STARTED;
        }
    }

    public void stop() {
        if (engineState == EngineState.STARTED) {
            engineState = EngineState.STOPPED;
        }
    }

    public EngineType getEngineType() {
        return engineType;
    }

    @XmlElement
    public void setEngineType(EngineType engineType) {
        this.engineType = engineType;
    }

    public EngineState getEngineState() {
        return engineState;
    }

    @XmlElement
    public void setEngineState(EngineState engineState) {
        this.engineState = engineState;
    }

    public int getVolume() {
        return volume;
    }

    @XmlElement
    public void setVolume(int volume) {
        this.volume = volume;
    }

}
