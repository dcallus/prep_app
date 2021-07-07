import React, { useState, useEffect } from 'react';

import { View, Text, StyleSheet, SafeAreaView, Image, TouchableOpacity, Animated, Alert, FlatList } from "react-native";

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
        setCompany(null)
        setOrderItems([])
        setMenu(null)
        Alert.alert("Order complete!")
        navigation.navigate("Home")
    }

    function renderHeader() {
        return (
            <View
            style={{ paddingBottom: 50}}>
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
                            height: 30,
                            tintColor: COLORS.lightGray2
                        }}
                    />
                </TouchableOpacity>
            </View>
            <Text style={{ ...FONTS.h1, fontWeight: "800", paddingTop: 20, paddingLeft: 25 }}>ORDER SUMMARY:</Text>
            </View>
        )
    }
    

    function renderOrderDetails() {
    
        const renderItem = ({ item }) => (
    
            <View
            style={{ alignItems: 'center', 
            flex: 1, 
            flexDirection: "column", 
            justifyContent: "flex-start",
            marginLeft: 30,
            marginRight: 30,
            alignItems: "left"
            }}
            key={item => `basket-${item.id}`}
            >
                <Text style={{...FONTS.h3, marginBottom: 10 }}
                >{item.qty}x {item.name.name}</Text>
                <Image
                    source={{uri: item.name.imageUrl}}
                    resizeMode="cover"
                    style={{
                        width: "100%",
                        height: 90,
                        // borderRadius: 20,
                        flex: 1,
                        marginBottom: 10
                    }}
                />
            </View>
                
        )
            return (
                // ORDER NOW text and list of companies
                <FlatList
                data={orderItems}
                keyExtractor={item => `${item.id}`}
                renderItem={renderItem}
                contentContainerStyle={{
                    paddingHorizontal: SIZES.padding * 2,
                    paddingBottom: 20
                }}
                />
            )            
    }

    function getOrderTotal() {
        let total = orderItems.reduce((counter, item) => counter + (item.name.price * item.qty || 0), 0)
        return total.toFixed(2);
    }

    function renderPayment() {
        return (
                    <View style={{
                        position: "fixed"
                    }}>
                        <View
                            style={{
                                backgroundColor: COLORS.white,
                                borderTopLeftRadius: 40,
                                borderTopRightRadius: 40
                            }}
                        >
                            <View
                                style={{
                                    flexDirection: 'row',
                                    justifyContent: 'space-between',
                                    paddingVertical: SIZES.padding * 2,
                                    paddingHorizontal: SIZES.padding * 3,
                                    borderBottomColor: COLORS.lightGray2,
                                    borderBottomWidth: 1
                                }}
                            >
                                <Text style={{ ...FONTS.h3 }}> Total Payment Due: £{getOrderTotal()} </Text>
                            </View>
                                {/* Order Button */}
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
        </View>


        )
    }
          
    return (

            <SafeAreaView style={styles.container}>
                {renderHeader()}
                {renderOrderDetails()}
                {renderPayment()}
            </SafeAreaView>
    
    );
}

const styles = StyleSheet.create({
    container: {
        flex: 1,
        backgroundColor: COLORS.lightGray4
    },
    shadow: {
        shadowColor: '#800',
        shadowOffset: {
            width: 0,
            height: 3,
        },
        shadowOpacity: 0.1,
        shadowRadius: 3,
        elevation: 1,
    }
    
})

export default Basket;