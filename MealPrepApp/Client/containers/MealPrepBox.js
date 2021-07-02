import React from "react";
import { StyleSheet, Text, View, ActivityIndicator, Image } from 'react-native';

const  MealPrepBox = ({foodItems}) => {

return (
    <View>
        <Text>{foodItems}</Text>
    </View>
)

}

export default MealPrepBox;