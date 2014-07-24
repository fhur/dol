package co.fernandohur.dol.activities;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
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


public class WelcomeActivity extends BaseActivity implements AdapterView.OnItemClickListener {

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
        listViewSelectEvent.setOnItemClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        List<DataEventModel> events = dataEventCollection.toList();
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
            startActivity(SettingsActivity.getIntent(this));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        DataEventModel event = dataEventAdapter.getItem(position);
        Intent intent = SendEventActivity.getIntent(this, event);
        startActivity(intent);
    }

    /**
     * @param context a reference to a context
     * @return returns the intent used to launch this activity
     */
    public static Intent getIntent(Context context) {
        return new Intent(context, WelcomeActivity.class);
    }
}
