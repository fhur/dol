package co.fernandohur.dol.modules;

import com.squareup.otto.Bus;

import co.fernandohur.dol.models.DataEventCollection;
import dagger.Module;

/**
 * Created by fernandinho on 7/22/14.
 */
@Module(library = false)
public class ModelsModule {

    public DataEventCollection providesDataEventCollection(Bus bus){
        return new DataEventCollection(bus);
    }
}
