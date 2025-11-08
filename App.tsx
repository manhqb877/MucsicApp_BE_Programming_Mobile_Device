
import React from 'react';
import { NavigationContainer } from '@react-navigation/native';
import { createStackNavigator } from '@react-navigation/stack';
import BottomTabs from './components/BottomTabs';
import PlaylistDetails from './components/PlaylistDetails'; 
import ArtistProfileScreen from './components/ArtistProfileScreen';
import PlayerScreen from './components/PlayerScreen';
import PlayerScreenProps from './components/PlayerScreenProps';
import WelcomeScreen from './components/WelcomeScreen';
import LoginScreen from './components/LoginScreen';
import RegisterScreen from './components/RegisterScreen';



const Stack = createStackNavigator();

export default function App() {
  
  return (
    <NavigationContainer>
      <Stack.Navigator>
      <Stack.Screen
          name="WelcomeScreen"
          component={WelcomeScreen}
          options={{  headerShown: false }}
        />
        <Stack.Screen
          name="HomeTabs"
          component={BottomTabs}
          options={{ headerShown: false }}
        />
       <Stack.Screen
          name="Login"
          component={LoginScreen}
          options={{ title: 'Login' }}
        />
        <Stack.Screen
          name="Register"
          component={RegisterScreen}
          options={{ title: 'Register' }}
        />
        <Stack.Screen
          name="PlaylistDetails"
          component={PlaylistDetails}
          options={{ title: 'Playlist Details' }}
        />
         <Stack.Screen
          name="ArtistProfileScreen"
          component={ArtistProfileScreen}
          options={{ title: 'Artist Profile' }}
        />
        <Stack.Screen
          name="PlayerScreen"
          component={(props: PlayerScreenProps) => <PlayerScreen {...props} />}
          options={{ title: 'Play Audio' }}
        />
          
      </Stack.Navigator>
    
    </NavigationContainer>
    
    
  );
}

