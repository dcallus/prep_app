import React from 'react';
import { Image, StyleSheet, View } from "react-native";

import colors from '../config/colors';

function SplashScreen(props) {
    return (
        <>
        <View style={styles.container}>
            <Image resizeMode="contain" style={styles.image} source={require("../assets/images/logo2.png")}/>
        </View>
        </>
    );
}



const styles = StyleSheet.create({
    // closeIcon: {
    //     width: 50, 
    //     height: 50,
    //     backgroundColor: colors.grassgreen,
    //     position: "absolute",
    //     top: 40,
    //     left: 30
    // },
    // deleteIcon: {
    //     width: 50, 
    //     height: 50,
    //     backgroundColor: colors.grassgreen,
    //     position: "absolute",
    //     top: 40,
    //     right: 30
    // },
    container: {
        backgroundColor: colors.black,
        flex: 1,
        alignItems: "center",
    },
    image: {
        width: "90%",
        minWidth: 200,
        height: "100%",
    },
})

export default SplashScreen;