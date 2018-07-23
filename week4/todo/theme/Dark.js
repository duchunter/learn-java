import { Platform } from 'react-native'

const isIos = Platform.OS == 'ios'

export const font = {
  color: '#212121'
}

export const headerFont = {
	color: isIos ? 'white' : 'black'
}

export const headerBackground = {
  backgroundColor: isIos ? '#060606' : '#212121'
}

export const footerTabBackground = {
  backgroundColor: '#060606'
}
