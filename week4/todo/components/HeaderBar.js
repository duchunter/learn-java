import React from 'react';
import {
  Icon, Left, Body, Title, Right, Button, Header
} from 'native-base';
import { headerBackground } from '../theme/Dark';

export default AllTasks = (props) => {
  return (
    <Header style={headerBackground}>
      <Left>
        <Button transparent
          onPress={() => props.navigation.openDrawer()}
        >
          <Icon name={'menu'}/>
        </Button>
      </Left>
      <Body>
        <Title>Todo App</Title>
      </Body>
      <Right>
      <Button transparent>
        <Icon name={'settings'}/>
      </Button>
      </Right>
    </Header>
  );
}
