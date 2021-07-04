import React from 'react';
import { Image, StyleSheet, View } from "react-native";

import colors from '../constants/colors';

function Splash(props) {
    return (
        <>
        <View style={styles.container}>
            <Image resizeMode="contain" style={styles.image} source={require("../assets/images/logo2.png")}/>
        </View>
        </>
    );
}


const styles = StyleSheet.create({
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

export default Splash;