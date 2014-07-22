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
 * Created by fernandinho on 7/20/14.
 */
public class DataEventController {

    @Inject DataEventCollection eventCollection;
    @Inject Bus bus;

    @Subscribe
    public void onCreateEvent(CreateDataPointEvent event){
        Map<String, String> map = event.getMap();
        String name = event.getEventName();
        DataEvent dataEvent = new DataEvent(name);
        eventCollection.add(new DataEventModel(dataEvent));

        Log.d("DataEventController", "Created new DataEvent: "+eventCollection);
    }

    public void initialize(Context context){
        Injector.inject(context, this);
        bus.register(this);
    }
}
