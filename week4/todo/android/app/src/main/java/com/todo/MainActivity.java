package com.todo;

import com.facebook.react.ReactActivity;
import io.tradle.react.LocalAuthPackage;
import com.facebook.react.ReactPackage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends ReactActivity {

    /**
     * Returns the name of the main component registered from JavaScript.
     * This is used to schedule rendering of the component.
     */
    @Override
    protected String getMainComponentName() {
        return "todo";
    }

    protected List<ReactPackage> getPackages() {
        return Arrays.<ReactPackage>asList(
                new LocalAuthPackage());
    }
}
