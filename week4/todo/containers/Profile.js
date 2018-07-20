import React from 'react';
import { StyleSheet, Image } from 'react-native';
import {
  Container, Content, Label, Text, Button, Card, CardItem,
  Left, Body, Toast
} from 'native-base';
import HeaderBar from '../components/HeaderBar';

export default class Active extends React.Component {
  verifyEmail = () => {
    Toast.show({
      text: 'Comming soon',
      buttonText: 'Okay',
      type: 'success',
      position: 'top'
    })
  }

  render() {
    return (
      <Container>
        <HeaderBar navigation={this.props.navigation}/>

        <Content padder>
          <Card>
            <CardItem style={styles.centerContent}>
              <Image
                source={require('../static/img/user.png')}
                style={styles.avatar}
              />
            </CardItem>

            <CardItem>
              <Left>
                <Label>Username:</Label>
              </Left>
              <Body>
                <Text>Test</Text>
              </Body>
            </CardItem>

            <CardItem>
              <Left>
                <Label>Email:</Label>
              </Left>
              <Body>
                <Text>test@gmail.com</Text>
              </Body>
            </CardItem>

            <CardItem style={{ padding: 0 }}>
              <Left/>
              <Body>
                <Button danger small
                  onPress={this.verifyEmail}
                >
                  <Text>Verify</Text>
                </Button>
              </Body>
            </CardItem>

            <CardItem>
              <Left>
                <Label>Day created:</Label>
              </Left>
              <Body>
                <Text>July 16th, 2018</Text>
              </Body>
            </CardItem>
          </Card>
        </Content>
      </Container>
    );
  }
}

const styles = StyleSheet.create({
  avatar: {
   height: 200,
   width:  200,
   borderRadius: 200,
   borderWidth: 1,
   borderColor: 'grey'
 },

 centerContent: {
   flex: 1,
   justifyContent: 'center'
 }
})
