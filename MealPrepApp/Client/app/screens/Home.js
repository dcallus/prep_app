import React, {useState, useEffect} from 'react';
import { Text, View, StyleSheet, SafeAreaView, TouchableOpacity, FlatList, Image } from "react-native";


import colors from '../constants/colors';
import MealAppService from '../../services/MealAppService';

import { icons, images, SIZES, COLORS, FONTS } from '../constants';

const Home = () => {

    const [items, setItems] = useState([]);
    console.log(items);

    useEffect(() => {
        MealAppService.getFoodItem()
            .then(items => setItems(items))
    }, []);

    function renderCompaniesList() {
        const renderItem = ({ item }) => (
           
                <TouchableOpacity
                    style={{ marginBottom: SIZES.padding *2}}
                >
                    {/* Image */}
                    <View
                        style={{
                            marginBottom: SIZES.padding
                        }}
                    >
                        <Image
                            source={{uri: item.imageUrl}}
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
                        <Text style={{ ...FONTS.body3 }}>{item.price}</Text>
                        
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

    // function renderCompanyList() {

    //     const renderItem = ({item}) => {
    //         return (
    //             <TouchableOpacity
    //                 style={{
    //                     padding: SIZES.padding,
    //                     paddingBottom: SIZES.padding *2,
    //                     backgroundColor: COLORS.grassgreen,
    //                     borderRadius: SIZES.radius,
    //                     alignItems: 'center',
    //                     justifyContent: 'center',
    //                     marginRight: SIZES.padding,
    //                     ...styles.shadow
    //                 }}
    //                 onPress={() => onSelectCategory(item)}
    //             >
    //                 <View
    //                     style={{
    //                         width: 50, 
    //                         height: 50, 
    //                         borderRadius: 25,
    //                         alignItems: 'center',
    //                         justifyContent: 'center',
    //                         backgroundColor: (selectedCategory?.id == item.id) ? COLORS.white : COLORS.lightGray
    //                     }}
    //                 >
    //                     <Image 
    //                         source={item.icon}
    //                         resizeMode='contain'
    //                         style={{
    //                             width: 30,
    //                             height: 30
    //                         }}
    //                     />
    //                 </View>

    //                 <Text
    //                     style={{
    //                         marginTop: SIZES.padding,
    //                         color: COLORS.white,
    //                         ...FONTS.body5
    //                     }}
    //                 >
    //                     {item.name}
    //                 </Text>
    //             </TouchableOpacity>
    //         )
    //     }
    //     return (
    //         <View style={{padding: SIZES.padding *2}}>
    //             <Text style={{ ...FONTS.h1, fontWeight: "800" }}>ORDER NOW</Text>

    //             <FlatList
    //                 // data={categories}
    //                 horizontal
    //                 showsHorizontalScrollIndicator={false}
    //                 keyExtractor={item => {item.id}}
    //                 renderItem={renderItem}
    //                 contentContainerStyle={{ paddingVertical: SIZES.padding }}
    //             />
    //         </View>
    //     )
    // }

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

// function Home(props) {

//     const [items, setItems] = useState([]);
//     console.log(items);

//     useEffect(() => {
//         MealAppService.getFoodItem()
//             .then(items => setItems(items))
//     }, []);

//     const foodItems = items.map((item, key) => {
//         return (
//             <View style={styles.companyListContainer}>
//                 <View>
//                     <Image style={styles.image} source={{uri: item.imageUrl}}/>
//                     <Text> {item.name} </Text>
//                 </View>
//             </View>
//         )}) 
//         console.log(foodItems[0]);


//     return (
//         <View>
//             <View style={styles.background}>
//                 <View style={styles.header}/>
//                 <View style={styles.logoContainer}>
//                     <Image style={styles.logo} source={require("../assets/images/logo2.png")}/>
//                 </View>
//             </View>
//             <View>{foodItems}</View>
//         </View>
//     );
// }


// const styles = StyleSheet.create({
//     background: {
//         flex: 1, // sets the image background to entire screen
//         // justifyContent: "space-between",
//         alignItems: "center"
//     },
//     header: {
//         width: "100%", 
//         height: 135,
//         backgroundColor: colors.black,
//         alignItems: "flex-start", 
//     },
//     postcodeField: {
//         backgroundColor: colors.white,
//         width: "80%", 
//         height: 100,
//         borderRadius: 30
//     },
//     logoContainer: {
//         position: "absolute",
//         top: 20, 
//         flexDirection: "row"
//     },
//     logo: {
//         width: 480, 
//         height: 100,
//         alignItems: "center"
//     },
//     logoText: {
//         color: "white",
//         fontSize: 40
//     },
//     footer: {
//         width: "100%", 
//         height: 90,
//         backgroundColor: colors.grassgreen
//     },
//     companyListContainer: {
        
//     },
//     image: {
//         width: '90%', 
//         height: 250,
//     }

// });

export default Home;