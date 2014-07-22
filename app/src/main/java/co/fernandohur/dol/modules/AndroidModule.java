package co.fernandohur.dol.modules;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Provides Android app context and other android stuff
 */
@Module(library = true)
public class AndroidModule {

    private Context context;

    public AndroidModule(Context context){
        this.context = context;
    }

    @Provides
    public Context providesContext(){
        return context;
    }
}
