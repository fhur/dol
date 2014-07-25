package co.fernandohur.dol.modules;

import android.content.Context;

import com.mixpanel.android.mpmetrics.MixpanelAPI;
import com.squareup.otto.Bus;

import javax.inject.Singleton;

import co.fernandohur.dol.controllers.DataEventController;
import co.fernandohur.dol.models.DataEventCollection;
import co.fernandohur.dol.models.MixpanelApiKeyProvider;
import co.fernandohur.dol.models.analytics.AnalyticsProvider;
import co.fernandohur.dol.models.analytics.MixpanelProvider;
import dagger.Module;
import dagger.Provides;

/**
 * Place all models that should be injected here
 */
@Module(library = true, includes = BusModule.class)
public class ModelsModule {

    @Provides @Singleton
    public DataEventCollection providesDataEventCollection(Bus bus){
        return new DataEventCollection(bus);
    }

    @Provides
    public MixpanelApiKeyProvider providesMixpanelApiKeyProvider(Context context){
        return new MixpanelApiKeyProvider.DefaultProvider(context);
    }

    @Provides
    public MixpanelAPI providesMixpanelAPI(Context context, MixpanelApiKeyProvider provider){
        return MixpanelAPI.getInstance(context, provider.getApiKey());
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
