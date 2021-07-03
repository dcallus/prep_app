import React from 'react';
import { 
    ImageBackground, StyleSheet, 
    View, Image, Text 
} from "react-native";
import { color } from 'react-native-reanimated';
import colors from '../config/colors';


function WelcomeScreen(props) {
    return (
        <ImageBackground
            style={styles.background}
            source={require("../assets/images/background.jpg")}>
            <View style={styles.header}/>
            <View style={styles.postcodeField}/>
            <View style={styles.footer}/>
            <View style={styles.logoContainer}>
                <Image style={styles.logo} source={require("../assets/images/logo2.png")}/>
            </View>
        </ImageBackground>
    );
}

const styles = StyleSheet.create({
    background: {
        flex: 1, // sets the image background to entire screen
        justifyContent: "space-between",
        alignItems: "center"
    },
    header: {
        width: "100%", 
        height: 135,
        backgroundColor: colors.black,
        alignItems: "flex-start", 
    },
    postcodeField: {
        backgroundColor: colors.white,
        width: "80%", 
        height: 100,
        borderRadius: 30
    },
    logoContainer: {
        position: "absolute",
        top: 20, 
        flexDirection: "row"
    },
    logo: {
        width: 480, 
        height: 100,
        alignItems: "center"
    },
    logoText: {
        color: "white",
        fontSize: 40
    },
    footer: {
        width: "100%", 
        height: 90,
        backgroundColor: colors.grassgreen
    }
})

export default WelcomeScreen;