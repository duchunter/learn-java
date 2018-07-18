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
      dimensions: Dimensions.get('screen'),
      email: ''
    }
  }

  componentDidMount() {
    Dimensions.addEventListener('change', this.handleDimensionsChange);
  }

  componentWillUnmount() {
    Dimensions.removeEventListener('change', this.handleDimensionsChange);
  }

  handleDimensionsChange = (newDimensions) => {
    this.setState({
      dimensions: newDimensions.screen
    });
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
            <Card style={{
              marginTop: this.state.dimensions.height * 0.1,
            }}>
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

              {/* Footer contains button */}
              <CardItem footer
                style={{
                  flex: 1,
                  flexDirection: 'row',
                  justifyContent: 'flex-end'
                }}
              >
                <Button
                  style={{marginRight: 5}}
                  onPress={this.sendEmail}
                >
                  <Text> Send Email </Text>
                </Button>
                <Button danger
                  onPress={() => this.props.navigation.navigate('Login')}
                >
                  <Text> Cancel </Text>
                </Button>
              </CardItem>
            </Card>
          </Content>
        </ImageBackground>
      </Container>
    );
  }
}
