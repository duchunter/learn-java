import React from 'react';
import {
  Dimensions, ImageBackground
} from 'react-native';
import {
  Container, Content, Item, Input, Label, Toast, Button, Text,
  Card, CardItem, Left, Right, Body, Form, H2
} from 'native-base';

export default class RegisterScreen extends React.Component {
  static navigationOptions = {
    title: 'Create new account',
    headerTintColor: 'white',
    headerStyle: {
      backgroundColor: '#212121'
    }
  }

  constructor(props) {
    super(props);
    this.state = {
      dimensions: Dimensions.get('screen'),
      email: '',
      user: '',
      password: '',
      confirmPassword: ''
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

  register = () => {
    Toast.show({
      text: 'This is for testing only, please login using default credentials',
      buttonText: 'Okay',
      type: 'danger',
      position: 'top'
    });
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
              marginTop: this.state.dimensions.height * 0.05
            }}>
              {/* Card header */}
              <CardItem header bordered>
                <H2> Enter your info </H2>
              </CardItem>

              {/* Form inside card */}
              <CardItem>
                <Form style={{width: '80%'}}>
                  <Item floatingLabel>
                    <Label> Email </Label>
                    <Input
                      onChangeText={(text) => this.setState({email: text})}
                    />
                  </Item>
                  <Item floatingLabel>
                    <Label> Username </Label>
                    <Input
                      onChangeText={(text) => this.setState({user: text})}
                    />
                  </Item>
                  <Item floatingLabel>
                    <Label> Password </Label>
                    <Input
                      onChangeText={(text) => this.setState({password: text})}
                    />
                  </Item>
                  <Item floatingLabel>
                    <Label> Confirm password </Label>
                    <Input
                      onChangeText={(text) => this.setState({confirmPassword: text})}
                    />
                  </Item>
                </Form>
              </CardItem>

              {/* Margin between form and buttons */}
              <CardItem />

              {/* Footer contains button */}
              <CardItem footer bordered
                style={{
                  flex: 1,
                  flexDirection: 'row',
                  justifyContent: 'flex-end',
                }}
              >
                <Button
                  style={{marginRight: 5}}
                  onPress={this.register}
                >
                  <Text> Register </Text>
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
