import React from 'react';
import { Container, Content, Text } from 'native-base';
import TasksListItem from './TasksListItem';

export default class TasksList extends React.Component {
  render() {
    return (
      <Container>
        {this.props.tasks.length > 0
          ? (
            <Content padder>
              {this.props.tasks.map(task => (
                <TasksListItem item={task} key={task.id} />
              ))}
            </Content>
          )
          : (
            <Content contentContainerStyle={{
              flex: 1,
              justifyContent: 'center',
              alignItems: 'center'
            }}>
              <Text> Nothing to show </Text>
            </Content>
          )
        }
      </Container>
    )
  }
}
