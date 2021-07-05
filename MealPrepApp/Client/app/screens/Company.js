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
    
        const [company, setCompany] = useState(null);
        const [menu, setMenu] = useState(null);
        
        useEffect(() => {
            let {item} = route.params;
            setCompany(item)
        }, [])
        
        useEffect(() => {
            ShopServices.getShopMenu(company?.id)
                .then(items => setMenu(items))
        }, []);

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
                        {/* <Text>{menu?.setMealList[0].name}</Text> */}
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

    return (
        <SafeAreaView style={styles.container}>
            {renderHeader()}
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