import React, { useState, useEffect } from 'react';

import {View, Text, StyleSheet, SafeAreaView, Image, TouchableOpacity, Animated} from "react-native";

import { icons, images, SIZES, COLORS, FONTS } from '../constants';

function Basket({ route, navigation }) {

    const scrollY = new Animated.Value(0);
    const [company, setCompany] = useState(null);
    const [orderItems, setOrderItems] = useState([]);
    const [menu, setMenu] = useState(null);

    console.log(orderItems);

    useEffect(() => {
        let { company, orderItems, menu } = route.params; 
        setCompany(company);
        setOrderItems(orderItems);
        setMenu(menu.setMealList);
        // console.log(orderItems);
    }, [])

    function completeOrder() {
        
        navigation.navigate("Home")
    }

    function renderOrderDetails() {
        const order = orderItems.map(item => {
            if (item.qty > 0)
            return (
                <View
                style={{ alignItems: 'center', 
                flex: 1, 
                flexDirection: "row", 
                justifyContent: "space-around"}}
                key={item => `basket-${item.id}`}
                >
                    <Text style={{
                        flex: 0.75
                    }}>{item.name.name} x {item.qty}</Text>
                    <Image
                        source={{uri: item.name.imageUrl}}
                        resizeMode="contain"
                        style={{
                            width: SIZES.width/2,
                            height: "100%",
                            borderRadius:20,
                            flex: 0.25
                        }}
                    />
                </View>
            )
        })
        return order;
    }

    function renderHeader() {
        return (
            <View>
            <View style={{ flexDirection: 'row' }}>
                <TouchableOpacity
                    style={{
                        width: 50,
                        paddingLeft: SIZES.padding * 2,
                        justifyContent: 'center'
                    }}
                    onPress={() => navigation.navigate("Company")}
                >
                    <Image
                        source={icons.back}
                        resizeMode="contain"
                        style={{
                            width: 30,
                            height: 30
                        }}
                    />
                </TouchableOpacity>

                {/* Restaurant Name Section */}
                <View
                    style={{
                        flex: 1,
                        alignItems: 'center',
                        justifyContent: 'center'
                    }}
                >
                    <View
                        style={{
                            height: 50,
                            alignItems: 'center',
                            justifyContent: 'center',
                            paddingHorizontal: SIZES.padding * 3,
                            borderRadius: SIZES.radius,
                            borderWidth: 1,
                            borderColor: COLORS.lightGray1,
                            backgroundColor: COLORS.lightGray3
                        }}
                    >
                        <Text style={{ ...FONTS.h3 }}>Your Basket</Text>
                    </View>
                </View>

                <TouchableOpacity
                    style={{
                        width: 50,
                        paddingRight: SIZES.padding * 2,
                        justifyContent: 'center'
                    }}
                >
                    <Image
                        source={icons.list}
                        resizeMode="contain"
                        style={{
                            width: 30,
                            height: 30
                        }}
                    />
                </TouchableOpacity>
            </View>

            <View
            style={{
                padding: SIZES.padding * 2,
                alignItems: 'center',
                justifyContent: 'center'
            }}
            >
            <TouchableOpacity
                style={{
                    width: SIZES.width * 0.9,
                    padding: SIZES.padding,
                    backgroundColor: COLORS.primary,
                    alignItems: 'center',
                    borderRadius: SIZES.radius
                }}
                onPress={() => completeOrder()}
            >
                <Text style={{ color: COLORS.white, ...FONTS.h2 }}>Pay Now</Text>
            </TouchableOpacity>
            </View>
            </View>
        )
    }
          
    return (

        <Animated.ScrollView
                vertical
                pagingEnabled
                scrollEventThrottle={16}
                snapToAlignment="center"
                showsHorizontalScrollIndicator={false}
                onScroll={Animated.event([
                    { nativeEvent: { contentOffset: { y: scrollY } } }
                ], { useNativeDriver: false })}
            >
                <SafeAreaView style={styles.container}>
                    {/* <Text> ? { orderItems[0].id} : null </Text> */}
                    {renderHeader()}
                    {renderOrderDetails()}
                </SafeAreaView>
        </Animated.ScrollView>
    );
}

const styles = StyleSheet.create({
    container: {
    flex: 1,
    backgroundColor: COLORS.lightGray2,
    }
})

export default Basket;