import PropTypes from 'prop-types';
import { requireNativeComponent, ViewPropTypes, NativeModules } from 'react-native';

var viewProps = {
  name: 'RCVideoPlayer',
  propTypes: {
    url: PropTypes.string,
    ...ViewPropTypes,
  }
}

export const VideoView =  requireNativeComponent('RNVideoView', viewProps);
export const ReactNativeAndroidVideoPlayer = NativeModules.RNReactNativeAndroidVideoPlayer;

export { default as VideoPlayerView } from './src/components/video-player'
