package co.fernandohur.dol.models;

import com.robot.BaseCollection;
import com.squareup.otto.Bus;

import java.util.List;

/**
 * Created by fernandinho on 7/20/14.
 */
public class DataEventCollection extends BaseCollection<DataEventModel> {

    public DataEventCollection(Bus bus){
        this.setEventBus(bus);
    }

    public List<DataEvent> getEvents(){
        return map(new Mapper<DataEventModel, DataEvent>() {
            @Override
            public DataEvent map(DataEventModel el) {
                return el.getEvent();
            }
        });
    }

}
