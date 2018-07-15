import React from 'react';
import { connect } from 'react-redux';
import { StyleSheet, FlatList, Text, View } from 'react-native';
import TasksListItem from './TasksListItem';

const mapStateToProps = (state, props) => {
  return {
    tasks: state.tasks.filter(task => {
      if (props.filter === 'finished') {
        return task.completed === true;
      }

      if (props.filter === 'active') {
        return task.completed === false;
      }

      return true;
    })
  }
}

class TasksList extends React.Component {
  render() {
    return this.props.tasks.length > 0
      ? (
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
      : (
          <View style={styles.nothingToShow}>
            <Text> Nothing to show </Text>
          </View>
        )
  }
}

const styles = StyleSheet.create({
  list: {
    width: '100%',
    paddingLeft: 20,
    paddingRight: 20,
    overflow: 'scroll'
  },

  nothingToShow: {
    position: 'absolute',
    top: '50%'
  }
});

export default connect(mapStateToProps, null)(TasksList)
