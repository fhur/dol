package co.fernandohur.dol.models;

import java.util.Date;

import com.robot.Model;

/**
 * A model class
 */
public class DataEventModel extends Model {

    private DataEvent event;
    private String id;

    /**
     * Creates a new DataEventModel
     * @param event the actual event data
     * @throws java.lang.IllegalArgumentException if event is null
     */
    public DataEventModel(DataEvent event){
        if(event == null) throw new IllegalArgumentException("event == null");
        this.event = event;
        this.id = new Date().getTime()+"";
    }

    @Override
    public boolean isValid() {
        // TODO implement validations
        // 1. Event cannot be null
        // 2. Event name cannot be empty
        // 3. Event name cannot be null
        return true;
    }

    /**
     * Uploads this event.
     */
    public void sync(){
        // TODO upload this event
    }

    /**
     * @return the unique identifier for this DataEventModel.
     */
    public String getId() {
        return id;
    }

    /**
     * @return the underlying event. This can never be null
     */
    public DataEvent getEvent() {
        return event;
    }
}
