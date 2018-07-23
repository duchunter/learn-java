import React from 'react';
import { Modal } from 'react-native';
import {
  Icon, Left, Body, Title, Right, Button, Header, Text
} from 'native-base';
import { headerBackground, headerFont } from '../theme/Dark';
import SettingsModal from './SettingsModal';

export default class HeaderBar extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      settingsModalVisible: false
    }
  }

  setSettingsVisible = (visible) => {
    this.setState({
      settingsModalVisible: visible
    })
  }

  render() {
    return (
      <Header style={headerBackground}>
        {/* Basic header bar */}
        <Left>
          <Button transparent
            onPress={() => this.props.navigation.openDrawer()}
          >
            <Icon type={'MaterialIcons'} name={'menu'} color={'white'}/>
          </Button>
        </Left>
        <Body>
          <Title style={headerFont}>Todo App</Title>
        </Body>
        <Right>
        <Button transparent onPress={() => this.setSettingsVisible(true)}>
          <Icon type={'MaterialIcons'} name={'settings'} color={'white'}/>
        </Button>
        </Right>

        {/* Settings modal */}
        <Modal
          animationType="slide"
          transparent={false}
          visible={this.state.settingsModalVisible}
          onRequestClose={() => this.setSettingsVisible(false)}
        >
          <SettingsModal setVisible={this.setSettingsVisible}/>
        </Modal>
      </Header>
    );
  }
}
