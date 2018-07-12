// Render an item in tasksList in display mode (not edit mode)
// and perform action: toogleCompleted, deleteTask
// Props: index, item, toogleCompleted, startEditing, deleteTask

import React from 'react';
import {
  StyleSheet, Text, View, CheckBox, TouchableOpacity, Image
} from 'react-native';

export default class TasksList extends React.Component {
  render() {
    return (
      <View style={styles.itemContainer}>
        {/* A small check box to toogle task completed status */}
        <CheckBox
          onValueChange={() => this.props.toogleCompleted(this.props.index)}
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
          <Image
            source={require('../static/img/edit.png')}
            style={styles.icon}
          />
        </TouchableOpacity>

        {/* Delete button */}
        <TouchableOpacity
          style={styles.iconButton}
          onPress={() => this.props.deleteTask(this.props.index)}
        >
          <Image
            source={require('../static/img/trash.png')}
            style={styles.icon}
          />
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

  icon: {
    height: 25,
    width: 25
  }
});
