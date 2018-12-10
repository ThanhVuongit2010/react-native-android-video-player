package com.shellmonger.reactnative.video;

import android.net.Uri;
import android.widget.VideoView;

import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;

public class VideoViewManager extends SimpleViewManager<VideoView> {

  public static final String REACT_CLASS = "RCVideoView";
  @Override
  public String getName() {
    return REACT_CLASS;
  }

  @Override
  protected VideoView createViewInstance(ThemedReactContext reactContext) {
    VideoView videoView = new VideoView(reactContext);
    return videoView;
  }

  @ReactProp(name="url")
  public void setVideoPath(VideoView videoView, String urlPath) {
    Uri uri = Uri.parse(urlPath);
    videoView.setVideoURI(uri);
    videoView.start();
  }
}
