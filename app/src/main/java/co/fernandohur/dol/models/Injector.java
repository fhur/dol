package co.fernandohur.dol.models;

import android.content.Context;

import co.fernandohur.dol.DOL;

public class Injector{

    /**
     * Injects a target object's Inject annotated attributes.
     * @param context a reference a context
     * @param target the class that will be injected
     */
    public static void inject(Context context, Object target){
        DOL app = (DOL)context.getApplicationContext();
        app.getObjectGraph().inject(target);
    }

    /**
     * Equivalent to {@link #inject(android.content.Context, Object) inject(context, object)} when
     * {@code context == object}
     * @param context a reference a context
     */
    public static void inject(Context context){
        inject(context, context);
    }
}