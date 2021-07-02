import React from "react";
import { StyleSheet, Text, View, Image } from 'react-native';
import {MaterialIcons} from '@expo/vector-icons'


const MyHeader = () => {


    return(
        <View style={styles.header}>
            {/* Icon for the menu */}
            <View>
                <Text style={styles.headerText}>Header!</Text>
            </View>
        </View>
    )
}

const styles = StyleSheet.create({
    header: {
        width: '100%',
        height: '100%',
        flexDirection: 'row',
        alignItems: 'center',
        justifyContent: 'center'
    },
    headerText: {
        fontWeight: 'bold', 
        fontSize: 20,
        color: '#333',
        letterSpacing: 1
    }
})

export default MyHeader;