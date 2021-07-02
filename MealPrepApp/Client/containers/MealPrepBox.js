import React from "react";
import { StyleSheet, Text, View, ActivityIndicator, Image, SafeAreaView } from 'react-native';

const  MealPrepBox = ({foodItems}) => {

    const handlePress = () => {console.log("Text pressed")}

return (
    <SafeAreaView>
        <Text onPress={handlePress}>{foodItems}</Text>
        <Image style={{width: 50, height: 50}} source={require("../assets/favicon.png")} />
    </SafeAreaView>
)

}

export default MealPrepBox;