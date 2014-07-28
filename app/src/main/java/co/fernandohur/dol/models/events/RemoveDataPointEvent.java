package co.fernandohur.dol.models.events;

import com.robot.DataEvent;

import co.fernandohur.dol.models.DataEventModel;

/**
 * Created by fernandinho on 7/28/14.
 */
public class RemoveDataPointEvent extends DataEvent<DataEventModel>{

    /**
     * Created a new instance of DataEvent and sets the data that this event will carry.
     *
     * @param data the data to carry
     * @see #getData()
     */
    public RemoveDataPointEvent(DataEventModel data) {
        super(data);
    }
}
