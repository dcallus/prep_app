import React, { useState, useEffect } from 'react';

import {View, Text, StyleSheet, SafeAreaView} from "react-native";

import { icons, images, SIZES, COLORS, FONTS } from '../constants';

function Basket({ route, navigation }) {

    const [company, setCompany] = useState(null);
    const [orderItems, setOrderItems] = useState([]);
    const [menu, setMenu] = useState(null);

    console.log(menu);

    useEffect(() => {
        let { company, orderItems, menu } = route.params; 
        setCompany(company);
        setOrderItems(orderItems);
        setMenu(menu.setMealList);
        // console.log(orderItems);
    }, [])

    // function getOrderDetails() {
    //     orderItems.filter((item) => 
    // }
          

    
    

    return (
        <SafeAreaView style={styles.container}>
            <Text>Basket Screen</Text>
            <Text>{company?.name}</Text>
            {/* <Text> ? { orderItems[0].id} : null </Text> */}
            {/* {getOrderDetails()} */}
        </SafeAreaView>
    );
}

const styles = StyleSheet.create({
    container: {
    flex: 1,
    backgroundColor: COLORS.lightGray2,
    }
})

export default Basket;