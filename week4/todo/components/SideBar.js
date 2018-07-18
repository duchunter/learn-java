import React from 'react';
import Icon from 'react-native-vector-icons/dist/MaterialIcons';
import { SafeAreaView } from 'react-navigation';
import { ImageBackground } from 'react-native';
import {
  Container, Content, H3, Text, ListItem, Left, Body, Thumbnail
} from 'native-base';

const drawerRoutes = [
  {
    route: 'Dashboard',
    icon: 'dashboard',
    color: '#f44336'
  },
  {
    route: 'Profile',
    icon: 'portrait',
    color: '#2196f3'
  }
]

export default class SideBar extends React.Component {
  constructor(props) {
    super(props);
    this.state = {

    }
  }

  render() {
    return (
      <Container>
        <SafeAreaView
          style={{ flex: 1 }}
          forceInset={{ top: 'always', horizontal: 'never' }}
        >
          <Content>
            {/* User avatar + name + mail */}
            <ImageBackground
              source={require('../static/img/lap.jpg')}
              style={{width: '100%', height: 150}}
            >
              <ListItem thumbnail style={{
                backgroundColor: 'rgba(0, 0, 0, 0.4)',
                height: '100%',
              }}>
                <Left>
                  <Thumbnail large
                    source={require('../static/img/user.png')}
                    style={{backgroundColor: 'white'}}
                  />
                </Left>
                <Body>
                  <H3 style={{color: 'white'}}>Test</H3>
                  <Text style={{color: 'white'}}>test@gmail.com</Text>
                </Body>
              </ListItem>
            </ImageBackground>

            {/* Navigation list */}
            <ListItem itemDivider icon />
            {drawerRoutes.map((item, index) => (
              <ListItem icon
                key={index}
                onPress={() => this.props.navigation.navigate(item.route)}
              >
                <Left>
                  <Icon
                    name={item.icon}
                    size={25}
                    style={
                      (this.props.activeItemKey == item.route)
                        ? { color: item.color }
                        : {}
                    }
                  />
                </Left>
                <Body>
                  <Text
                    style={
                      (this.props.activeItemKey == item.route)
                        ? { color: item.color }
                        : {}
                    }
                  >
                    {item.route}
                  </Text>
                </Body>
              </ListItem>
            ))}

            {/* Log out button */}
            <ListItem itemDivider icon />
            <ListItem icon
              onPress={() => this.props.navigation.navigate('Auth')}
            >
              <Left>
                <Icon name="directions-run" size={25} />
              </Left>
              <Body>
                <Text>Log out</Text>
              </Body>
            </ListItem>
            <ListItem itemDivider icon/>
          </Content>
        </SafeAreaView>
      </Container>
    )
  }
}
