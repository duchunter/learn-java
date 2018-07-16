import React from 'react';
import {
  StyleSheet, View, Image, Dimensions, Keyboard, Platform
} from 'react-native';
import {
  Container, Content, Form, Item, Input, Label, Toast, H1, Button, Text
} from 'native-base';
import TouchID from 'react-native-touch-id';

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
    TouchID.authenticate('Authenticate with fingerprint').then(success => {
      this.login();
    }).catch(error => {
      Toast.show({
        text: 'Something went wrong!',
        buttonText: 'Okay',
        type: 'danger',
        position: 'top'
      })
    });
  }

  render() {
    return (
      <Container>
        <Content padder>
          <View style={styles.container}>
            <H1> Welcome to Todo app </H1>

            {/* App image */}
            <Image
              source={require('../static/img/todo.png')}
              style={(() => {
                let h = this.state.dimensions.height - this.state.viewPadding;
                return {
                  height: h * 0.3,
                  width: h * 0.3
                }
              })()}
            />
          </View>

          <Form style={{marginBottom: 20}}>
            <Item floatingLabel>
              <Label> Username or Email (default: test) </Label>
              <Input onChangeText={(text) => this.setState({user: text})} />
            </Item>
            <Item floatingLabel>
              <Label> Password (default: 123) </Label>
              <Input
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
              <Text> Log in using Touch ID </Text>
            </Button>

            <Button block transparent small
              style={styles.button}
              onPress={() => this.props.navigation.navigate('Forgot Password')}
            >
              <Text> Forgot your password ? </Text>
            </Button>

            <Button block transparent small
              style={styles.button}
              onPress={() => this.props.navigation.navigate('Register')}
            >
              <Text> {"Don't have an account ?"} </Text>
            </Button>
          </View>
        </Content>
      </Container>
    );
  }
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center'
  },

  button: {
    margin: 5
  }
});
