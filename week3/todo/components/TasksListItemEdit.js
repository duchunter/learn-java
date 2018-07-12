// Render an item in tasksList in edit mode (not display mode)
// and handle action: editTask
// Props: index, item, stopEditing, editTask

import React from 'react';
import {
  StyleSheet, TextInput, View, TouchableOpacity, Image
} from 'react-native';

export default class TasksList extends React.Component {
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
      this.props.editTask(this.props.index, this.state.newContent);
      this.props.stopEditing();
    } else {
      alert("Content must not be empty");
    }
  }

  discardChange = () => {
    this.props.stopEditing();
  }

  render() {
    return (
      <View style={styles.itemContainer}>
        {/* Input field to edit content */}
        <TextInput
          style={styles.taskContent}
          value={this.state.newContent}
          onChangeText={this.handleContentTyping}
          onSubmitEditing={this.submitChange}
        />

        {/* Submit change button */}
        <TouchableOpacity
          style={styles.iconButton}
          onPress={this.submitChange}
        >
          <Image
            source={require('../static/img/check.png')}
            style={styles.icon}
          />
        </TouchableOpacity>

        {/* Discard change button */}
        <TouchableOpacity
          style={styles.iconButton}
          onPress={this.discardChange}
        >
          <Image
            source={require('../static/img/cross.png')}
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
    paddingBottom: 7,
    marginLeft: 30,
    fontSize: 18,
    width: '70%',
    padding: 10,
  },

  iconButton: {
    paddingRight: 7
  },

  icon: {
    height: 22,
    width: 22
  }
});
