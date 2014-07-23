package co.fernandohur.dol.ui;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.robot.ui.ListAdapter;

import java.util.List;

import butterknife.InjectView;
import co.fernandohur.dol.R;
import co.fernandohur.dol.models.DataEvent;
import co.fernandohur.dol.models.DataEventModel;

/**
 * Created by fernandinho on 7/19/14.
 */
public class DataEventAdapter extends ListAdapter<DataEventModel> {


    public DataEventAdapter(Context context) {
        super(context, R.layout.row_event);
    }

    @Override
    public ViewHolder<DataEventModel> getViewHolder(DataEventModel model, int pos, View view) {
        return new EventViewHolder();
    }

    public static class EventViewHolder implements ViewHolder<DataEventModel>{

        @InjectView(R.id.txtEventName) TextView txtEventName;

        @Override
        public void update(DataEventModel model, int pos) {
            txtEventName.setText(model.getEvent().getName());
        }
    }
}
