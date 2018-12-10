package com.shellmonger.reactnative.video;

import android.util.Log;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;

public class VideoPlayerModule extends ReactContextBaseJavaModule {

  private static final String REACT_CLASS = "RNVideoPlayerModule";
  private VideoPlayerViewManager mVideoPlayerViewManager;

  public VideoPlayerModule(ReactApplicationContext reactContext, VideoPlayerViewManager videoPlayerViewManager) {
    super(reactContext);
    this.mVideoPlayerViewManager = videoPlayerViewManager;
  }

  @Override
  public String getName() {
    return REACT_CLASS;
  }

}
