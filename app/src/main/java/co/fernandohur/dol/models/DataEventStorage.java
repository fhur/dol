package co.fernandohur.dol.models;

import android.content.Context;

import com.google.gson.reflect.TypeToken;
import com.robot.JsonSerializerStorage;

import java.util.ArrayList;
import java.util.List;

/**
 * Storage for DataEventModel data
 */
public class DataEventStorage extends JsonSerializerStorage<List<DataEvent>>{

    public final static String LOCATION = "storage.data_event_storage";

    public DataEventStorage(Context context) {
        super(context, new TypeToken<List<DataEvent>>(){}, LOCATION);
    }

    @Override
    public List<DataEvent> load() {
        List<DataEvent> result = super.load();
        if(result == null){
            result = new ArrayList<DataEvent>(0);
        }
        return result;
    }
}
