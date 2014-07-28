package co.fernandohur.dol.modules;

import android.content.Context;

import com.mixpanel.android.mpmetrics.MixpanelAPI;
import com.squareup.otto.Bus;

import javax.inject.Singleton;

import co.fernandohur.dol.controllers.DataEventController;
import co.fernandohur.dol.models.DataEventCollection;
import co.fernandohur.dol.models.DataEventStorage;
import co.fernandohur.dol.models.MixpanelApiKeyProvider;
import co.fernandohur.dol.models.analytics.AnalyticsProvider;
import co.fernandohur.dol.models.analytics.MixpanelProvider;
import dagger.Module;
import dagger.Provides;

/**
 * Place all models that should be injected here
 */
@Module(
        library = true,
        includes = {
                BusModule.class,
                AndroidModule.class
        }
)
public class ModelsModule {

    @Provides @Singleton
    public DataEventStorage providesDataEventStorage(Context context){
        return new DataEventStorage(context);
    }

    @Provides @Singleton
    public DataEventCollection providesDataEventCollection(Context context, Bus bus, DataEventStorage storage){
        return new DataEventCollection(context, bus, storage);
    }

    @Provides @Singleton
    public MixpanelApiKeyProvider providesMixpanelApiKeyProvider(Context context){
        return new MixpanelApiKeyProvider.DefaultProvider(context);
    }

    @Provides
    public MixpanelAPI providesMixpanelAPI(Context context, MixpanelApiKeyProvider mixpanelApiKeyProvider){
        return MixpanelAPI.getInstance(context, mixpanelApiKeyProvider.getApiKey());
    }

    @Provides @Singleton
    public AnalyticsProvider providesAnalyticsProvider(MixpanelAPI mixpanelAPI){
        return new MixpanelProvider(mixpanelAPI);
    }

    @Provides @Singleton
    public DataEventController providesDataEventController(){
        return new DataEventController();
    }
}
