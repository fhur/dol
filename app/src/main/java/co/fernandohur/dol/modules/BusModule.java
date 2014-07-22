package co.fernandohur.dol.modules;

import com.robot.EventBus;
import com.squareup.otto.Bus;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Module exclusively for the global event bus
 */
@Module(library = true)
public class BusModule {

    @Provides @Singleton
    public Bus providesBus(){
        return new EventBus();
    }
}
