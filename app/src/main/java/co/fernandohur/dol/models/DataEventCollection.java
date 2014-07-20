package co.fernandohur.dol.models;

import com.robot.BaseCollection;
import com.squareup.otto.Bus;

/**
 * Created by fernandinho on 7/20/14.
 */
public class DataEventCollection extends BaseCollection<DataEvent> {

    public DataEventCollection(Bus bus){
        this.setEventBus(bus);
    }
}
