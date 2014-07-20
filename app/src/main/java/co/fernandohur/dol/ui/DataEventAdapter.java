package co.fernandohur.dol.ui;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.robot.ui.ListAdapter;

import butterknife.InjectView;
import co.fernandohur.dol.R;
import co.fernandohur.dol.models.DataEvent;

/**
 * Created by fernandinho on 7/19/14.
 */
public class DataEventAdapter extends ListAdapter<DataEvent> {


    public DataEventAdapter(Context context) {
        super(context, R.layout.row_event);
    }

    @Override
    public ViewHolder<DataEvent> getViewHolder(DataEvent model, int pos, View view) {
        return new EventViewHolder();
    }

    public static class EventViewHolder implements ViewHolder<DataEvent>{

        @InjectView(R.id.txtEventName) TextView txtEventName;

        @Override
        public void update(DataEvent dataEvent, int pos) {
            txtEventName.setText(dataEvent.getName());
        }
    }
}
