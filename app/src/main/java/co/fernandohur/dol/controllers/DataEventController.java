package co.fernandohur.dol.controllers;

import com.squareup.otto.Subscribe;

import java.util.Map;

import javax.inject.Inject;

import co.fernandohur.dol.models.DataEventCollection;
import co.fernandohur.dol.models.events.CreateDataPointEvent;

/**
 * Created by fernandinho on 7/20/14.
 */
public class DataEventController {

    @Inject DataEventCollection eventCollection;

    @Subscribe
    public void onCreateEvent(CreateDataPointEvent event){
        Map<String, String> map = event.getMap();
        String name = event.getEventName();

    }
}
