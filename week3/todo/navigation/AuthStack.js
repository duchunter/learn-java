import { createStackNavigator } from 'react-navigation'
import LoginScreen from '../containers/LoginScreen';
import RegisterScreen from '../containers/RegisterScreen';
import ForgotPasswordScreen from '../containers/ForgotPasswordScreen';

const AuthStack = createStackNavigator(
  {
    Login: LoginScreen,
    Register: RegisterScreen,
    'Forgot Password': ForgotPasswordScreen,
  },
  {
    initialRoute: 'Login'
  }
);

export default AuthStack;
