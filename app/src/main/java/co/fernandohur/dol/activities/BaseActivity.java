package co.fernandohur.dol.activities;

import android.support.v7.app.ActionBar;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import com.squareup.otto.Bus;

import javax.inject.Inject;

import co.fernandohur.dol.models.Injector;

/**
 * Base activity that handles some common tasks such as registering the event bus and setting the
 * 'up' button in the action bar
 */
public class BaseActivity extends ActionBarActivity {

    @Inject Bus bus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Injector.inject(this);

        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        bus.register(this);
    }

    @Override
    protected void onPause() {
        super.onPause();

        bus.unregister(this);
    }

    /**
     * Posts an event to the global event bus. See {@link Bus#post(Object)} for more details.
     * @param event the event
     */
    public void postEvent(Object event){
        bus.post(event);
    }
}
