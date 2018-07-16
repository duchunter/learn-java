import React from 'react'
import { StyleSheet, Text, View } from 'react-native'
import { createStore } from 'redux'
import { Provider } from 'react-redux'
import { Root } from 'native-base';
import RootStack from './navigation'
import rootReducer from './reducers'

const store = createStore(rootReducer);

export default class App extends React.Component {
  render() {
    return (
      <Provider store={store}>
        <Root>
          <RootStack />
        </Root>
      </Provider>
    );
  }
}
