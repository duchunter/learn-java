import React from 'react';
import { StyleSheet, Text, View } from 'react-native';
import { createStackNavigator, createSwitchNavigator } from 'react-navigation';
import Todo from './containers/Todo';
import LoginScreen from './containers/LoginScreen';
import AuthLoadingScreen from './containers/AuthLoadingScreen';

const AppStack = createStackNavigator({ Dashboard: Todo });
const AuthStack = createStackNavigator({ Login: LoginScreen });
const RootStack = createSwitchNavigator(
  {
    AuthLoading: AuthLoadingScreen,
    App: AppStack,
    Auth: AuthStack
  },
  {
    initialRouteName: 'AuthLoading',
  }
);

export default class App extends React.Component {
  render() {
    return (
      <RootStack />
    );
  }
}
