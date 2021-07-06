import React, { useEffect, useState } from 'react';

import {
    View, 
    Text,
    SafeAreaView,
    StyleSheet,
    TouchableOpacity,
    Image,
    Animated
} from "react-native";

import { icons, images, SIZES, COLORS, FONTS } from '../constants';
import ShopServices from '../../services/ShopServices';

function Company({ route, navigation }) {
    
        const scrollX = new Animated.Value(0);
        const [company, setCompany] = useState(null);
        const [menu, setMenu] = useState(null);
        // const [orderQuantity, setOrderQuantity] = useState(0);
        // const [currentMenuId, setCurrentMenuId] = useState(null);
        const [orderItems, setOrderItems] = useState([]);
        
        useEffect(() => {
            let {item} = route.params;
            setCompany(item)
            ShopServices.getShopMenu(company?.id)
            .then(items => setMenu(items))
        }, [company])

        // useEffect(() => {
        //     orderQuantity
        // }, [getOrderQuantity])
        
        // useEffect(() => {
        //     ShopServices.getShopMenu(company?.id)
        //         .then(items => setMenu(items))
        // }, []);

        function editOrder(action, itemId) {
            
            let orderList = orderItems.slice() 
            let item = orderList.filter(item => item.id == itemId)

            if (action == "+") {
                if (item.length > 0) {
                    let newQty = item[0].qty + 1
                    item[0].qty = newQty
                } else {
                    const newItem = {
                        menuId: itemId,
                        qty: 1
                    }
                    orderList.push(newItem)
                }
    
                setOrderItems(orderList)
            } else {
                if (item.length > 0) {
                    if (item[0]?.qty > 0) {
                        let newQty = item[0].qty - 1
                        itemArray[0].qty = newQty
                    }
                }
    
                setOrderItems(orderList)
            }
            console.log(orderList);
        }
            
    
        function getOrderQuantity(itemId) {
            let orderItem = orderItems.filter(item => item.id == itemId)

            if (orderItem.length > 0) {
                return orderItem[0].qty
            }
    
            return 0
        }

    function renderHeader() {
        return (
            <View style={{ flexDirection: 'row' }}>
                <TouchableOpacity
                    style={{
                        width: 50,
                        paddingLeft: SIZES.padding * 2,
                        justifyContent: 'center'
                    }}
                    onPress={() => navigation.goBack()}
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
                        <Text style={{ ...FONTS.h3 }}>{company?.name}</Text>
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
        )
    }

    function renderFoodInfo() {
        
        return (
            <Animated.ScrollView
                horizontal
                pagingEnabled
                scrollEventThrottle={16}
                snapToAlignment="center"
                showsHorizontalScrollIndicator={false}
                onScroll={Animated.event([
                    { nativeEvent: { contentOffset: { x: scrollX } } }
                ], { useNativeDriver: false })}
            >
                {
                    menu?.setMealList.map((item, index) => (
                        <View
                            key={`menu-${index}`}
                            style={{ alignItems: 'center' }}
                        >
                            <View style={{ height: SIZES.height * 0.35 }}>
                                {/* Food Image */}
                                <Image
                                    source={item.imageUrl}
                                    resizeMode="contain"
                                    style={{
                                        width: SIZES.width,
                                        height: "100%",
                                        borderRadius:20
                                    }}
                                />

                                {/* Quantity */}
                                <View
                                    style={{
                                        position: 'absolute',
                                        bottom: - 20,
                                        width: SIZES.width,
                                        height: 50,
                                        justifyContent: 'center',
                                        flexDirection: 'row'
                                    }}
                                >
                                    <TouchableOpacity
                                        style={{
                                            width: 50,
                                            backgroundColor: COLORS.white,
                                            alignItems: 'center',
                                            justifyContent: 'center',
                                            borderTopLeftRadius: 25,
                                            borderBottomLeftRadius: 25
                                        }}
                                        onPress={() => editOrder("-", item?.id)}
                                    >
                                        <Text style={{ ...FONTS.body1 }}> - </Text>
                                    </TouchableOpacity>

                                    <View
                                        style={{
                                            width: 50,
                                            backgroundColor: COLORS.white,
                                            alignItems: 'center',
                                            justifyContent: 'center'
                                        }}
                                    >
                                          <Text style={{ ...FONTS.h2 }}>{getOrderQuantity(item.id)}</Text>
                                    </View>

                                    <TouchableOpacity
                                        style={{
                                            width: 50,
                                            backgroundColor: COLORS.white,
                                            alignItems: 'center',
                                            justifyContent: 'center',
                                            borderTopRightRadius: 25,
                                            borderBottomRightRadius: 25
                                        }}
                                        onPress={() => editOrder("+", item?.id)}
                                    >
                                        <Text style={{ ...FONTS.body1 }}> + </Text>
                                    </TouchableOpacity>
                                </View>
                            </View>

                            {/* Name & Description */}
                            <View
                                style={{
                                    width: SIZES.width,
                                    alignItems: 'center',
                                    marginTop: 15,
                                    paddingHorizontal: SIZES.padding * 2
                                }}
                            >
                                <Text style={{ marginVertical: 10, textAlign: 'center', ...FONTS.h2 }}>{item.name}</Text>
                                <Text style={{ ...FONTS.body3 }}>{item.description}</Text>
                            </View>

                            {/* Calories */}
                            <View
                                style={{
                                    flexDirection: 'row',
                                    marginTop: 10
                                }}
                            >
                                <Image
                                    source={icons.fire}
                                    style={{
                                        width: 20,
                                        height: 20,
                                        marginRight: 10
                                    }}
                                />

                                <Text style={{
                                    ...FONTS.body3, color: COLORS.darygray
                                }}>{item.calories} cal - P:{item.protein} F:{item.fats} C:{item.carbs}</Text>
                            </View>
                        </View>
                    ))
                }
            </Animated.ScrollView>
        )
    }

    return (
        <SafeAreaView style={styles.container}>
            {renderHeader()}
            {renderFoodInfo()}
        </SafeAreaView>
    );
}

const styles = StyleSheet.create({
    container: {
    flex: 1,
    backgroundColor: COLORS.lightGray2,
    }
})

export default Company;