package co.fernandohur.dol.controllers;

import android.content.Context;
import android.util.Log;

import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;

import java.util.Map;

import javax.inject.Inject;

import co.fernandohur.dol.models.DataEvent;
import co.fernandohur.dol.models.DataEventCollection;
import co.fernandohur.dol.models.DataEventModel;
import co.fernandohur.dol.models.Injector;
import co.fernandohur.dol.models.events.CreateDataPointEvent;

/**
 * Controller for handling DataEvent related Events
 * Note: Do not confuse event bus events. These are all placed inside the models.events package
 * with DataEvent which is a data point that will be uploaded to mixpanel, segment.io, etc
 */
public class DataEventController {

    @Inject DataEventCollection eventCollection;
    @Inject Bus bus;
    @Inject Context context;


    @Subscribe
    public void onCreateEvent(CreateDataPointEvent event){
        Map<String, String> map = event.getMap();
        String name = event.getEventName();
        DataEvent dataEvent = new DataEvent(name, map);
        eventCollection.add(new DataEventModel(context, dataEvent));

        Log.d("DataEventController", "Created new DataEvent: "+eventCollection);
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
