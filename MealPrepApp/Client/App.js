import { StatusBar } from 'expo-status-bar';
import React, { useState, useEffect } from 'react';
import { StyleSheet, Text, View, ActivityIndicator, Image, TouchableWithoutFeedback } from 'react-native';
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
    <TouchableWithoutFeedback onPress={() => console.log("image tapped")}>
    <Image source={{
      width: '100%', 
      height: 150,
      uri: item.imageUrl
      }} 
      />
    </TouchableWithoutFeedback>
    </View>
  }) 

  return (
    <>

    <StatusBar style="auto" />
    <MealPrepBox foodItems={foodItems}></MealPrepBox>

    </>
  );
} 

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#fff',
    alignItems: 'center',
    justifyContent: 'center',
  },
  item: {
    flex: 1,
    width: '100%',
    height: '20%',
    fontWeight: 'bold',
    alignSelf: 'stretch',
    flexDirection: 'row',
    margin: 10,
    alignItems: 'center',
    justifyContent: 'center',
    borderBottomWidth: 1, 
    borderBottomColor: 'black'
  }
});
