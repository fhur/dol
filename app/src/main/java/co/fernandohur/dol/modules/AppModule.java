package co.fernandohur.dol.modules;

import co.fernandohur.dol.activities.CreateEventActivity;
import co.fernandohur.dol.activities.SendEventActivity;
import co.fernandohur.dol.activities.SettingsActivity;
import co.fernandohur.dol.activities.WelcomeActivity;
import co.fernandohur.dol.controllers.DataEventController;
import dagger.Module;

/**
 * Add all modules except the AndroidModule to the includes attribute,
 * Add all classes to be injected to the injects attribute
 */
@Module(
        includes = {
                BusModule.class,
                ModelsModule.class
        },
        injects = {
                WelcomeActivity.class,
                CreateEventActivity.class,
                SendEventActivity.class,
                SettingsActivity.class,

                DataEventController.class
        }
)
public class AppModule {}
