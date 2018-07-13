import React from 'react';
import { connect } from 'react-redux';
import { StyleSheet, FlatList } from 'react-native';
import TasksListItem from './TasksListItem';

const mapStateToProps = (state) => {
  return {
    tasks: state.tasks
  }
}

class TasksList extends React.Component {
  render() {
    return (
      <FlatList
        style={styles.list}
        data={this.props.tasks}
        keyboardShouldPersistTaps={'handled'}
        keyExtractor={(item) => item.id.toString()}
        renderItem={({item}) => (
          <TasksListItem item={item} />
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

export default connect(mapStateToProps, null)(TasksList)
