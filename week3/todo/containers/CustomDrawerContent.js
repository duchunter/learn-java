import React from 'react';
import Icon from 'react-native-vector-icons/dist/MaterialIcons';
import { DrawerItems, SafeAreaView } from 'react-navigation';
import {
  StyleSheet, ScrollView, Text, TouchableHighlight, View
} from 'react-native';

const CustomDrawerContent = (props) => (
  <ScrollView>
    <SafeAreaView
      style={{ flex: 1 }}
      forceInset={{ top: 'always', horizontal: 'never' }}
    >
      <Text style={styles.title}> Todo App </Text>

      <DrawerItems {...props} renderIcon={({ route, tintColor })=>{
        let iconName;
        switch (route.routeName) {
          case 'Dashboard':
            iconName = 'dashboard';
            break;

          case 'Profile':
            iconName = 'portrait';
            break;
          default:
            iconName = 'error';
        }

        return <Icon name={iconName} size={25} color={tintColor}/>
      }} />

      <TouchableHighlight
        onPress={() => {
          props.navigation.navigate('Auth');
        }}
      >
        <View style={styles.logOutButton}>
          <Icon name={'directions-run'} size={25} color={'black'} />
          <Text style={styles.text}> Log Out </Text>
        </View>
      </TouchableHighlight>
    </SafeAreaView>
  </ScrollView>
);

const styles = StyleSheet.create({
  logOutButton: {
    borderTopWidth: 1,
    borderColor: 'grey',
    flex: 1,
    flexDirection: 'row',
    alignItems: 'center',
    justifyContent: 'center',
    paddingTop: 3
  },

  text: {
    fontSize: 18,
    color: 'black'
  },

  title: {
    padding: 10,
    fontSize: 20,
    fontWeight: 'bold',
    color: 'black'
  }
});

export default CustomDrawerContent;
