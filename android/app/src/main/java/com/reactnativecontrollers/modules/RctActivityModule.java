package com.reactnativecontrollers.modules;

import android.app.Activity;
import android.content.Intent;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.reactnativecontrollers.activities.RctActivity;
import com.reactnativecontrollers.utils.ContextProvider;

/**
 *
 * Created by guyc on 10/03/16.
 */
public class RctActivityModule extends ReactContextBaseJavaModule {
    public static final String REACT_CLASS = "RctActivity";

    public RctActivityModule(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    @ReactMethod @SuppressWarnings("unused")
    public void startActivity(String componentName) {
        Activity context = ContextProvider.getActivityContext();
        if (context != null && !context.isFinishing()) {
            Intent rctActivityIntent = new Intent(context, RctActivity.class);
            rctActivityIntent.putExtra(RctActivity.EXTRA_COMPONENT_NAME, componentName);
            context.startActivity(rctActivityIntent);
        }
    }
}
