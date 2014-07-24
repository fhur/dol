package co.fernandohur.dol.models;

import android.util.Log;
import android.util.Pair;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
        Log.d("DataEventModel", "Uploading event "+this);
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

    /**
     * @return the attribute map as a list of Pair<String, String>
     */
    public List<Pair<String, String>> getAttributesList(){
        Map<String, String> map = getEvent().getAttributes();
        Set<Map.Entry<String, String>> entrySet = map.entrySet();
        List<Pair<String, String>> list = new ArrayList<Pair<String, String>>(map.size());
        for(Map.Entry<String, String> entry : entrySet){
            Pair<String, String> pair = new Pair<String, String>(entry.getKey(), entry.getValue());
            list.add(pair);
        }
        return list;
    }

    @Override
    public String toString() {
        return "[ id="+getId()+", data="+getEvent()+"]";
    }
}
