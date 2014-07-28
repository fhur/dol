package co.fernandohur.dol.models.analytics;

import android.util.Log;

import co.fernandohur.dol.models.DataEvent;

/**
 * Interface for analytics providers to implement when sending data.
 */
public interface AnalyticsProvider {

    public final static String TAG = "AnalyticsProvider";

    /**
     * Sends an event asynchronously (this does not block the UI thread)
     * @param event the event to be sent
     */
    public void sendEvent(DataEvent event);

    /**
     * Releases resources
     */
    public void flush();

    /**
     * Implementation of AnalyticsProvider that does nothing
     */
    public final static class VoidProvider implements AnalyticsProvider{

        public VoidProvider(){
            Log.d(TAG, "Created new VoidProvider");
        }

        @Override
        public void flush() {}

        @Override
        public void sendEvent(DataEvent event) {
            Log.d(TAG, "sendEvent called but not event will be sent by VoidProvider");
        }
    }
}
