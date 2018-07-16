import React from 'react';
import { connect } from 'react-redux';
import Icon from 'react-native-vector-icons/dist/MaterialIcons';
import {
  StyleSheet, Text, View, CheckBox, TouchableOpacity
} from 'react-native';
import { toogleTask, deleteTask } from '../actions';

const mapDispatchToProps = (dispatch) => {
  return {
    toogleTask: (id) => dispatch(toogleTask(id)),
    deleteTask: (id) => dispatch(deleteTask(id))
  }
}

class TasksListItemDisplay extends React.Component {
  render() {
    return (
      <View style={styles.itemContainer}>
        {/* A small check box to toogle task completed status */}
        <CheckBox
          onValueChange={() => this.props.toogleTask(this.props.item.id)}
          value={this.props.item.completed}
        />

        {/* Task content */}
        <Text style={[
          styles.taskContent,
          {
            textDecorationLine: this.props.item.completed
              ? 'line-through'
              : 'none'
          }
        ]}>
          {this.props.item.content}
        </Text>

        {/* Edit button */}
        <TouchableOpacity
          style={styles.iconButton}
          onPress={this.props.startEditing}
        >
          <Icon name={'edit'} size={25} />
        </TouchableOpacity>

        {/* Delete button */}
        <TouchableOpacity
          style={styles.iconButton}
          onPress={() => this.props.deleteTask(this.props.item.id)}
        >
          <Icon name={'delete-forever'} size={25} />
        </TouchableOpacity>
      </View>
    )
  }
}

const styles = StyleSheet.create({
  itemContainer: {
    flexDirection: 'row',
    alignItems: 'center',
    paddingTop: 10,
  },

  taskContent: {
    paddingTop: 2,
    paddingBottom: 2,
    fontSize: 18,
    width: '70%',
    padding: 10,
  },

  iconButton: {
    paddingRight: 5
  },
});

export default connect(null, mapDispatchToProps)(TasksListItemDisplay)
