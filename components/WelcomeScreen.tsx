import React from 'react';
import { View, Text, TouchableOpacity, StyleSheet, ImageBackground } from 'react-native';

import { NavigationProp } from '@react-navigation/native';

const LaunchScreen = ({ navigation }: { navigation: NavigationProp<any> }) => {
  return (
    <ImageBackground
      source={require('../assets/LaunchScreen/Image112.png')}
      style={styles.background}
    >
      <View style={styles.container}>
        <Text style={styles.title}>Your music</Text>
        <Text style={styles.title}>Your artists</Text>

        <TouchableOpacity
          style={styles.createButton}
          onPress={() => navigation.navigate('Register')}
        >
          <Text style={styles.createButtonText}>Create an account</Text>
        </TouchableOpacity>

        <TouchableOpacity
          onPress={() => navigation.navigate('Login')}
        >
          <Text style={styles.loginText}>I already have an account</Text>
        </TouchableOpacity>
      </View>
    </ImageBackground>
  );
};

const styles = StyleSheet.create({
  background: {
    flex: 1,
    resizeMode: 'cover',
    justifyContent: 'center',
  },
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    paddingHorizontal: 20,
  },
  title: {
    fontSize: 32,
    fontWeight: 'bold',
    color: '#FFFFFF',
    textAlign: 'center',
    marginBottom: 5,
  },
  createButton: {
    backgroundColor: '#000000',
    paddingVertical: 15,
    paddingHorizontal: 60,
    borderRadius: 30,
    marginTop: 40,
  },
  createButtonText: {
    color: '#FFFFFF',
    fontSize: 16,
    fontWeight: 'bold',
    textAlign: 'center',
  },
  loginText: {
    marginTop: 20,
    fontSize: 20,
    color: '#000',
    fontWeight: 'bold',
    textDecorationLine: 'underline',
  },
});

export default LaunchScreen;
