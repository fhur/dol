package co.fernandohur.dol.ui;

import android.content.Context;
import android.util.Pair;
import android.view.View;
import android.widget.TextView;

import com.robot.ui.ListAdapter;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import butterknife.InjectView;
import co.fernandohur.dol.R;

/**
 * Created by fernandinho on 7/19/14.
 */
public class KeyValueAdapter extends ListAdapter<Pair<String, String>> {


    public KeyValueAdapter(Context context) {
        super(context, R.layout.row_key_value);
    }

    @Override
    public ViewHolder<Pair<String, String>> getViewHolder(Pair<String, String> model, int pos, View view) {
        return null;
    }

    public static class KeyValueViewHolder implements ViewHolder<Pair<String, String>>{

        @InjectView(R.id.txtKey) TextView txtKey;
        @InjectView(R.id.txtValue) TextView txtVal;

        @Override
        public void update(Pair<String, String> pair, int pos) {
            txtKey.setText(pair.first);
            txtVal.setText(pair.second);
        }
    }

    /**
     * @return all Key-Value pairs as a Map instance
     */
    public Map<String, String> getMap(){
        Map<String, String> result = new HashMap<String, String>(getCount());
        for(int i=0; i<getCount(); i++){
            Pair<String, String> kvPair = getItem(i);
            result.put(kvPair.first, kvPair.second);
        }
        return result;
    }
}
