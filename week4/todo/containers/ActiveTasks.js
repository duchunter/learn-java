import React from 'react';
import { StyleSheet, View } from 'react-native';
import Icon from 'react-native-vector-icons/dist/MaterialIcons';
import TasksList from '../components/TasksList';
import HeaderBar from '../components/HeaderBar';

export default class ActiveTasks extends React.Component {
  static navigationOptions = ({ navigation }) => ({
      tabBarIcon: ({ focused, tintColor }) => {
        return <Icon name={'directions-run'} size={25} color={tintColor} />;
      },
  });

  render() {
    return (
      <View style={styles.container}>
        {/* Menu button that open drawer */}
        <HeaderBar navigation={this.props.navigation} />

        {/* Display tasks list */}
        <TasksList filter={'active'}/>
      </View>
    );
  }
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'flex-start',
    alignItems: 'center',
    backgroundColor: 'white',
    paddingTop: 60,
    width: '100%'
  },
});
