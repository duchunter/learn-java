// Render tasks list and perform action: edit, delete, check, uncheck
// Props: tasks, toogleCompleted, editTask, deleteTask

import React from 'react';
import { StyleSheet, FlatList } from 'react-native';
import TasksListItem from './TasksListItem';

export default class TasksList extends React.Component {
  render() {
    return (
      <FlatList
        style={styles.list}
        data={this.props.tasks}
        keyboardShouldPersistTaps={'handled'}
        keyExtractor={(item, index) => index.toString()}
        renderItem={({item, index}) => (
          <TasksListItem
            item={item}
            index={index}
            toogleCompleted={this.props.toogleCompleted}
            editTask={this.props.editTask}
            deleteTask={this.props.deleteTask}
          />
        )}
      />
    )
  }
}

const styles = StyleSheet.create({
  list: {
    width: '100%',
    paddingLeft: 20,
    paddingRight: 20,
    overflow: 'scroll'
  }
});
