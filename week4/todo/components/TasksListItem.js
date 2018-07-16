import React from 'react';
import TasksListItemDisplay from './TasksListItemDisplay';
import TasksListItemEdit from './TasksListItemEdit';

export default class TasksList extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      isEditing: false
    }
  }

  startEditing = () => {
    this.setState({
      isEditing: true
    })
  }

  stopEditing = () => {
    this.setState({
      isEditing: false
    })
  }

  render() {
    return this.state.isEditing
      ? (
        <TasksListItemEdit
          item={this.props.item}
          stopEditing={this.stopEditing}
        />
      ) : (
        <TasksListItemDisplay
          item={this.props.item}
          startEditing={this.startEditing}
        />
      )
  }
}
