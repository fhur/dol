package co.fernandohur.dol.models.events;

import com.robot.DataEvent;

import java.util.Map;

import co.fernandohur.dol.models.DataEventModel;

/**
 * Created an event that signals the update of a given event
 */
public class ModifyDataPointEvent {

    private String eventId;
    private String eventName;
    private Map<String, String> attrs;

    public ModifyDataPointEvent(String eventId, Map<String, String> attrs, String eventName){
        this.eventId = eventId;
        this.attrs = attrs;
        this.eventName = eventName;
    }

    public String getEventId(){
        return eventId;
    }

    public String getEventName(){
        return eventName;
    }

    public Map<String, String> getAttrs() {
        return attrs;
    }
}
