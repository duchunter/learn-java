import React from 'react';
import {
  StyleSheet, Text, View, TextInput, Button, TouchableOpacity
} from 'react-native';

export default class RegisterScreen extends React.Component {
  static navigationOptions = {
    title: 'Create new account'
  }

  constructor(props) {
    super(props);
    this.state = {
      email: '',
      user: '',
      password: '',
      confirmPassword: ''
    }
  }

  register = () => {
    alert('This is for testing only, please login using default info');
  }

  render() {
    return (
      <View style={styles.container}>
        <Text style={{ fontSize: 18, marginBottom: 10 }}>
          Enter your info
        </Text>

        <TextInput
          style={styles.input}
          placeholder="Email"
          onChangeText={(text) => this.setState({email: text})}
        />
        <TextInput
          style={styles.input}
          placeholder="Username"
          onChangeText={(text) => this.setState({user: text})}
        />
        <TextInput
          style={styles.input}
          placeholder="Password"
          secureTextEntry={true}
          onChangeText={(text) => this.setState({password: text})}
        />
        <TextInput
          style={styles.input}
          placeholder="Confirm password"
          secureTextEntry={true}
          onChangeText={(text) => this.setState({confirmPassword: text})}
        />

        <Button
          title="Register"
          color="orange"
          onPress={this.register}
        />

        <TouchableOpacity
          style={{ marginTop: 10 }}
          onPress={() => this.props.navigation.navigate('Login')}
        >
          <Text style={{ color: 'blue' }}> Already have an account ? </Text>
        </TouchableOpacity>
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
    height: 40,
    padding: 10,
    fontSize: 18,
    borderWidth: 1,
    borderColor: '#ccc',
    borderRadius: 4,
    marginBottom: 5
  }
});
