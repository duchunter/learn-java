import React from 'react';
import {
  StyleSheet, View, BackHandler, Alert, Button, Platform
} from 'react-native';
import TasksList from '../components/TasksList';
import TaskInput from '../components/TaskInput';

export default class Todo extends React.Component {
  // Navigation options
  static navigationOptions = ({ navigation }) => {
    return {
      title: 'Dashboard',
      headerRight: (
        <View style={{paddingRight: 10}}>
          <Button
            title="Log Out"
            color="#2196f3"
            onPress={() => logout(navigation)}
          />
        </View>
      ),
    }
  };

  componentDidMount() {
    // Press back in this place will logout instead of quit app
    this.backHandlerListener = BackHandler.addEventListener(
      'hardwareBackPress',
      () => {
        logout(this.props.navigation);
        return true;
      }
    );
  }

  componentWillUnmount() {
    // Remove all listeners
    this.backHandlerListener.remove();
  }

  render() {
    return (
      <View style={styles.container}>
        {/* Input field */}
        <TaskInput/>

        {/* Display tasks list */}
        <TasksList />
      </View>
    );
  }
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    backgroundColor: 'white',
    paddingTop: 20,
    width: '100%'
  },
});

// Handle loging out
const logout = (navigation) => {
  Alert.alert('You are loging out', 'Are you sure ?', [
    { text: 'Cancel' },
    { text: 'Ok', onPress: () => navigation.navigate('Auth') }
  ]);
}
