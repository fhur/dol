package co.fernandohur.dol.controllers;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;

import java.util.Map;

import javax.inject.Inject;

import co.fernandohur.dol.models.DataEvent;
import co.fernandohur.dol.models.DataEventCollection;
import co.fernandohur.dol.models.DataEventModel;
import co.fernandohur.dol.models.Injector;
import co.fernandohur.dol.models.events.CreateDataPointEvent;
import co.fernandohur.dol.models.events.RemoveDataPointEvent;

/**
 * Controller for handling DataEvent related Events
 * Note: Do not confuse event bus events. These are all placed inside the models.events package
 * with DataEvent which is a data point that will be uploaded to mixpanel, segment.io, etc
 */
public class DataEventController {

    public final static String TAG = "DataEventController";

    @Inject DataEventCollection eventCollection;
    @Inject Bus bus;
    @Inject Context context;

    @Subscribe
    public void onCreateEvent(CreateDataPointEvent event){
        Map<String, String> map = event.getMap();
        String name = event.getEventName();
        DataEvent dataEvent = new DataEvent(name, map);
        DataEventModel model = new DataEventModel(context, dataEvent);
        eventCollection.add(model);
        eventCollection.save();
        Log.d(TAG, "Created new DataEvent: "+eventCollection);
    }

    @Subscribe
    public void onRemoveEvent(RemoveDataPointEvent event){
        Log.d(TAG, "Removing event: "+event);
        boolean removed = eventCollection.remove(event.getData());
        if(removed){
            eventCollection.save();
            Toast.makeText(context, "Event Removed", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Initializes the DataEventController. Without calling this method the DataEventController
     * will not receive event and thus do nothing.
     * @param context the app context
     */
    public void initialize(Context context){
        Injector.inject(context, this);
        bus.register(this);
    }
}
