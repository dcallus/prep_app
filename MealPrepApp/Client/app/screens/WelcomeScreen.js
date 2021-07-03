import React from 'react';
import { ImageBackground, StyleSheet, View, Image, Text } from "react-native";

function WelcomeScreen(props) {
    return (
        <ImageBackground
            style={styles.background}
            source={require("../assets/images/background.jpg")}
        >
            <View style={styles.header}/>
            <View style={styles.logoContainer}>
                <Image style={styles.logo} source={require("../assets/images/logo.png")}/>
                <Text style={styles.logoText}>Preparado</Text>
            </View>
            <View style={styles.loginButton}/>
            <View style={styles.registerButton}/>
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
        height: 95,
        backgroundColor: "black",
        alignItems: "flex-start", 
    },
    loginButton: {
        width: "80%", 
        height: 100,
        backgroundColor: "white"
    },
    logo: {
        width: 80, 
        height: 80,
        alignItems: "center"
    },
    logoContainer: {
        position: "absolute",
        top: 40, 
        flexDirection: "row"
    },
    logoText: {
        color: "white",
        fontSize: 40
    },
    registerButton: {
        width: "100%", 
        height: 70,
        backgroundColor: "#00DB92"
    }
})

export default WelcomeScreen;