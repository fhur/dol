package co.fernandohur.dol.ui;

import android.content.Context;
import android.util.Pair;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.robot.ui.ListAdapter;

import butterknife.InjectView;
import co.fernandohur.dol.R;
import co.fernandohur.dol.models.DataEvent;
import co.fernandohur.dol.models.DataEventModel;

/**
 * Created by fernandinho on 7/23/14.
 */
public class EventAttributeAdapter extends ListAdapter<Pair<String, String>> {


    public EventAttributeAdapter(Context context) {
        super(context, R.layout.row_attributes);
    }

    @Override
    public ViewHolder<Pair<String, String>> getViewHolder(Pair<String, String> model, int pos, View view) {
        return new AttrViewHolder();
    }

    public static class AttrViewHolder implements ViewHolder<Pair<String, String>>{

        @InjectView(R.id.txtValue) EditText txtValue;
        @InjectView(R.id.txtKey) TextView txtKey;

        @Override
        public void update(Pair<String, String> keyValue, int pos) {
            txtKey.setText(keyValue.first);
            txtValue.setText(keyValue.second);
        }
    }
}
