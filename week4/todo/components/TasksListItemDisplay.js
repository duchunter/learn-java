import React from 'react';
import { connect } from 'react-redux';
import {
  ListItem, CheckBox, Text, Icon, Button, Right, Body, Left
} from 'native-base';
import { toogleTask, deleteTask } from '../actions';
import { font } from '../theme/Dark';

const mapDispatchToProps = (dispatch) => {
  return {
    toogleTask: (id) => dispatch(toogleTask(id)),
    deleteTask: (id) => dispatch(deleteTask(id))
  }
}

class TasksListItemDisplay extends React.Component {
  render() {
    return (
      <ListItem button
        onPress={() => this.props.toogleTask(this.props.item.id)}
      >
        {/* A small check box to toogle task completed status */}
        <CheckBox
          color={'green'}
          checked={this.props.item.completed}
          onPress={() => this.props.toogleTask(this.props.item.id)}
        />

        <Body>
          {/* Task content */}
          <Text style={{
            textDecorationLine: this.props.item.completed
              ? 'line-through'
              : 'none'
          }}>
            {this.props.item.content}
          </Text>
        </Body>

        <Right style={{
          flex: 0.5,
          flexDirection: 'row',
          justifyContent: 'flex-end'
        }}>
          {/* Edit button */}
          <Button transparent
            onPress={this.props.startEditing}
          >
            <Icon
              type={'MaterialIcons'} name={'edit'} size={25}
              style={font}
            />
          </Button>

          {/* Delete button */}
          <Button transparent
            onPress={() => this.props.deleteTask(this.props.item.id)}
          >
            <Icon
              type={'MaterialIcons'} name={'delete-forever'} size={25}
              style={font}
            />
          </Button>
        </Right>
      </ListItem>
    )
  }
}

export default connect(null, mapDispatchToProps)(TasksListItemDisplay)
