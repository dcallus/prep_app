import React from "react";
import { StyleSheet, Text, View, ActivityIndicator, Image, SafeAreaView, Button, Alert, ScrollView } from 'react-native';

const  MealPrepBox = ({foodItems}) => {

    const handlePress = () => {
        alert("Opens restaurant details...")
    }

    const showAlert = () => 
    Alert.alert(
        "Alert Title",
        "My Alert Msg",
        [
            {
                text: "Cancel",
                onPress: () => Alert.alert("Cancel Pressed"),
                style: "cancel",
            },
        ],
    {
        cancelable: true,
        onDismiss: () =>
        Alert.alert(
            "This alert was dismissed by tapping outside of the alert dialog."
        ),
    }
    );

return (
    <View style={StyleSheet.container} onPress={handlePress}>
        <ScrollView style={{flex: 1}}>
        <Text>{foodItems}</Text>
        <Button 
        color="orange" 
        onPress={() => 
            Alert.alert("My Title", "My Message", [
            {text: "Yes", onPress: () => console.log("Yes")},
            {text: "No", onPress: () => console.log("No")}
        ])} />
        </ScrollView>
        {/* <Button title="Show alert" onPress={showAlert} /> */}
    </View>
)

}

export default MealPrepBox;

