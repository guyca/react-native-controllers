package com.reactnativecontrollers.views;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.widget.FrameLayout;

import com.facebook.react.ReactInstanceManager;
import com.facebook.react.ReactRootView;
import com.facebook.react.modules.core.DefaultHardwareBackBtnHandler;


/**
 *
 * Created by guyc on 10/03/16.
 */
public class RctView extends FrameLayout implements DefaultHardwareBackBtnHandler {
    private static final String TAG = "RctView";

    public RctView(Context ctx, ReactInstanceManager rctInstanceManager, String componentName) {
        super(ctx);
        setLayoutParams(new FrameLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));

        ReactRootView root = new ReactRootView(ctx);
        root.startReactApplication(rctInstanceManager, componentName, null);
        addView(root);

        rctInstanceManager.onResume((Activity) ctx, this);
    }

    @Override
    public void invokeDefaultOnBackPressed() {
        Log.v(TAG, "invokeDefaultOnBackPressed");
    }
}

