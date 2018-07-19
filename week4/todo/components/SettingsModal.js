import React from 'react';
import {
  Container, Header, Content, Text, Left, Body, Right, Button, Icon,
  Title, CardItem
} from 'native-base';
import { Switch } from 'react-native';
import { headerBackground } from '../theme/Dark';

export default class SettingsModal extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      toogle1: true,
      toogle2: true,
    }
  }

  render() {
    return (
      <Container>
        <Header style={headerBackground}>
            <Left>
              <Button transparent
                onPress={() => this.props.setVisible(false)}
              >
                <Icon name={'arrow-back'} />
              </Button>
            </Left>
            <Body>
              <Title>Settings</Title>
            </Body>
            <Right />
        </Header>
        <Content padder>
          <CardItem bordered>
            <Body>
              <Text>Version</Text>
              <Text note>1.0.0</Text>
            </Body>
          </CardItem>

          <CardItem bordered>
            <Body style={{flex: 1}}>
              <Text>Auto update</Text>
              <Text note>
                Check for new update on start up
              </Text>
            </Body>
            <Right style={{flex: 0.2}}>
              <Switch
                value={this.state.toogle1}
                onValueChange={(newVal) => this.setState({ toogle1: newVal })}
              />
            </Right>
          </CardItem>

          <CardItem bordered>
            <Body style={{flex: 1}}>
              <Text>Help us improve this app</Text>
              <Text note>
                Send your data to developers, we will not send
                any personal data
              </Text>
            </Body>
            <Right style={{flex: 0.2}}>
              <Switch
                value={this.state.toogle2}
                onValueChange={(newVal) => this.setState({ toogle2: newVal })}
              />
            </Right>
          </CardItem>
        </Content>
      </Container>
    );
  }
}
