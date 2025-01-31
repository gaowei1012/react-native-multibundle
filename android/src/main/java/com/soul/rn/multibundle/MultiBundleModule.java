// MultiBundleModule.java

package com.soul.rn.multibundle;

import android.app.Activity;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.soul.rn.multibundle.iface.Callback;
import com.soul.rn.multibundle.utils.FileUtil;
import com.soul.rn.multibundle.utils.RNConvert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MultiBundleModule extends ReactContextBaseJavaModule {
    public static final String NAME = "MultiBundle";

    public MultiBundleModule(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public Map<String, Object> getConstants() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("prefix", MultiBundle.PREFIX);
        return map;
    }

    @ReactMethod
    public void openComponent(String moduleName, Boolean finish, @Nullable Integer statusBarMode, @Nullable ReadableMap params) {
        Activity activity = getCurrentActivity();
        if (activity == null) return;
        MultiBundle.openComponent(activity, moduleName, finish, statusBarMode, params);
    }

    @ReactMethod
    public void getAllComponent(Promise promise) {
        WritableArray array = Arguments.createArray();
        ArrayList<RNDBHelper.Result> results = RNDBHelper.selectAll();
        for (RNDBHelper.Result result : results) {
            array.pushMap((WritableMap) RNConvert.convert(result));
        }
        promise.resolve(array);
    }

    @ReactMethod
    public void checkUpdate(Promise promise) {
        MultiBundle.checkUpdate(getCurrentActivity(), new Callback() {
            @Override
            public void onSuccess(Object result) {
                promise.resolve(RNConvert.convert(result));
            }

            @Override
            public void onError(String errorMsg) {
                promise.reject(null, errorMsg);
            }
        });
    }

    @ReactMethod
    public void getExternalFilesDir(Promise promise) {
        promise.resolve(FileUtil.getExternalFilesDir(this.getReactApplicationContext()));
    }

    @ReactMethod
    public void goBack() {
        Activity activity = getCurrentActivity();
        if (activity != null && !activity.isFinishing()) {
            getCurrentActivity().finish();
        }
    }

    @ReactMethod
    public void log(String message) {
        Log.i("MultiBundle", message);
    }

    @ReactMethod
    public void addListener(String eventName) {
        // Set up any upstream listeners or background tasks as necessary
    }

    @ReactMethod
    public void removeListeners(Integer count) {
        // Remove upstream listeners, stop unnecessary background tasks
    }

    @Override
    @NonNull
    public String getName() {
        return NAME;
    }
}
