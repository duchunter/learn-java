import React from 'react';
import {
  StyleSheet, Text, View, TextInput, Button,
  Image, Dimensions, Keyboard, Platform
} from 'react-native';

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

  // Handle username typing
  handleUsernameTyping = (text) => {
    this.setState({
      user: text
    });
  }

  // Handle password typing
  handlePasswordTyping = (text) => {
    this.setState({
      password: text
    });
  }

  // Validate user, password and login
  login() {
    if (this.state.user == user && this.state.password == password) {
      this.props.navigation.navigate('App');
    } else {
      alert('Wrong username or password');
    }
  }

  render() {
    return (
      <View style={styles.container}>
        <Text style={styles.header}> Welcome to Todo app </Text>

        {/* App image */}
        <Image
          source={require('../static/img/todo.png')}
          style={(() => {
            let h = this.state.dimensions.height - this.state.viewPadding;
            return {
              height: h * 0.3,
              width: h * 0.3,
              marginBottom: 10
            }
          })()}
        />

        {/* Log in input fields */}
        <TextInput
          style={styles.input}
          placeholder="Username or Email (default: test)"
          onChangeText={this.handleUsernameTyping}
        />
        <TextInput
          style={styles.input}
          placeholder="Password (default: 123)"
          secureTextEntry={true}
          onChangeText={this.handlePasswordTyping}
        />
        <Button
          title="Login"
          color="orange"
          onPress={() => this.login()}
        />
      </View>
    );
  }
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    backgroundColor: 'white'
  },

  input: {
    width: '80%',
    height: 50,
    padding: 10,
    fontSize: 18,
    borderWidth: 1,
    borderColor: '#ccc',
    borderRadius: 4,
    marginBottom: 5
  },

  header: {
    fontSize: 25
  }
});
