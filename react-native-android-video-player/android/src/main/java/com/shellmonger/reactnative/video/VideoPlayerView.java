package com.shellmonger.reactnative.video;

import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import com.halilibo.bettervideoplayer.BetterVideoCallback;
import com.halilibo.bettervideoplayer.BetterVideoPlayer;
import com.shellmonger.reactnative.R;

public class VideoPlayerView extends LinearLayout implements BetterVideoCallback {
  private ReactContext mContext;
  private BetterVideoPlayer player;
  private String mUrlPath = "";


  public VideoPlayerView(ThemedReactContext context) {
    super(context);
    this.mContext = context;
    init();
  }

  public void init() {
    View view = inflate(this.mContext, R.layout.video_player, this);
    player = view.findViewById(R.id.player);
    player.setCallback(this);
  }

  @Override
  public void onStarted(BetterVideoPlayer player) {
    WritableMap event = Arguments.createMap();
    event.putString("message", "MyMessage test event");

    mContext.getJSModule(RCTEventEmitter.class).
        receiveEvent(getId(), "onStart", event);

  }

  @Override
  public void onPaused(BetterVideoPlayer player) {
    WritableMap event = Arguments.createMap();
    event.putInt("loaded", 123);
    event.putInt("total", 567);

    mContext.getJSModule(RCTEventEmitter.class).
        receiveEvent(getId(), "onPause", event);

  }

  @Override
  public void onPreparing(BetterVideoPlayer player) {

  }

  @Override
  public void onPrepared(BetterVideoPlayer player) {

  }

  @Override
  public void onBuffering(int percent) {

  }

  @Override
  public void onError(BetterVideoPlayer player, Exception e) {

  }

  @Override
  public void onCompletion(BetterVideoPlayer player) {
    WritableMap event = Arguments.createMap();
    event.putString("AAAA", "CCCC");

    mContext.getJSModule(RCTEventEmitter.class).
        receiveEvent(getId(), "onFinish", event);
  }

  @Override
  public void onToggleControls(BetterVideoPlayer player, boolean isShowing) {

  }

  public String getmUrlPath() {
    return mUrlPath;
  }

  public void setmUrlPath(String mUrlPath) {
    player.setSource(Uri.parse(mUrlPath));
    this.mUrlPath = mUrlPath;
  }

  /**
   * Start video player
   */
  protected void startVideoPlayer() {
    player.start();
  }

  protected void pauseVideoPlayer() {
    player.pause();
  }

  protected void onToggleControlsVideoPlayer(boolean isShowControls) {
    Log.i("VideoPlayer Controls", ""+isShowControls);
    if (isShowControls) {
      player.showControls();
    } else {
      player.hideControls();
    }
  }
}
