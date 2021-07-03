import { StatusBar } from 'expo-status-bar';
import React, { useState, useEffect } from 'react';
import { 
  StyleSheet, 
  Dimensions,
  Text, 
  View,
  SafeAreaView, 
  ActivityIndicator, 
  Image, 
  TouchableWithoutFeedback } from 'react-native';
import MealAppService from './services/MealAppService';
import MealPrepBox from './containers/MealPrepBox';
import MyHeader from './components/MyHeader';
import {useDeviceOrientation, useDimensions} from '@react-native-community/hooks';
import WelcomeScreen from './app/screens/WelcomeScreen';
// import { createStackNavigator } from '@react-navigator/stack';

// const Stack = createStackNavigator();

export default function App() {
  // console.log(useDimensions());
  // console.log(useDeviceOrientation());
  // const [items, setItems] = useState([]);


  // useEffect(() => {
  //   MealAppService.getFoodItem()
  //       .then(items => setItems(items))
  // }, []);

  // useEffect(() => {
  //   console.log("list of items: ", items);
  // }, [items])
  
  // const foodItems = items.map((item, key) => {
  //   return <SafeAreaView key={key} style={styles.item}>
  //   <Text> {item.name} </Text>
  //   <TouchableWithoutFeedback onPress={() => console.log("image tapped")}>
  //   <Image source={{
  //     width: '100%', 
  //     height: 150,
  //     uri: item.imageUrl
  //     }} 
  //     />
  //   </TouchableWithoutFeedback>
  //   </SafeAreaView>
  // }) 

  // <MealPrepBox foodItems={foodItems}></MealPrepBox>

  return (
  <WelcomeScreen />
  );
} 

// const styles = StyleSheet.create({
//   container: {
//     flex: 1,
//     backgroundColor: '#fff',
//     alignItems: 'center',
//     justifyContent: 'center',
//   },
//   item: {
//     flex: 1,
//     width: '100%',
//     height: '20%',
//     fontWeight: 'bold',
//     alignSelf: 'stretch',
//     flexDirection: 'row',
//     margin: 10,
//     alignItems: 'center',
//     justifyContent: 'center',
//     borderBottomWidth: 1, 
//     borderBottomColor: 'black'
//   }
// });
