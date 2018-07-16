import React from 'react';
import { connect } from 'react-redux';
import {
  StyleSheet, Text, View, TextInput, TouchableOpacity, Keyboard
} from 'react-native';
import { addTask } from '../actions';
import {Toast} from 'native-base';

const mapDispatchToProps = (dispatch) => {
  return {
    addNewTask: (content) => dispatch(addTask(content))
  }
}

class TaskInput extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      text: ''
    }
  }

  // Change 'text' state as user type
  handleTypingTask = (text) => {
    this.setState({ text });
  }

  // Validate text and add new task
  submitText = () => {
    // New task must not be empty
    let notEmpty = this.state.text.trim().length > 0;
    if (notEmpty) {
      this.props.addNewTask(this.state.text);
    } else {
      Toast.show({
        text: 'New task must not be empty',
        buttonText: 'Okay',
        type: 'danger',
        position: 'top'
      });
    }

    // Close keyboard, clear input field and reset 'text'
    Keyboard.dismiss();
    this.textInput.clear();
    this.setState({ text: '' });
  }

  render() {
    return (
      <View style={styles.container}>
        {/* Plus button */}
        <TouchableOpacity
          style={styles.addButton}
          onPress={this.submitText}
        >
          <Text style={styles.plus}> + </Text>
        </TouchableOpacity>

        {/* Input field */}
        <TextInput
          style={styles.input}
          placeholder="Add new task"
          ref={input => { this.textInput = input }}
          onChangeText={this.handleTypingTask}
          onSubmitEditing={this.submitText}
        />
      </View>
    );
  }
}

const styles = StyleSheet.create({
  container: {
    flexDirection: 'row',
    alignItems: 'center',
    justifyContent: 'center',
    width:'100%',
  },

  input: {
    height: 50,
    paddingRight: 10,
    paddingLeft: 10,
    width: '80%',
    fontSize: 18,
    borderWidth: 1,
    borderColor: '#ccc',
    borderRadius: 4,
    marginLeft: 5
  },

  addButton: {
    alignItems: 'center',
    justifyContent: 'center',
    backgroundColor: 'green',
    borderRadius: 22,
    height: 22,
    width: 22
  },

  plus: {
    color: 'white',
    fontSize: 18
  }
});

export default connect(null, mapDispatchToProps)(TaskInput)
