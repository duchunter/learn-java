import React from 'react';
import { StyleSheet, View } from 'react-native';
import Icon from 'react-native-vector-icons/dist/MaterialIcons';
import TasksList from '../components/TasksList';
import TaskInput from '../components/TaskInput';
import HeaderBar from '../components/HeaderBar';

export default class AllTasks extends React.Component {
  static navigationOptions = ({ navigation }) => ({
      tabBarIcon: ({ focused, tintColor }) => {
        return <Icon name={'apps'} size={25} color={tintColor} />;
      },
  });

  render() {
    return (
      <View style={styles.container}>
        {/* Menu button that open drawer */}
        <HeaderBar navigation={this.props.navigation} />

        {/* Input field */}
        <TaskInput/>

        {/* Display tasks list */}
        <TasksList filter={'none'} />
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
  }
});
