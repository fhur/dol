package co.fernandohur.dol.activities;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.robot.ui.ListAdapter;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import co.fernandohur.dol.R;
import co.fernandohur.dol.models.Event;
import co.fernandohur.dol.ui.EventAdapter;


public class WelcomeActivity extends ActionBarActivity {

    @InjectView(R.id.listViewSelectEvent) ListView listViewSelectEvent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        ButterKnife.inject(this);

        DataEventAdapter dataEventAdapter = new DataEventAdapter(this);
        listViewSelectEvent.setAdapter(dataEventAdapter);
    }

    @OnClick(R.id.btnCreateEvent)
    public void onCreateEvent(){
        //TODO launch the create event activity
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.welcome, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
