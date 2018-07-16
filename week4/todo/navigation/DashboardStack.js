import { createBottomTabNavigator } from 'react-navigation';
import AllTasks from '../containers/AllTasks';
import FinishedTasks from '../containers/FinishedTasks';
import ActiveTasks from '../containers/ActiveTasks';

const DashboardStack = createBottomTabNavigator(
  {
    All: AllTasks,
    Active: ActiveTasks,
    Finished: FinishedTasks
  },
  {
    initialRoute: 'All',
    tabBarOptions: {
      activeTintColor: 'blue',
      inactiveTintColor: 'gray',
      style: {
        height: 50,
      },
      labelStyle: {
        fontSize: 15
      }
    }
  }
);

export default DashboardStack;
