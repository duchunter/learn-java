import React from 'react';
import {
  StyleSheet, ActivityIndicator, StatusBar, View, Text
} from 'react-native';

export default class AuthLoadingScreen extends React.Component {
  constructor(props) {
    super(props);
    this.simulateLoading();
  }

  // Simulate loading data before start app
  simulateLoading() {
    setTimeout(() => {
      this.props.navigation.navigate('Auth');
    }, 1000);
  }

  // Render any loading content that you like here
  render() {
    return (
      <View style={styles.container}>
        <Text style={styles.text}> Checking authentication... </Text>
        <ActivityIndicator size="large"/>
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

  text: {
    fontSize: 18,
    padding: 20,
  }
})
