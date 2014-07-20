package co.fernandohur.dol.models.events;

import java.util.Map;

/**
 * Created by fernandinho on 7/20/14.
 */
public class CreateDataPointEvent {

    private String eventName;
    private Map<String, String> kvMap;

    public CreateDataPointEvent(String eventName, Map<String, String> kvMap) {
        this.eventName = eventName;
        this.kvMap = kvMap;
    }

    public String getEventName() {
        return eventName;
    }

    public Map<String, String> getMap() {
        return kvMap;
    }
}
