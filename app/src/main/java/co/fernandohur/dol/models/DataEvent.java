package co.fernandohur.dol.models;

import com.robot.Model;

/**
 * Represents a 'general event'
 */
public class DataEvent extends Model{

    /**
     * The name of the event, i.e. "Went out for a run"
     */
    private String name;

    public DataEvent(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }
}
