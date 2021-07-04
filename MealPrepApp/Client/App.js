import React from 'react';

import { createStackNavigator } from '@react-navigation/stack';
import { NavigationContainer } from '@react-navigation/native';

import { Splash, Home, Company } from './app/screens';

// import Splash from './app/screens/Splash';
// import Home from './app/screens/Home';
// import Company from './app/screens/Company';


export default function App() {

  return (
    <Splash />
  );
} 