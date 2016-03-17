package com.reactnativecontrollers.activities;

import android.content.Intent;
import android.os.Bundle;

import com.facebook.react.ReactInstanceManager;
import com.facebook.react.ReactPackage;
import com.facebook.react.shell.MainReactPackage;
import com.reactnativecontrollers.core.RctManager;
import com.reactnativecontrollers.packages.RCCPackage;
import com.reactnativecontrollers.utils.ContextProvider;

import java.util.Arrays;
import java.util.List;

/**
 *
 * Created by guyc on 10/03/16.
 */
public class RctActivity extends ReactActivity {
    public static final String EXTRA_COMPONENT_NAME = "componentName";

    private String mComponentName = null;

    public void setComponentName(String componentName) {
        mComponentName = componentName;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        if (mComponentName == null) {
            Intent intent = getIntent();
            assert intent != null;
            mComponentName = intent.getStringExtra(EXTRA_COMPONENT_NAME);
            assert mComponentName != null;
        }

        super.onCreate(savedInstanceState);
    }

    @Override
    protected String getMainComponentName() {
        return mComponentName;
    }

    /**
     * Returns whether dev mode should be enabled.
     * This enables e.g. the dev menu.
     */
    @Override
    protected boolean getUseDeveloperSupport() {
        return false;
    }

    /**
     * A list of packages used by the app. If the app uses additional views
     * or modules besides the default ones, add more packages here.
     */
    @Override
    protected List<ReactPackage> getPackages() {
        return Arrays.asList(
                new MainReactPackage(),
                new RCCPackage()
        );
    }

    @Override
    protected ReactInstanceManager createReactInstanceManager() {
        return getReactInstanceManager();
    }

    protected ReactInstanceManager getReactInstanceManager() {
        RctManager rctManager = RctManager.getInstance();
        if (!rctManager.isInitialized()) {
            rctManager.init(this, mComponentName, getPackages());
        }
        return rctManager.getReactInstanceManager();
    }

    @Override
    protected void onResume() {
        ContextProvider.setActivityContext(this);
        super.onResume();
    }

    @Override
    protected void onPause() {
        ContextProvider.clearActivityContext();
        super.onPause();
    }
}
