import { createDrawerNavigator } from 'react-navigation'
import DashboardStack from './DashboardStack'
import Profile from '../containers/Profile'
import SideBar from '../components/SideBar'

const AppStack = createDrawerNavigator(
  {
    Dashboard: DashboardStack,
    Profile: Profile
  },
  {
    initialRouteName: 'Dashboard',
    contentComponent: SideBar
  }
);

export default AppStack;
