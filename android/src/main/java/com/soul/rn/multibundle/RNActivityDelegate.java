package com.soul.rn.multibundle;

import android.app.Activity;
import android.os.Bundle;

import com.facebook.react.ReactActivity;
import com.facebook.react.ReactActivityDelegate;
import com.facebook.react.ReactDelegate;
import com.facebook.react.ReactNativeHost;
import com.facebook.react.ReactRootView;
import com.soul.rn.multibundle.utils.SystemDetect;

import java.lang.reflect.Field;

public class RNActivityDelegate extends ReactActivityDelegate {
  private ReactDelegate mReactDelegate;
  private ReactNativeHost mReactNativeHost;

  public RNActivityDelegate(Activity activity, String mainComponentName) {
    super(activity, mainComponentName);
    mReactNativeHost = getReactNativeHost();
  }

  public RNActivityDelegate(ReactActivity activity, String mainComponentName) {
    super(activity, mainComponentName);
    mReactNativeHost = getReactNativeHost();
  }

  @Override
  protected void onCreate(Bundle bundle) {
    String moduleName = bundle.getString("moduleName");
    Bundle params = bundle.getBundle("params");
    if (SystemDetect.isMIUI(this.getContext())) {
      params.putString("profile","UserHandle{0}");
    }
    if (mReactDelegate == null) {
      mReactDelegate = new ReactDelegate(this.getPlainActivity(), mReactNativeHost, moduleName, params) {
        protected ReactRootView createRootView() {
          return RNActivityDelegate.this.createRootView();
        }
      };
    }

    try {
      // 反射替换父类属性
      Field privateReactDelegateField = ReactActivityDelegate.class.getDeclaredField("mReactDelegate");
      privateReactDelegateField.setAccessible(true);
      privateReactDelegateField.set(this, mReactDelegate);
    } catch (Exception err) {
      err.printStackTrace();
    }
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();
  }

  @Override
  protected void onResume() {
    super.onResume();
  }

  @Override
  protected void onPause() {
    super.onPause();
  }

  @Override
  protected void loadApp(String appKey) {
    super.loadApp(appKey);
  }

  @Override
  protected ReactNativeHost getReactNativeHost() {
    if (MultiBundle.mReactNativeHostHolder != null) {
      return MultiBundle.mReactNativeHostHolder.getReactNativeHost();
    }
    return null;
  }

  public void loadAppExternal(String appKey) {
    mReactDelegate.loadApp(appKey);
  }

  public ReactRootView getReactRootView() {
    if (mReactDelegate == null) return null;
    return mReactDelegate.getReactRootView();
  }

}
