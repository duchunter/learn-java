import React from 'react';
import { connect } from 'react-redux';
import {
  StyleSheet, View, BackHandler, Alert, Button, Platform
} from 'react-native';
import TasksList from '../components/TasksList';
import TaskInput from '../components/TaskInput';
import { addTask, editTask, toogleTask, deleteTask } from '../actions/index';

class Todo extends React.Component {
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
        <TaskInput
          addNewTask={this.props.addTask}
        />

        {/* Display tasks list */}
        <TasksList
          tasks={this.props.tasks}
          toogleCompleted={this.props.toogleTask}
          editTask={this.props.editTask}
          deleteTask={this.props.deleteTask}
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

const mapStateToProps = (state, props) => ({
  tasks: state.tasks
});

const mapDispactToProps = (dispatch, props) => ({
  addTask: content => dispatch(addTask(content)),
  editTask: (id, content) => dispatch(editTask(id, content)),
  toogleTask: id => dispatch(toogleTask(id)),
  deleteTask: id => dispatch(deleteTask(id))
});

export default connect(mapStateToProps, mapDispactToProps)(Todo)
