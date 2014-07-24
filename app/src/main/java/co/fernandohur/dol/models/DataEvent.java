package co.fernandohur.dol.models;

import com.robot.Model;

import java.util.Map;

/**
 * Represents a 'general event'
 */
public class DataEvent {

    /**
     * The name of the event, i.e. "Went out for a run"
     */
    private String name;
    private Map<String, String> attrs;

    public DataEvent(String name, Map<String, String> attrs) {
        this.name = name;
        this.attrs = attrs;
    }

    public String getName(){
        return name;
    }

    /**
     * @return a map of attribute => default value
     */
    public Map<String, String> getAttributes() {
        return attrs;
    }

    @Override
    public String toString() {
        return name;
    }
}
