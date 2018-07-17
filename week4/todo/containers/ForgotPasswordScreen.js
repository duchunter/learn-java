import React from 'react';
import {
  Dimensions, ImageBackground
} from 'react-native';
import {
  Container, Content, Item, Input, Label, Toast, Button, Text,
  Card, CardItem, Left, Right, Body
} from 'native-base';

export default class ForgotPasswordScreen extends React.Component {
  static navigationOptions = {
    title: 'Recover password',
    headerTintColor: 'white',
    headerStyle: {
      backgroundColor: '#212121'
    }
  }

  constructor(props) {
    super(props);
    this.state = {
      email: ''
    }
  }

  sendEmail = () => {
    if (this.state.email.trim()) {
      Toast.show({
        text: 'This is for testing only, nothing will happen',
        buttonText: 'Okay',
        type: 'success',
        position: 'top'
      });
    } else {
      Toast.show({
        text: 'Please enter your email',
        buttonText: 'Okay',
        type: 'danger',
        position: 'top'
      });
    }
  }

  render() {
    return (
      <Container>
        <ImageBackground
          source={require('../static/img/bg.jpg')}
          style={{width: '100%', height: '100%'}}
        >
          <Content padder>
            <Card style={{marginTop: 150}}>
              <CardItem>
                <Body>
                  <Text>
                    Please enter your email address to search for your account
                  </Text>
                </Body>
              </CardItem>

              <CardItem>
                <Body>
                  <Item regular>
                    <Input
                      placeholder="Email"
                      onChangeText={(text) => this.setState({email: text})}
                      onSubmitEditing={this.sendEmail}
                    />
                  </Item>
                </Body>
              </CardItem>

              <CardItem>
                <Left />
                <Body />
                <Right>
                  <Button
                    onPress={this.sendEmail}
                  >
                    <Text> Send </Text>
                  </Button>
                </Right>
              </CardItem>
            </Card>
          </Content>
        </ImageBackground>
      </Container>
    );
  }
}
