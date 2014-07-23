package co.fernandohur.dol.ui;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.widget.EditText;

import butterknife.ButterKnife;
import butterknife.InjectView;
import co.fernandohur.dol.R;

/**
 * Created by fernandinho on 7/23/14.
 */
public class DialogAddKeyValue extends AlertDialog implements DialogInterface.OnClickListener{

    @InjectView(R.id.txtKey) EditText txtKey;
    @InjectView(R.id.txtValue) EditText txtVal;

    private OnAddKeyValueListener listener;

    public DialogAddKeyValue(Activity context, OnAddKeyValueListener listener) {
        super(context);
        View view = getLayoutInflater().inflate(R.layout.dialog_key_value, null);
        setView(view);
        setButton(BUTTON_POSITIVE, "Add", this);
        ButterKnife.inject(this, view);
        this.listener = listener;
    }

    @Override
    protected void onStart() {
        super.onStart();
        // Clear all fields before showing the dialog
        txtKey.setText("");
        txtVal.setText("");
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {
        if(txtVal.getText().length() == 0){
            txtVal.requestFocus();
        }
        else if(txtKey.getText().length() < 2){
            txtKey.requestFocus();
        }
        else{
            dismiss();
            listener.onAddKeyValue(getKey(), getVal());
        }
    }

    public String getKey() {
        return txtKey.getText().toString();
    }

    public String getVal() {
        return txtVal.getText().toString();
    }

    public interface OnAddKeyValueListener{
        public void onAddKeyValue(String key, String value);
    }
}
