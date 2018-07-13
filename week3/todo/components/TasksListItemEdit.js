import React from 'react';
import { connect } from 'react-redux';
import {
  StyleSheet, TextInput, View, TouchableOpacity, Image
} from 'react-native';
import { editTask } from '../actions';

const mapDispatchToProps = (dispatch) => {
  return {
    editTask: (id, content) => dispatch(editTask(id, content))
  }
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
          style={styles.input}
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

  input: {
    paddingTop: 2,
    paddingBottom: 7,
    marginLeft: 30,
    marginRight: 2,
    fontSize: 18,
    width: '70%',
    padding: 10,
    borderWidth: 1,
    borderColor: '#ccc',
    borderRadius: 4,
  },

  iconButton: {
    paddingRight: 7
  },

  icon: {
    height: 22,
    width: 22
  }
});

export default connect(null, mapDispatchToProps)(TasksListItemEdit)
