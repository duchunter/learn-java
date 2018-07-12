// Render an item in tasksList in either display mode or edit mode
// Props: index, item, toogleCompleted, editTask, deleteTask

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
          index={this.props.index}
          item={this.props.item}
          editTask={this.props.editTask}
          stopEditing={this.stopEditing}
        />
      ) : (
        <TasksListItemDisplay
          index={this.props.index}
          item={this.props.item}
          toogleCompleted={this.props.toogleCompleted}
          startEditing={this.startEditing}
          deleteTask={this.props.deleteTask}
        />
      )
  }
}
