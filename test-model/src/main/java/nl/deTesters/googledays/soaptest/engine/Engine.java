package nl.deTesters.googledays.soaptest.engine;

import javax.xml.bind.annotation.*;
import java.math.BigInteger;

@XmlRootElement(name = "engine")
public abstract class Engine {

    protected EngineState engineState = EngineState.STOPPED;
    protected EngineType type;
    protected int volume;

    /**
     * Gets the value of the engineState property.
     *
     * @return possible object is
     * {@link String }
     */
    public EngineState getEngineState() {
        return engineState;
    }

    /**
     * Sets the value of the engineState property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    @XmlElement(required = true, name = "engineState")
    public void setEngineState(EngineState value) {
        this.engineState = value;
    }

    /**
     * Gets the value of the type property.
     *
     * @return possible object is
     * {@link String }
     */
    public EngineType getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    @XmlElement(required = true, name = "type")
    public void setType(EngineType value) {
        this.type = value;
    }

    /**
     * Gets the value of the volume property.
     *
     * @return possible object is
     * {@link BigInteger }
     */
    public int getVolume() {
        return volume;
    }

    /**
     * Sets the value of the volume property.
     *
     * @param value allowed object is
     *              {@link BigInteger }
     */
    @XmlElement(required = true, name = "volume")
    public void setVolume(int value) {
        this.volume = value;
    }

}
