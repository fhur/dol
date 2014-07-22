package co.fernandohur.dol.models;

import com.robot.Model;

/**
 * A model class
 */
public class DataEventModel extends Model {

    private DataEvent event;

    public DataEventModel(DataEvent event){
        this.event = event;
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

    public DataEvent getEvent() {
        return event;
    }
}
