import { createSwitchNavigator } from 'react-navigation'
import AppStack from './AppStack'
import AuthStack from './AuthStack'
import AuthLoadingScreen from '../containers/AuthLoadingScreen'

const RootStack = createSwitchNavigator(
  {
    AuthLoading: AuthLoadingScreen,
    App: AppStack,
    Auth: AuthStack
  },
  {
    initialRouteName: 'Auth',
  }
);

export default RootStack;
