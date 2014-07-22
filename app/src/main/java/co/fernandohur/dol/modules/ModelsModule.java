package co.fernandohur.dol.modules;

import com.squareup.otto.Bus;

import javax.inject.Singleton;

import co.fernandohur.dol.controllers.DataEventController;
import co.fernandohur.dol.models.DataEventCollection;
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

    @Provides @Singleton
    public DataEventController providesDataEventController(){
        return new DataEventController();
    }
}
