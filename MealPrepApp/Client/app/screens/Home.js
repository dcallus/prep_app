import React, {useState, useEffect} from 'react';
import { Text, View, StyleSheet, SafeAreaView, TouchableOpacity, FlatList, Image } from "react-native";
import RNRestart from 'react-native-restart';

import colors from '../constants/colors';
import ShopServices from '../../services/ShopServices';

import { icons, images, SIZES, COLORS, FONTS } from '../constants';

const Home = ({ route, navigation }) => {

    const [items, setItems] = useState([]);

    useEffect(() => {
        ShopServices.getShop()
            .then(items => setItems(items))
    });


    function renderCompaniesList() {
        
        const renderItem = ({ item }) => (
           
                <TouchableOpacity
                    style={{ marginBottom: SIZES.padding *2}}
                    onPress={() => navigation.navigate("Company", {
                        item,
                    })}
                >
                    {/* Image */}
                    <View
                        style={{
                            marginBottom: SIZES.padding
                        }}
                    >
                        <Image
                            source={{uri: item.logo}}
                            resizeMode="cover"
                            style={{
                                width: "100%",
                                height: 200,
                                borderRadius: SIZES.radius
                            }}
                        />

                        <View
                            style={{
                                position: 'absolute',
                                bottom: 0,
                                height: 40,
                                width: SIZES.width * 0.25,
                                backgroundColor: COLORS.white,
                                borderTopRightRadius: SIZES.radius,
                                borderBottomLeftRadius: SIZES.radius,
                                alignItems: 'center',
                                justifyContent: 'center',
                                ...styles.shadow
                            }}
                        >
                            <View
                        style={{
                            marginTop: SIZES.padding,
                            flexDirection: 'row',
                            bottom: 4
                        }}
                    >
                        <Image 
                            source={icons.star}
                            style={{
                                height: 20,
                                width: 20,
                                tintColor: COLORS.grassgreen,
                                marginRight: 10,
                            }}
                        />
                        <Text style={{ ...FONTS.body3 }}>{item.rating}</Text>
                        
                    </View>
                        </View>
                    </View>

                    {/* Restaurant Info */}
                    <Text style={{ ...FONTS.body2 }}>{item.name}</Text>
                    
                    {/* Rating */}
                    
                </TouchableOpacity>
        )
            return (
                // ORDER NOW text and list of companies
                <View style={{padding: SIZES.padding *1.5}}>
                    <Text style={{ ...FONTS.h1, fontWeight: "800", paddingBottom: 20, paddingLeft: 17 }}>ORDER NOW</Text>
                <FlatList
                data={items}
                keyExtractor={item => `${item.id}`}
                renderItem={renderItem}
                contentContainerStyle={{
                    paddingHorizontal: SIZES.padding * 2,
                    paddingBottom: 80
                }}
                />
                </View>
            )            
    }

    function renderHeader() {
        return (
            <View style={{ flexDirection: 'row', height: 50 }}>
                <TouchableOpacity //LOGO
                    style={{
                        width: 50, 
                        paddingLeft: SIZES.padding *2,
                        justifyContent: 'center'
                    }}
                >
                    <Image
                        source={icons.logo_icon}
                        resizeMode="contain"
                        style={{
                            width: 55,
                            height: 50
                        }}
                    />
                </TouchableOpacity>

                <View style={{ flex: 1, alignItems: 'center', justifyContent: 'center'}}>
                        <View //POSTCODE ENTRY FIELD
                            style={{
                                width: "75%",
                                height: "100%",
                                backgroundColor: COLORS.lightGray3,
                                alignItems: 'center',
                                justifyContent: 'center',
                                borderRadius: SIZES.radius
                            }}
                        >
                            <Text style={{ ...FONTS.h3, color: "grey"}}>Enter postcode...</Text>
                        </View>
                </View>

                <TouchableOpacity // SETTINGS COG ICON
                    style={{
                        width: 50,
                        paddingRight: SIZES.padding *2,
                        justifyContent: 'center'
                    }}
                    >
                        <Image
                            source={icons.settings}
                            resizeMode="contain"
                            style={{
                                width: 35, 
                                height: 35,
                                right: 15,
                            }}
                        />
                </TouchableOpacity>
            </View>
        )
    }


    return (
        <SafeAreaView style={styles.container}>
            {renderHeader()}
            {renderCompaniesList()}
        </SafeAreaView>
    )
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


export default Home;