import React, { Component } from 'react'
import { requireNativeComponent, ViewPropTypes, StyleSheet, UIManager, findNodeHandle } from 'react-native'
import PropTypes from 'prop-types'

var viewProps = {
  name: 'RCVideoPlayer',
  propTypes: {
    url: PropTypes.string,
    onStart: PropTypes.func,
    onFinish: PropTypes.func,
    onPause: PropTypes.func,
    ...ViewPropTypes,
  }
}

const style = StyleSheet.create(
  {
    video: {
      width: '100%',
      flex: 1
    }
  }
)

const RNVideoPlayerView =  requireNativeComponent('RNVideoPlayerView', viewProps)

class VideoPlayerView extends Component {

  // Prop type for component
  static propTypes = {
    url: PropTypes.string,
    onFinish: PropTypes.func,
    onPause: PropTypes.func,
    onStart: PropTypes.func
  }

  // Default prop for component
  static defaultProps = {
    url: '',
    onFinish: () => {},
    onPause: () => {},
    onStart: () => {}
  }

  /**
   * start video player from Native UI component
   */
  startVideoPlayer = () => {
    UIManager.dispatchViewManagerCommand(
      findNodeHandle(this),
      UIManager.RNVideoPlayerView.Commands.startVideoPlayer,
      [],
    )
  }
  /**
   * pause video player from Native UI component
   */
  pauseVideoPlayer = () => {
    UIManager.dispatchViewManagerCommand(
      findNodeHandle(this),
      UIManager.RNVideoPlayerView.Commands.pauseVideoPlayer,
      [],
    )
  }

  /**
   * show or hide controls video player from Native Ui component
   * @param {boolean} isShowControls
   * if isShowControls is true: will show controls
   * else will hide  controls
   */
  onToggleControlsVideoPlayer = (isShowControls) => {
    UIManager.dispatchViewManagerCommand(
      findNodeHandle(this),
      UIManager.RNVideoPlayerView.Commands.onToggleControlsVideoPlayer,
      [isShowControls],
    )
  }

  render() {
    const {
      url,
      onStart,
      onFinish,
      onPause
    } = this.props
    return(
      <RNVideoPlayerView
        style={style.video}
        url={url}
        onStart={onStart}
        onFinish={onFinish}
        onPause={onPause}
      />
    )
  }
}

export default VideoPlayerView