package co.fernandohur.dol.activities;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.InjectView;
import co.fernandohur.dol.R;
import co.fernandohur.dol.models.DataEvent;
import co.fernandohur.dol.models.DataEventCollection;
import co.fernandohur.dol.models.DataEventModel;

public class SendEventActivity extends BaseActivity {

    public final static String EXTRA_DATA_EVENT_ID = "extras.data_event_id";

    @Inject DataEventCollection dataEventCollection;

    @InjectView(R.id.txtEventName) TextView txtEventName;
    @InjectView(R.id.listViewAttrs) ListView listViewAttrs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_event);

        ButterKnife.inject(this);

        // TODO set adapter for listViewAttrs
    }

    @Override
    protected void onResume() {
        super.onResume();

        String id = getDataEventModelId(getIntent());
        if(id == null){
            throw new IllegalArgumentException("Cannot pass a null id");
        }
        else{
            DataEventModel model = dataEventCollection.find(id);
            DataEvent dataEvent = model.getEvent();
            txtEventName.setText(dataEvent.getName());
            dataEvent.getAttributes();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.send_event, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_edit_event) {
            // TODO open the edit DataEvent activity
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public static Intent getIntent(Context context, DataEventModel dataEventModel){
        Intent intent = new Intent(context, SendEventActivity.class);
        intent.putExtra(EXTRA_DATA_EVENT_ID, dataEventModel.getId());
        return intent;
    }

    public static String getDataEventModelId(Intent intent){
        return intent.getStringExtra(EXTRA_DATA_EVENT_ID);
    }
}
