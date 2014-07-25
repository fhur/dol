package co.fernandohur.dol.models.analytics;

import co.fernandohur.dol.models.DataEvent;

/**
 * Interface for analytics providers to implement when sending data.
 */
public interface AnalyticsProvider {

    /**
     * Sends an event asynchronously (this does not block the UI thread)
     * @param event the event to be sent
     */
    public void sendEvent(DataEvent event);

    /**
     * Releases resources
     */
    public void flush();
}
