package nl.deTesters.googledays.soaptest.engine;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public abstract class Engine {
    String type;
    EngineState engineState = EngineState.STOPPED;

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

    public String getType() {
        return type;
    }

    @XmlElement
    public void setType(String type) {
        this.type = type;
    }

    public EngineState getEngineState() {
        return engineState;
    }

    @XmlElement
    public void setEngineState(EngineState engineState) {
        this.engineState = engineState;
    }
}
