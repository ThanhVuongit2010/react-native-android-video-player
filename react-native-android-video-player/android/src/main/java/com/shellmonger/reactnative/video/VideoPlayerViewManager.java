package com.shellmonger.reactnative.video;

import android.support.annotation.Nullable;
import android.util.Log;

import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.common.MapBuilder;

import java.util.Map;


public class VideoPlayerViewManager extends SimpleViewManager<VideoPlayerView> {
  public static final String REACT_CLASS = "RNVideoPlayerView";
  private VideoPlayerView mVideoPlayerView;
  private static final int VIDEO_START = 1;
  private static final int VIDEO_PAUSE = 2;
  private static final int TOGGLE_CONTROLS = 3;

  @Override
  public String getName() {
    return REACT_CLASS;
  }

  @Override
  protected VideoPlayerView createViewInstance(ThemedReactContext reactContext) {
    Log.i("createViewInstance", "Vuong Ok");
    this.mVideoPlayerView = new VideoPlayerView(reactContext);
    return this.mVideoPlayerView;
  }

  @ReactProp(name = "url")
  public void setVideoPath(VideoPlayerView videoPlayerView, String urlPath) {
    videoPlayerView.setmUrlPath(urlPath);
  }

  @Override
  public  @Nullable
  Map getExportedCustomDirectEventTypeConstants() {
    return MapBuilder.of(
        "onStart",
        MapBuilder.of("registrationName", "onStart"),
        "onFinish",
        MapBuilder.of("registrationName", "onFinish"),
        "onPause",
        MapBuilder.of("registrationName", "onPause")
    );
  }

  @Override
  public void receiveCommand(VideoPlayerView root, int commandId, @javax.annotation.Nullable ReadableArray args) {
    Log.i("VideoPlayer Command", ""+commandId);
    Log.i("VideoPlayer args", args.toString());
    switch (commandId) {
      case VIDEO_START: {
        this.mVideoPlayerView.startVideoPlayer();
        return;
      }
      case VIDEO_PAUSE: {
        this.mVideoPlayerView.pauseVideoPlayer();
        return;
      }

      case TOGGLE_CONTROLS: {
        this.mVideoPlayerView.onToggleControlsVideoPlayer(args.getBoolean(0));
        return;
      }

      default:
        throw new IllegalArgumentException(String.format(
            "Unsupported command %d received by %s.",
            commandId,
            getClass().getSimpleName()));
    }
  }

  @javax.annotation.Nullable
  @Override
  public Map<String, Integer> getCommandsMap() {
    Log.d("React"," View manager getCommandsMap:");
    return MapBuilder.of(
        "startVideoPlayer",
        VIDEO_START,
        "pauseVideoPlayer",
        VIDEO_PAUSE,
        "onToggleControlsVideoPlayer",
        TOGGLE_CONTROLS);
  }
}
