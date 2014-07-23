package co.fernandohur.dol.activities;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Pair;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ListView;

import com.squareup.otto.Bus;

import java.util.Map;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import co.fernandohur.dol.R;
import co.fernandohur.dol.models.events.CreateDataPointEvent;
import co.fernandohur.dol.ui.DialogAddKeyValue;
import co.fernandohur.dol.ui.KeyValueAdapter;

public class CreateEventActivity extends BaseActivity implements DialogAddKeyValue.OnAddKeyValueListener {

    @InjectView(R.id.txtEventName) EditText txtEventName;
    @InjectView(R.id.listViewKeyValues) ListView listViewKeyValues;

    private DialogAddKeyValue dialogAddKeyValue;

    KeyValueAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_event);

        ButterKnife.inject(this);

        adapter = new KeyValueAdapter(this);
        listViewKeyValues.setAdapter(adapter);

        dialogAddKeyValue = new DialogAddKeyValue(this, this);
    }

    @OnClick(R.id.btnCreateEvent)
    public void onCreateEvent(){
        String eventName = txtEventName.getText().toString();
        Map<String, String> map = adapter.getMap();
        postEvent(new CreateDataPointEvent(eventName, map));
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

    public static Intent getIntent(Context context){
        return new Intent(context, CreateEventActivity.class);
    }

}
