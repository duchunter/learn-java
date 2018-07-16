import React from 'react';
import {
  StyleSheet, View, Text, Image
} from 'react-native';
import HeaderBar from '../components/HeaderBar';

export default class Active extends React.Component {
  render() {
    return (
      <View style={styles.container}>
        <HeaderBar navigation={this.props.navigation} />
        <Image
          source={require('../static/img/user.png')}
          style={styles.avatar}
        />
        <View style={styles.infoContainer}>
          <Text style={styles.infoText} > User: test </Text>
          <Text style={styles.infoText} > Password: 123 </Text>
        </View>
      </View>
    );
  }
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    backgroundColor: 'white',
    paddingTop: 20,
    width: '100%'
  },

  avatar: {
    height: 200,
    width:  200,
    borderRadius: 200,
    borderWidth: 1,
    borderColor: 'grey'
  },

  infoContainer: {
    marginTop: 20,
    justifyContent: 'flex-start',
  },

  infoText: {
    fontSize: 18
  }
});
