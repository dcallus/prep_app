import React from 'react';

import { createStackNavigator } from '@react-navigation/stack';
import { NavigationContainer } from '@react-navigation/native';

import Tabs from './app/navigation/tabs';
import { Splash, Home, Company, Basket } from './app/screens';

const Stack = createStackNavigator();


const App = () => {

  return (
    <NavigationContainer>
      <Stack.Navigator
      screenOptions={{
        headerShown: false
      }}
      initialRouteName={"Home"}
      >
        <Stack.Screen name="home" component={Tabs} />
        <Stack.Screen name="company" component={Company} />
        <Stack.Screen name="splash" component={Splash} />
        <Stack.Screen name="basket" component={Basket} />
      </Stack.Navigator>
    </NavigationContainer>
  );
} 

export default App;