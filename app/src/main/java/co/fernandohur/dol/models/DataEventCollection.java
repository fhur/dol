package co.fernandohur.dol.models;

import android.content.Context;

import com.robot.BaseCollection;
import com.squareup.otto.Bus;

import java.util.List;

/**
 * Created by fernandinho on 7/20/14.
 */
public class DataEventCollection extends BaseCollection<DataEventModel> {

    private DataEventStorage storage;

    public DataEventCollection(Context context, Bus bus, DataEventStorage storage){
        this.setEventBus(bus);
        this.storage = storage;

        load(context);
    }

    private void load(final Context context) {
        // Load any stored data as soon as the collection is created
        this.storage.load();
        List<DataEventModel> list = map(this.storage.load(), new Mapper<DataEvent, DataEventModel>() {
            @Override
            public DataEventModel map(DataEvent el) {
                return new DataEventModel(context, el);
            }
        });
        addAll(list, true);
    }

    public List<DataEvent> getEvents(){
        return map(new Mapper<DataEventModel, DataEvent>() {
            @Override
            public DataEvent map(DataEventModel el) {
                return el.getEvent();
            }
        });
    }

    public DataEventModel find(final String id) {
        return filterFirst(new Filter<DataEventModel>() {
            @Override
            public boolean include(DataEventModel el) {
                return el.getId().equals(id);
            }
        });
    }

    /**
     * Persists this collections state
     */
    public void save() {
        storage.save(getEvents());
    }
}
