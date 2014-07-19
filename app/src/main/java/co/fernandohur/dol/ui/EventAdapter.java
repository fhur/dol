package co.fernandohur.dol.ui;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.robot.ui.ListAdapter;

import butterknife.InjectView;
import co.fernandohur.dol.R;
import co.fernandohur.dol.models.Event;

/**
 * Created by fernandinho on 7/19/14.
 */
public class EventAdapter extends ListAdapter<Event> {


    public EventAdapter(Context context) {
        super(context, R.layout.row_event);
    }

    @Override
    public ViewHolder<Event> getViewHolder(Event model, int pos, View view) {
        return new EventViewHolder();
    }

    public static class EventViewHolder implements ViewHolder<Event>{

        @InjectView(R.id.txtEventName) TextView txtEventName;

        @Override
        public void update(Event event, int pos) {
            txtEventName.setText(event.getName());
        }
    }
}
