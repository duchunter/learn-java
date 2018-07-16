import { createDrawerNavigator } from 'react-navigation'
import DashboardStack from './DashboardStack'
import Profile from '../containers/Profile'
import CustomDrawerContent from '../containers/CustomDrawerContent'

const AppStack = createDrawerNavigator(
  {
    Dashboard: DashboardStack,
    Profile: Profile
  },
  {
    initialRouteName: 'Dashboard',
    contentComponent: CustomDrawerContent,
    contentOptions: {
      labelStyle: {
        fontSize: 18
      }
    }
  }
);

export default AppStack;
