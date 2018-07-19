import React from 'react';
import { connect } from 'react-redux';
import {
  ListItem, Icon, Button, Right, Body, Left, Toast, Input, Item
} from 'native-base';
import { editTask } from '../actions';
import { font } from '../theme/Dark';

const mapDispatchToProps = (dispatch) => {
  return {
    editTask: (id, content) => dispatch(editTask(id, content))
  }
}

const darkTheme = {
  color: '#212121'
}

class TasksListItemEdit extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      newContent: this.props.item.content
    }
  }

  handleContentTyping = (text) => {
    this.setState({
      newContent: text
    });
  }

  submitChange = () => {
    let notEmpty = this.state.newContent.trim().length > 0;
    if (notEmpty) {
      this.props.editTask(this.props.item.id, this.state.newContent);
      this.props.stopEditing();
    } else {
      Toast.show({
        text: 'Task must not be empty',
        buttonText: 'Okay',
        type: 'danger',
        position: 'top'
      });
    }
  }

  discardChange = () => {
    this.props.stopEditing();
  }

  render() {
    return (
      <ListItem>
        <Body>
          {/* Input field to edit content */}
          <Item rounded>
            <Input
              value={this.state.newContent}
              onChangeText={this.handleContentTyping}
              onSubmitEditing={this.submitChange}
            />
          </Item>
        </Body>

        <Right style={{
          flex: 0.5,
          flexDirection: 'row',
          justifyContent: 'flex-end'
        }}>
          {/* Submit change button */}
          <Button transparent onPress={this.submitChange}>
            <Icon
              type={'MaterialIcons'} name={'check'} size={25}
              style={font}
            />
          </Button>

          {/* Discard change button */}
          <Button transparent onPress={this.discardChange}>
            <Icon
              type={'MaterialIcons'} name={'close'} size={25}
              style={font}
            />
          </Button>
        </Right>
      </ListItem>
    )
  }
}

export default connect(null, mapDispatchToProps)(TasksListItemEdit)
