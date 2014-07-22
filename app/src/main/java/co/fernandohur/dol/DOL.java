package co.fernandohur.dol;

import android.app.Application;
import android.content.Context;

import co.fernandohur.dol.controllers.DataEventController;
import co.fernandohur.dol.modules.AndroidModule;
import co.fernandohur.dol.modules.AppModule;
import dagger.ObjectGraph;

/**
 * Created by fernandinho on 7/22/14.
 */
public class DOL extends Application {

    private ObjectGraph og;
    private DataEventController controller;

    @Override
    public void onCreate() {
        super.onCreate();

        og = ObjectGraph.create(
                new AndroidModule(this),
                new AppModule()
                );

        controller = og.get(DataEventController.class);
        controller.initialize(this);
    }

    public ObjectGraph getObjectGraph() {
        return og;
    }
}
