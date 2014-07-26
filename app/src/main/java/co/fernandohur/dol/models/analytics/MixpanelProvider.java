package co.fernandohur.dol.models.analytics;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;
import com.mixpanel.android.mpmetrics.MixpanelAPI;

import org.json.JSONObject;

import javax.inject.Inject;

import co.fernandohur.dol.models.DataEvent;
import co.fernandohur.dol.models.Injector;

/**
 * Implementation of AnalyticsProvider based on Mixpanel
 */
public class MixpanelProvider implements AnalyticsProvider{

    public final static String TAG = "MixpanelProvider";

    private MixpanelAPI mixpanelAPI;

    public MixpanelProvider(MixpanelAPI mixpanelAPI){
        this.mixpanelAPI = mixpanelAPI;
        this.mixpanelAPI.identify("fernandohur");
    }

    @Override
    public void sendEvent(DataEvent event) {
        JSONObject jsonObject = new JSONObject(event.getAttributes());
        mixpanelAPI.track(event.getName(), jsonObject);
        Log.d(TAG, "tracked: "+event.getName());
    }

    @Override
    public void flush() {
        Log.d(TAG, "FLushing mixpanel data");
        mixpanelAPI.flush();
    }
}
