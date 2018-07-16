import React from 'react'
import {
  StyleSheet, View, TouchableOpacity, Text
} from 'react-native';
import Icon from 'react-native-vector-icons/dist/MaterialIcons';

export default class HeaderBar extends React.Component {
  render() {
    return (
      <View style={styles.container}>
        <TouchableOpacity
          style={styles.menuButton}
          onPress={() => this.props.navigation.openDrawer()}
        >
          <Icon name={'menu'} size={30} />
        </TouchableOpacity>
        <Text style={styles.title}>
          Todo App
        </Text>
      </View>
    )
  }
}

const styles = StyleSheet.create({
  container: {
    position: 'absolute',
    top: 15,
    flexDirection: 'row',
    alignItems: 'center',
    width: '100%',
    paddingLeft: 10,
    marginBottom: 10,
    height: 30,
  },

  menuButton: {
    borderWidth: 1,
    borderColor: '#ccc',
    borderRadius: 4,
    justifyContent: 'center',
    alignItems: 'center',
    width: 35,
    height: 35
  },

  title: {
    paddingLeft: 10,
    fontSize: 20,
    fontWeight: 'bold'
  }
})
