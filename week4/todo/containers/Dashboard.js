import React from 'react';
import {
  Container, Tabs, Tab, TabHeading, Text, Header, Icon, Left, Body, Title,
  Right, Button
} from 'native-base';
import { connect } from 'react-redux';
import TasksList from '../components/TasksList';
import TaskInput from '../components/TaskInput';
import HeaderBar from '../components/HeaderBar';
import { footerTabBackground } from '../theme/Dark';

const mapStateToProps = (state) => {
  return {
    tasks: state.tasks
  }
}

const tabHeading = (label, icon) => (
  <TabHeading style={footerTabBackground}>
    <Icon type={'MaterialIcons'} name={icon} size={25}/>
    <Text>{label}</Text>
  </TabHeading>
)

class Dashboard extends React.Component {
  render() {
    return (
      <Container>
        {/* Header */}
        <HeaderBar navigation={this.props.navigation}/>

        {/* Content */}
        <Tabs tabBarPosition="bottom">
          {/* All tasks */}
          <Tab heading={tabHeading('All', 'apps')}>
            <TaskInput/>
            <TasksList tasks={this.props.tasks} />
          </Tab>

          {/* Active tasks */}
          <Tab heading={tabHeading('Active', 'directions-run')}>
            <TasksList
              tasks={this.props.tasks.filter(task => !task.completed)}
            />
          </Tab>

          {/* Finished tasks */}
          <Tab heading={tabHeading('Finished', 'playlist-add-check')}>
            {/* Display tasks list */}
            <TasksList
              tasks={this.props.tasks.filter(task => task.completed)}
            />
          </Tab>
        </Tabs>
      </Container>
    );
  }
}

export default connect(mapStateToProps, null)(Dashboard)
