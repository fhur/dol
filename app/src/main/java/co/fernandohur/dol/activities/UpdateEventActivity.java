package co.fernandohur.dol.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.Map;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import co.fernandohur.dol.R;
import co.fernandohur.dol.models.DataEventCollection;
import co.fernandohur.dol.models.DataEventModel;
import co.fernandohur.dol.models.events.CreateDataPointEvent;
import co.fernandohur.dol.models.events.ModifyDataPointEvent;
import co.fernandohur.dol.ui.DialogAddKeyValue;
import co.fernandohur.dol.ui.KeyValueAdapter;

public class UpdateEventActivity extends BaseActivity implements DialogAddKeyValue.OnAddKeyValueListener {

    public final static String EXTRA_EVENT_ID = "event_id";

    @InjectView(R.id.txtEventName) EditText txtEventName;
    @InjectView(R.id.listViewKeyValues) ListView listViewKeyValues;

    private DialogAddKeyValue dialogAddKeyValue;
    private KeyValueAdapter adapter;

    @Inject DataEventCollection dataEventCollection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_event);

        ButterKnife.inject(this);

        adapter = new KeyValueAdapter(this);
        listViewKeyValues.setAdapter(adapter);

        dialogAddKeyValue = new DialogAddKeyValue(this, this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        String eventId = getExtraEventId();
        if(eventId == null){
            throw new IllegalArgumentException("eventId == null");
        }

        DataEventModel model = dataEventCollection.find(eventId);
        if(model == null){
            Toast.makeText(this, "Event no longer exists", Toast.LENGTH_SHORT).show();
            finish();
        }
        else{
            adapter.setData(model.getAttributesList());
            txtEventName.setText(model.getEvent().getName());
        }
    }

    public String getExtraEventId(){
        return getIntent().getStringExtra(EXTRA_EVENT_ID);
    }

    @OnClick(R.id.btnCreateEvent)
    public void onCreateEvent(){
        String eventName = txtEventName.getText().toString();
        Map<String, String> map = adapter.getMap();
        postEvent(new ModifyDataPointEvent(getExtraEventId(), map, eventName));
        finish();
    }

    @OnClick(R.id.btnAddKeyValue)
    public void onAddKeyValuePair(){
        dialogAddKeyValue.show();
    }

    @Override
    public void onAddKeyValue(String key, String value) {
        adapter.add(new Pair<String, String>(key, value));
        adapter.notifyDataSetChanged();
    }

    /**
     * @param context a reference to the app context
     * @param eventId the id of the event that will be modified
     * @return an intent that open the UpdateEventActivity on the given eventId
     */
    public static Intent getIntent(Context context, String eventId){
        Intent intent = new Intent(context, UpdateEventActivity.class);
        intent.putExtra(EXTRA_EVENT_ID, eventId);
        return intent;
    }

}
