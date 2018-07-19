import React from 'react';
import { connect } from 'react-redux';
import { Keyboard } from 'react-native';
import { addTask } from '../actions';
import { Toast, Item, Input, Button, Right, Icon } from 'native-base';

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
    this.textInput._root.clear();
    this.setState({ text: '' });
  }

  render() {
    return (
      <Item rounded style={{
        marginLeft: 20,
        marginRight: 20,
        marginTop: 10
      }}>
        <Input
          placeholder='Add new task'
          ref={input => { this.textInput = input }}
          onChangeText={(text) => this.setState({ text })}
          onSubmitEditing={this.submitText}
        />
        <Right>
          <Button rounded transparent onPress={this.submitText}>
            <Icon name={'add'} style={{color: '#43a047'}}/>
          </Button>
        </Right>
      </Item>
    );
  }
}

export default connect(null, mapDispatchToProps)(TaskInput)
