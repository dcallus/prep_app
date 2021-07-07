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
        const [orderQuantity, setOrderQuantity] = useState(0);
        const [orderTotal, setOrderTotal] = useState(0);
        
        useEffect(() => {
            // setCompany(null)
            let {item} = route.params;
            setCompany(item)
            
            ShopServices.getShopMenu(company?.id)
            .then(items => setMenu(items))
        })

        // useEffect(() => {
        //     orderTotal
        // }, [getOrderQuantity])


        function editOrder(action, selectedItem) {
            
            let orderList = orderItems.slice() 
            let currentItem = orderList.filter(item => item.menuId == selectedItem.id)

            if (action == "+") {
                if (currentItem.length > 0) {
                    let newQty = currentItem[0].qty + 1
                    currentItem[0].qty = newQty
                } else {
                    const currentItem = {
                        name: selectedItem,
                        menuId: selectedItem.id,
                        qty: 1
                    }
                    orderList.push(currentItem)
                }
    
                setOrderItems(orderList)
            } else {
                if (currentItem.length > 0) {
                    if (currentItem[0]?.qty > 0) {
                        let newQty = currentItem[0].qty - 1
                        currentItem[0].qty = newQty
                    }
                }
    
                setOrderItems(orderList)
            }
            // console.log(orderList);
        }
            
        function getOrderQuantity(selectedItem) {
            let orderItem = orderItems.filter(item => item.menuId == selectedItem.id)

            if (orderItem.length > 0) {
                return orderItem[0].qty
            }
    
            return 0
        }

        function getOrderCount() {
            let itemCount = orderItems.reduce((counter, item) => counter + (item.qty || 0), 0)
            return itemCount;
        }

        function getOrderTotal() {
            let total = orderItems.reduce((counter, item) => counter + (item.name.price * item.qty || 0), 0)
            // setOrderTotal(total);
            return total.toFixed(2);
        }

    function renderHeader() {
        return (
            <View style={{ flexDirection: 'row' }}>
                <TouchableOpacity
                    style={{
                        width: 50,
                        paddingLeft: SIZES.padding * 2,
                        justifyContent: 'center',
                        paddingBottom: 80
                    }}
                    onPress={() => navigation.navigate("Home")}
                    // onPress={() => this.props.navigation.push("Home")}
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
                            height: 30,
                            tintColor: COLORS.lightGray2
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
                    menu?.setMealList.map((selectedItem, index) => (
                        <View
                            key={`menu-${index}`}
                            style={{ alignItems: 'center' }}
                        >
                            <View style={{ height: SIZES.height * 0.35 }}>
                                {/* Food Image */}
                                <Image
                                    source={{uri: selectedItem.imageUrl}}
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
                                        onPress={() => editOrder("-", selectedItem)}
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
                                          <Text style={{ ...FONTS.h2 }}>{getOrderQuantity(selectedItem)}</Text>
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
                                        onPress={() => editOrder("+", selectedItem)}
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
                                <Text style={{ marginVertical: 10, textAlign: 'center', ...FONTS.h2 }}>{selectedItem.name}</Text>
                                <Text style={{ ...FONTS.body3 }}>{selectedItem.description}</Text>
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
                                }}>{selectedItem.calories} cal - P:{selectedItem.protein} F:{selectedItem.fats} C:{selectedItem.carbs}</Text>
                            </View>
                        </View>
                    ))
                }
            </Animated.ScrollView>
        )
    }

    function renderOrder() {
        return (
            <View>
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
                        <Text style={{ ...FONTS.h3 }}> {getOrderCount()} items in Cart</Text>
                        <Text style={{ ...FONTS.h3 }}> £{getOrderTotal()}</Text>
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
                            onPress={() => navigation.navigate("Basket", {
                                company: company,
                                orderItems: orderItems,
                                menu: menu,
                                total: {getOrderTotal}
                            })}
                        >
                            <Text style={{ color: COLORS.white, ...FONTS.h2 }}>Order</Text>
                        </TouchableOpacity>
                    </View>
 
                </View>


            </View>
        )
    }

    return (
        <SafeAreaView style={styles.container}>
            {renderHeader()}
            {renderFoodInfo()}
            {renderOrder()}
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