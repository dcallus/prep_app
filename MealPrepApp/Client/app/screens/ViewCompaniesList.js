import React, {useState, useEffect} from 'react';
import { Text, View, StyleSheet, Image } from "react-native";

import colors from '../config/colors';
import MealAppService from '../../services/MealAppService';


function ViewCompaniesList(props) {

    const [items, setItems] = useState([]);
    console.log(items);

    useEffect(() => {
        MealAppService.getFoodItem()
            .then(items => setItems(items))
    }, []);

    const foodItems = items.map((item, key) => {
        return (
            <View style={styles.companyListContainer}>
                <View>
                    <Image style={styles.image} source={{uri: item.imageUrl}}/>
                    <Text> {item.name} </Text>
                </View>
            </View>
        )}) 
        console.log(foodItems[0]);


    return (
        <View>
            <View style={styles.background}>
                <View style={styles.header}/>
                <View style={styles.logoContainer}>
                    <Image style={styles.logo} source={require("../assets/images/logo2.png")}/>
                </View>
            </View>
            <View>{foodItems}</View>
        </View>
    );
}


const styles = StyleSheet.create({
    background: {
        flex: 1, // sets the image background to entire screen
        // justifyContent: "space-between",
        alignItems: "center"
    },
    header: {
        width: "100%", 
        height: 135,
        backgroundColor: colors.black,
        alignItems: "flex-start", 
    },
    postcodeField: {
        backgroundColor: colors.white,
        width: "80%", 
        height: 100,
        borderRadius: 30
    },
    logoContainer: {
        position: "absolute",
        top: 20, 
        flexDirection: "row"
    },
    logo: {
        width: 480, 
        height: 100,
        alignItems: "center"
    },
    logoText: {
        color: "white",
        fontSize: 40
    },
    footer: {
        width: "100%", 
        height: 90,
        backgroundColor: colors.grassgreen
    },
    companyListContainer: {
        
    },
    image: {
        width: '90%', 
        height: 250,
    }

})

export default ViewCompaniesList;