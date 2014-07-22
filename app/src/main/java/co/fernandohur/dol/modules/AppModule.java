package co.fernandohur.dol.modules;

import dagger.Module;

/**
 * Created by fernandinho on 7/22/14.
 */
@Module(
        includes = {
                BusModule.class,
                ModelsModule.class
        }
)
public class AppModule {}
