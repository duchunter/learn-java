import React from 'react';
import { StyleSheet, Text, View } from 'react-native';
import { createStore } from 'redux';
import { Provider } from 'react-redux';
import { createStackNavigator, createSwitchNavigator } from 'react-navigation';
import Todo from './containers/Todo';
import LoginScreen from './containers/LoginScreen';
import AuthLoadingScreen from './containers/AuthLoadingScreen';
import rootReducer from './reducers';

const store = createStore(rootReducer);
const AppStack = createStackNavigator({ Dashboard: Todo });
const AuthStack = createStackNavigator({ Login: LoginScreen });
const RootStack = createSwitchNavigator(
  {
    AuthLoading: AuthLoadingScreen,
    App: AppStack,
    Auth: AuthStack
  },
  {
    initialRouteName: 'App',
  }
);

export default class App extends React.Component {
  render() {
    return (
      <Provider store={store}>
        <RootStack />
      </Provider>
    );
  }
}
