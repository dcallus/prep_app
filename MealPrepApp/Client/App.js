import { StatusBar } from 'expo-status-bar';
import React, { useState, useEffect } from 'react';
import { StyleSheet, Text, View, ActivityIndicator, Image } from 'react-native';
import MealAppService from './services/MealAppService';
import MealPrepBox from './containers/MealPrepBox';
import MyHeader from './components/MyHeader';
// import { createStackNavigator } from '@react-navigator/stack';

// const Stack = createStackNavigator();

export default function App() {

  const [items, setItems] = useState([]);

  useEffect(() => {
    MealAppService.getFoodItem()
        .then(items => setItems(items))
  }, []);

  useEffect(() => {
    console.log("list of items: ", items);
  }, [items])
  
  const foodItems = items.map((item, key) => {
    return <View key={key} style={styles.item}>
    <Text> {item.name} </Text>
    </View>
  }) 

  return (
    <>
    {/* <MyHeader>Meal Prep App!</MyHeader> */}
    <MealPrepBox foodItems={foodItems}></MealPrepBox>
    {/* <View style={styles.container}> */}
      {/* <Text>Hello, World!!</Text> */}
      {/* <Text>{foodItems}</Text> */}
      {/* <StatusBar style="auto" /> */}
    {/* </View> */}
    </>
  );
} 

const styles = StyleSheet.create({
  container: {
    flex: 1,
    // backgroundColor: '#fff',
    alignItems: 'center',
    justifyContent: 'center',
  },
  item: {
    flex: 1,
    width: '100%',
    height: '100%',
    alignSelf: 'stretch',
    flexDirection: 'row',
    margin: 10,
    alignItems: 'center',
    justifyContent: 'center',
    borderBottomWidth: 1, 
    borderBottomColor: '#eee'
  }
});
