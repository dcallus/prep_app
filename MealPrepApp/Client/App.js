import { StatusBar } from 'expo-status-bar';
import React, { useState, useEffect } from 'react';
import { StyleSheet, Text, View, Image } from 'react-native';
import MealAppService from './services/MealAppService';

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
    return <View key={key} style={styles.container}>
    <Text> Meal Name: {item.name} </Text>
    </View>
  }) 

  return (
    items ?
    <View style={styles.container}>
      <Text>Hello, World!!</Text>
      <Text>{foodItems}</Text>
      <StatusBar style="auto" />
    </View>
    :
    <View></View>
  );
} 

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#fff',
    alignItems: 'center',
    justifyContent: 'center',
  },
});
