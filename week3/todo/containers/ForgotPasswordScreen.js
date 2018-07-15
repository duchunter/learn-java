import React from 'react';
import {
  StyleSheet, Text, View, TextInput, Button
} from 'react-native';

export default class ForgotPasswordScreen extends React.Component {
  static navigationOptions = {
    title: 'Recover password'
  }

  constructor(props) {
    super(props);
    this.state = {
      email: ''
    }
  }

  sendEmail = () => {
    if (this.state.email.trim()) {
      alert('This is for testing only, nothing will happen');
    } else {
      alert('Please enter your email');
    }
  }

  render() {
    return (
      <View style={styles.container}>
        <View style={{ width: '80%' }} >
          <Text style={{fontSize: 18}}>
            Please enter your email address to search for your account
          </Text>
        </View>

        <TextInput
          style={styles.input}
          placeholder="Email"
          onChangeText={(text) => this.setState({email: text})}
          onSubmitEditing={this.sendEmail}
        />

        <Button
          title="Search"
          color="blue"
          onPress={this.sendEmail}
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
    margin: 5
  }
});
