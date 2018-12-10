
package com.shellmonger.reactnative;

import android.util.Log;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;
import com.facebook.react.bridge.JavaScriptModule;
import com.shellmonger.reactnative.video.VideoPlayerModule;
import com.shellmonger.reactnative.video.VideoPlayerViewManager;
import com.shellmonger.reactnative.video.VideoViewManager;


public class RNReactNativeAndroidVideoPlayerPackage implements ReactPackage {

  private VideoPlayerViewManager mVideoPlayerViewManager;

  @Override
  public List<NativeModule> createNativeModules(ReactApplicationContext reactContext) {
    Log.i("Video Player", "createNativeModules");
  List<NativeModule> modules = new ArrayList<>();
    modules.add(new RNReactNativeAndroidVideoPlayerModule(reactContext));
    modules.add(new VideoPlayerModule(reactContext, mVideoPlayerViewManager));
    return modules;
  }

  // Deprecated from RN 0.47
  public List<Class<? extends JavaScriptModule>> createJSModules() {
    return Collections.emptyList();
  }

  @Override
  public List<ViewManager> createViewManagers(ReactApplicationContext reactContext) {
    Log.i("Video Player 22", "createViewManagers");
    mVideoPlayerViewManager = new VideoPlayerViewManager();
    List<ViewManager> views = new ArrayList<>();
    views.add(mVideoPlayerViewManager);
    views.add(new VideoViewManager());
    return views;
  }
}