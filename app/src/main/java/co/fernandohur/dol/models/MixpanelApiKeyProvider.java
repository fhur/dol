package co.fernandohur.dol.models;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by fernandinho on 7/24/14.
 */
public interface MixpanelApiKeyProvider {

    public void setApiKey(String apiKey);
    public String getApiKey();

    public static class DefaultProvider implements MixpanelApiKeyProvider{

        public final static String PREF_LOCATION = "storage.mixpanel.apikey";
        public final static String KEY_APIKEY = "storage.mixpanel.keys.apikey";
        private SharedPreferences prefs;

        public DefaultProvider(Context context){
            this.prefs = context.getSharedPreferences(PREF_LOCATION, Context.MODE_PRIVATE);
        }

        @Override
        public void setApiKey(String apiKey) {
            this.prefs.edit().putString(KEY_APIKEY, apiKey).commit();
        }

        @Override
        public String getApiKey() {
            return this.prefs.getString(KEY_APIKEY, null);
        }
    }
}
