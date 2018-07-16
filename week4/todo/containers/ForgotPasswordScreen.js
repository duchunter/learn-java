import React from 'react';
import {
  StyleSheet, Text, View, TextInput, Button
} from 'react-native';
import {Toast} from 'native-base';

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
      Toast.show({
        text: 'This is for testing only, nothing will happen',
        buttonText: 'Okay',
        type: 'success',
        position: 'top'
      });
    } else {
      Toast.show({
        text: 'Please enter your email',
        buttonText: 'Okay',
        type: 'danger',
        position: 'top'
      });
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
