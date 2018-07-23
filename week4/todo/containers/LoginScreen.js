import React from 'react';
import {
  StyleSheet, View, Image, Dimensions, Keyboard,
  Platform, ImageBackground, Alert
} from 'react-native';
import {
  Container, Content, Form, Item, Input, Label, Toast, H1, Button, Text
} from 'native-base';
import LocalAuth from 'react-native-local-auth';
import TouchID from 'react-native-touch-id';
import * as Keychain from 'react-native-keychain';

const user = 'test';
const password = '123';

export default class LoginScreen extends React.Component {
  static navigationOptions = {
    header: null
  }

  constructor(props) {
    super(props);
    this.state = {
      dimensions: Dimensions.get('screen'),
      viewPadding: 0,
      user: '',
      password: '',
    }
  }

  componentDidMount() {
    // Used to resize image dynamically
    Dimensions.addEventListener('change', this.handleDimensionsChange);

    // Adjust padding so that input field always above keyboard
    const isAndroid = Platform.OS == "android";
    this.keyboardShowListener = Keyboard.addListener(
      isAndroid ? "keyboardDidShow" : "keyboardWillShow",
      this.handleKeyboardShow
    );

    // When keyboard hide, return padding to normal
    this.keyboardHideListener = Keyboard.addListener(
      isAndroid ? "keyboardDidHide" : "keyboardWillHide",
      this.handleKeyboardHide
    );
  }

  componentWillUnmount() {
    // Remove all listeners
    Dimensions.removeEventListener('change', this.handleDimensionsChange);
    this.keyboardShowListener.remove();
    this.keyboardHideListener.remove();
  }

  handleDimensionsChange = (newDimensions) => {
    this.setState({
      dimensions: newDimensions.screen
    });
  }

  handleKeyboardShow = (e) => {
    this.setState({
      viewPadding: e.endCoordinates.height
    });
  }

  handleKeyboardHide = (e) => {
    this.setState({
      viewPadding: 0
    });
  }

  // Validate user, password and login
  login = () => {
    if (this.state.user == user && this.state.password == password) {
      Keychain.setGenericPassword(this.state.user, this.state.password)
      this.props.navigation.navigate('App');
    } else {
      Toast.show({
        text: 'Wrong user name or password',
        buttonText: 'Okay',
        type: 'danger',
        position: 'top'
      });
    }
  }

  loginUsingTouchID = () => {
    TouchID.isSupported().then(() => {
      LocalAuth.authenticate({
          reason: 'Log in using passcode or fingerprint',
          falbackToPasscode: true,
          suppressEnterPassword: true
      }).then(() => {
        Keychain.getGenericPassword().then(credentials => {
          if (!credentials) {
            Alert.alert(
              'No credentials found',
              'It looks like this is your first time here,\n'
              + 'please log in using your credentials instead\n'
              + 'then you can start using this functionality\n',
              [{text: 'OK'}]
            );
            return;
          }

          if (credentials.username === user && credentials.password === password) {
            this.props.navigation.navigate('App');
          } else {
            Alert.alert(
              'Invalid credentials',
              'Credentials stored on this device is invalid\n',
              + 'Please log in using your credentials instead',
              [{text: 'OK'}]
            );
            Keychain.resetGenericPassword();
          }
        }).catch(err => {
          Toast.show({
            text: 'Something went wrong',
            buttonText: 'Okay',
            type: 'danger',
            position: 'top'
          });
        });
      }).catch(err => {
        Toast.show({
          text: err.code,
          buttonText: 'Okay',
          type: 'danger',
          position: 'top'
        });
      });
    }).catch(err => {
      Toast.show({
        text: 'This functionality is not supported on this device',
        buttonText: 'Okay',
        type: 'danger',
        position: 'top'
      });
    });
  }

  render() {
    return (
      <Container>
        <ImageBackground
          source={require('../static/img/bg.jpg')}
          style={{width: '100%', height: '100%'}}
        >
          <Content padder>
            <View style={styles.container}>
              <H1 style={styles.text}> Welcome to Todo app </H1>

              {/* App image */}
              <Image
                source={require('../static/img/todo.png')}
                style={(() => {
                  let h = this.state.dimensions.height - this.state.viewPadding;
                  return {
                    height: h * 0.3,
                    width: h * 0.3,
                    marginTop: 10
                  }
                })()}
              />
            </View>

            <Form style={{marginBottom: 20}}>
              <Item floatingLabel>
                <Label style={styles.text}>
                  Username or Email (default: test)
                </Label>
                <Input
                  style={styles.text}
                  onChangeText={(text) => this.setState({user: text})}
                />
              </Item>
              <Item floatingLabel>
                <Label style={styles.text}> Password (default: 123) </Label>
                <Input
                  style={styles.text}
                  onChangeText={(text) => this.setState({password: text})}
                  secureTextEntry={true}
                />
              </Item>
            </Form>

            <View style={styles.container}>
              <Button danger block
                style={styles.button}
                onPress={this.login}
              >
                <Text> Log in </Text>
              </Button>

              <Button block
                style={styles.button}
                onPress={this.loginUsingTouchID}
              >
                <Text> Log in using passcode or fingerprint </Text>
              </Button>

              <Button block transparent small
                style={styles.button}
                onPress={() => this.props.navigation.navigate('Forgot Password')}
              >
                <Text style={styles.text}> Forgot your password ? </Text>
              </Button>

              <Button block transparent small
                style={styles.button}
                onPress={() => this.props.navigation.navigate('Register')}
              >
                <Text style={styles.text}> {"Don't have an account ?"} </Text>
              </Button>
            </View>
          </Content>
        </ImageBackground>
      </Container>
    );
  }
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    marginTop: 5,
  },

  button: {
    margin: 5
  },

  text: {
    color: 'white'
  }
});
