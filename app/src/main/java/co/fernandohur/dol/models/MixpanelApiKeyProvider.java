package co.fernandohur.dol.models;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by fernandinho on 7/24/14.
 */
public interface MixpanelApiKeyProvider {

    /**
     *
     * @return the mixpanel api key set in settings.
     * @throws java.lang.IllegalStateException If there is no key configured
     */
    public String getApiKey();

    public static class DefaultProvider implements MixpanelApiKeyProvider{

        public final static String KEY_APIKEY = "mixpanel_api_key";
        private SharedPreferences prefs;

        public DefaultProvider(Context context){
            this.prefs = PreferenceManager.getDefaultSharedPreferences(context);
        }

        @Override
        public String getApiKey() {
            String key = this.prefs.getString(KEY_APIKEY, null);
            if(key == null){
                throw new IllegalStateException("key == null, make sure you configure it before calling getApiKey");
            }
            return key;
        }
    }
}
