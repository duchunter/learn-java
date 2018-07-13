import React from 'react';
import {
  StyleSheet, View, BackHandler, Alert, Button, Platform, Keyboard
} from 'react-native';
import TasksList from '../components/TasksList';
import TaskInput from '../components/TaskInput';

// Handle loging out
const logout = (navigation) => {
  Alert.alert('You are loging out', 'Are you sure ?', [
    { text: 'Cancel' },
    { text: 'Ok', onPress: () => navigation.navigate('Auth') }
  ]);
}

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

  // All tasks will be stored here
  constructor(props) {
    super(props);
    this.state = {
      viewPadding: 0,
      tasks: [
        {
          content: 'test',
          completed: false,
        },
        {
          content: 'do something',
          completed: true,
        }
      ]
    }
  }

  componentDidMount() {
    // Press back in this place will logout instead of quit app
    this.backHandlerListener = BackHandler.addEventListener(
      'hardwareBackPress',
      () => {
        logout(this.props.navigation);
        return true;
      }
    );

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
    this.backHandlerListener.remove();
    this.keyboardShowListener.remove();
    this.keyboardHideListener.remove();
  }

  //  Keyboard show -> increase padding bottom according to keyboard height
  handleKeyboardShow = (e) => {
    this.setState({
      viewPadding: e.endCoordinates.height
    });
  }

  //  Keyboard hide -> return padding to 0
  handleKeyboardHide = (e) => {
    this.setState({
      viewPadding: 0
    });
  }

  // Toogle task completed status
  toogleCompleted = (index) => {
    let newTasks = [...this.state.tasks];
    newTasks[index].completed = !newTasks[index].completed;
    this.setState({ tasks: newTasks });
  }

  // Add new task
  addNewTask = (text) => {
    this.setState({
      tasks: [
        ...this.state.tasks,
        {
          content: text,
          completed: false,
        }
      ],
    });
  }

  // Edit task by index
  editTask = (index, newContent) => {
    let tasks = [...this.state.tasks];
    tasks[index].content = newContent;
    this.setState({ tasks });
  }

  // Delete task by index
  deleteTask = (index) => {
    let newTasks = this.state.tasks.filter((item, pos) => pos != index);
    this.setState({ tasks: newTasks });
  }

  render() {
    return (
      <View style={[
        styles.container,
        { paddingBottom: this.state.viewPadding }
      ]}>
        {/* Input field */}
        <TaskInput
          addNewTask={this.addNewTask}
        />

        {/* Display tasks list */}
        <TasksList
          tasks={this.state.tasks}
          toogleCompleted={this.toogleCompleted}
          editTask={this.editTask}
          deleteTask={this.deleteTask}
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
