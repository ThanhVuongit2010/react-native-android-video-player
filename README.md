
# react-native-react-native-android-video-player

## Getting started

`$ npm install react-native-react-native-android-video-player --save`

### Mostly automatic installation

`$ react-native link react-native-react-native-android-video-player`

### Open file android/app/build.gradle
	- Insert the following lines in `android/app/build.gradle`:
		repositories {
      maven {
          url 'https://jitpack.io'
      }
 		}

### Manual installation

#### Android

1. Open up `android/app/src/main/java/[...]/MainActivity.java`
  - Add `import com.shellmonger.reactnative.RNReactNativeAndroidVideoPlayerPackage;` to the imports at the top of the file
  - Add `new RNReactNativeAndroidVideoPlayerPackage()` to the list returned by the `getPackages()` method
2. Append the following lines to `android/settings.gradle`:
  	```
  	include ':react-native-react-native-android-video-player'
  	project(':react-native-react-native-android-video-player').projectDir = new File(rootProject.projectDir, 	'../node_modules/react-native-react-native-android-video-player/android')
  	```
3. Insert the following lines inside the dependencies block in `android/app/build.gradle`:
  	```
      compile project(':react-native-react-native-android-video-player')
  	```


## Usage
```javascript
import { VideoPlayerView } from 'react-native-react-native-android-video-player'
class VideoScreen extends Component {
  constructor(props) {
    super(props)
    this.videoPlayerViewRef = React.createRef()
  }

  handleStart = (event) => {
    console.log('handleStart: ', event.nativeEvent)
  }

  handleFinish = (event) => {
    console.log('handleFinish: ', event.nativeEvent)
  }

  handlePause = (event) => {
    console.log('handlePause: ', event.nativeEvent)
  }

  handleStartVideoPlayer = () => {
    console.log('handleStartVideoPlayer: ', this.videoPlayerViewRef.current)
    this.videoPlayerViewRef.current.startVideoPlayer()
  }

  handlePauseVideoPlayer = () => {
    this.videoPlayerViewRef.current.pauseVideoPlayer()
  }

  handleShowControlsVideoPlayer = () => {
    this.videoPlayerViewRef.current.onToggleControlsVideoPlayer(true)
  }

  handleHideControlsVideoPlayer = () => {
    this.videoPlayerViewRef.current.onToggleControlsVideoPlayer(false)
  }

  render() {
    return(
      <View style={style.wrapper} >
        <VideoPlayerView
          ref={this.videoPlayerViewRef}
          style={style.video}
          url='http://clips.vorwaerts-gmbh.de/VfE_html5.mp4'
          onStart={this.handleStart}
          onFinish={this.handleFinish}
          onPause={this.handlePause}
        />
        <View style={style.wrapperButton}>
          <Button
            text='Start'
            onPress={this.handleStartVideoPlayer}
            bgColor={COLORS.lightBlue}
            color={COLORS.white}
          />

          <View style={style.button} >
            <Button
              text='Pause'
              onPress={this.handlePauseVideoPlayer}
              bgColor={COLORS.lightBlue}
              color={COLORS.white}
            />
          </View>

          <Button
            text='Hide controls'
            onPress={this.handleHideControlsVideoPlayer}
            bgColor={COLORS.lightBlue}
            color={COLORS.white}
          />
        </View>
      </View>
    )
  }
}
```
### Props
	- url: Path video `Ex: http://clips.vorwaerts-gmbh.de/VfE_html5.mp4`
	- onStart: Callback when start video
	- onFinish: Callback when finish video
	- onPause: Callback when pause video

### Method
	- startVideoPlayer
	- pauseVideoPlayer
	- onToggleControlsVideoPlayer
