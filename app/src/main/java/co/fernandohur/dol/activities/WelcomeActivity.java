package co.fernandohur.dol.activities;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.List;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import co.fernandohur.dol.R;
import co.fernandohur.dol.models.DataEvent;
import co.fernandohur.dol.models.DataEventCollection;
import co.fernandohur.dol.models.DataEventModel;
import co.fernandohur.dol.ui.DataEventAdapter;


public class WelcomeActivity extends BaseActivity {

    @InjectView(R.id.listViewSelectEvent) ListView listViewSelectEvent;

    @Inject DataEventCollection dataEventCollection;

    private DataEventAdapter dataEventAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        ButterKnife.inject(this);

        dataEventAdapter = new DataEventAdapter(this);
        listViewSelectEvent.setAdapter(dataEventAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();

        List<DataEvent> events = dataEventCollection.getEvents();
        dataEventAdapter.setData(events);
    }

    @OnClick(R.id.btnCreateEvent)
    public void onCreateEvent(){
        Intent intent = CreateEventActivity.getIntent(this);
        startActivity(intent);
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
