import { createDrawerNavigator } from 'react-navigation'
import Dashboard from '../containers/Dashboard'
import Profile from '../containers/Profile'
import SideBar from '../components/SideBar'

const AppStack = createDrawerNavigator(
  {
    Dashboard: Dashboard,
    Profile: Profile
  },
  {
    initialRouteName: 'Dashboard',
    contentComponent: SideBar
  }
);

export default AppStack;
