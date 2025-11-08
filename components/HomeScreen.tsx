import React from 'react';
import { View, Text, TextInput, Image, ScrollView, StyleSheet, TouchableOpacity, ImageBackground } from 'react-native';
import Icon from 'react-native-vector-icons/Ionicons';
import { LinearGradient } from 'expo-linear-gradient';

import { NavigationProp } from '@react-navigation/native';

export default function HomeScreen({ navigation }: { navigation: NavigationProp<any> }) {
  return (
    <ScrollView style={styles.container}>
      {/* Header */}
      <View style={styles.header}>
        <Text style={styles.greeting}>Good morning,</Text>
        <Text style={styles.username}>Ashley Scott</Text>
        <View style={styles.headerIcons}>
          <Icon name="notifications-outline" size={24} color="#000" />
          <Image
            source={require('../assets/home_screen/Avatar_3.png')}
            style={styles.profileImage}
          />
        </View>
      </View>

      {/* Search Bar */}
      <View style={styles.searchBarContainer}>
      <TextInput
        style={styles.searchBar}
        placeholder="What you want to listen to"
        placeholderTextColor="#888"
      />
      <Icon name="search" size={20} color="gray" style={styles.searchIcon} />
      </View>

      {/* Suggestions */}
      <Text style={styles.sectionTitle}>Suggestions for you</Text>
      <View style={styles.suggestions}>
        <View style={styles.suggestionItem}>
          <Image source={require('../assets/home_screen/Container_26.png')} style={styles.suggestionImage} />
          <Text style={styles.suggestionTitle}>Reflection</Text>
          <Text style={styles.suggestionSubtitle}>Christina Aguilera</Text>
        </View>
        <View style={styles.suggestionItem}>
          <Image source={require('../assets/home_screen/Container_27.png')} style={styles.suggestionImage} />
          <Text style={styles.suggestionTitle}>In The Stars</Text>
          <Text style={styles.suggestionSubtitle}>Benson Boone</Text>
        </View>
      </View>

      {/* Charts */}
      <Text style={styles.sectionTitle}>Charts</Text>
      <View style={styles.charts}>
        <LinearGradient colors={['#b20a2c', '#fffbd5']} style={styles.chartItem}>
        <TouchableOpacity
          
          onPress={() => navigation.navigate('PlaylistDetails', { title: 'Top 50 - Canada' })}
        >
          <ImageBackground source={require('../assets/home_screen/top50_canada.jpg')}  />
          <Text style={styles.chartTitle}>Top 50</Text>
          <Text style={styles.chartSubtitle}>Canada</Text>
        </TouchableOpacity>
        </LinearGradient>
        
        <LinearGradient colors={['#fceabb', '#f8b500']}  style={styles.chartItem}>
          <Text style={styles.chartTitle}>Top 50</Text>
          <Text style={styles.chartSubtitle}>Global</Text>
        </LinearGradient>
        <LinearGradient colors={['#c6ffdd', '#fbd786', '#f7797d']} style={styles.chartItem}>
          <Text style={styles.chartTitle}>Top 50</Text>
          <Text style={styles.chartSubtitle}>Trending</Text>
        </LinearGradient>
      </View>

      {/* Trending Albums */}
      <Text style={styles.sectionTitle}>Trending albums</Text>
      <ScrollView horizontal style={styles.trendingAlbums}>
        <View style={styles.albumItem}>
          <Image source={require('../assets/home_screen/Image_45.png')} style={styles.albumImage} />
          <Text style={styles.albumTitle}>ME</Text>
          <Text style={styles.albumSubtitle}>Jessica Gonzalez</Text>
        </View>
        <View style={styles.albumItem}>
          <Image source={require('../assets/home_screen/Image_46.png')} style={styles.albumImage} />
          <Text style={styles.albumTitle}>Magna nost</Text>
          <Text style={styles.albumSubtitle}>Brian Thomas</Text>
        </View>
        <View style={styles.albumItem}>
          <Image source={require('../assets/home_screen/Image_47.png')} style={styles.albumImage} />
          <Text style={styles.albumTitle}>Magna nost</Text>
          <Text style={styles.albumSubtitle}>Brian Thomas</Text>
        </View>
        {/* Add more albums as needed */}
      </ScrollView>

      {/* Popular Artists */}
      <Text style={styles.sectionTitle}>Popular artists</Text>
      <ScrollView horizontal style={styles.popularArtists}>
        <View style={styles.artistItem}>
          <TouchableOpacity onPress={() => navigation.navigate('ArtistProfileScreen', { title: '' })}>
          <Image source={require('../assets/home_screen/Image_39.png')} style={styles.artistImage} />
          <Text style={styles.artistName}>Jennifer Wilson</Text>
          </TouchableOpacity>
          <TouchableOpacity style={styles.followButton}><Text style={styles.followText}>Follow</Text></TouchableOpacity>
          
        </View>
        <View style={styles.artistItem}>
          <Image source={require('../assets/home_screen/Image_40.png')} style={styles.artistImage} />
          <Text style={styles.artistName}>Elizabeth Hall</Text>
          <TouchableOpacity style={styles.followButton}><Text style={styles.followText}>Follow</Text></TouchableOpacity>
        </View>
        <View style={styles.artistItem}>
          <Image source={require('../assets/home_screen/Image_41.png')} style={styles.artistImage} />
          <Text style={styles.artistName}>Elizabeth Hall</Text>
          <TouchableOpacity style={styles.followButton}><Text style={styles.followText}>Follow</Text></TouchableOpacity>
        </View>
        {/* Add more artists as needed */}
      </ScrollView>
    </ScrollView>
  );
};

const styles = StyleSheet.create({
  container: {
    flex: 1,
    paddingHorizontal: 20,
    marginTop: 40,
    backgroundColor: '#fff',
  },
  header: {
    flexDirection: 'row',
    justifyContent: 'space-between',
    alignItems: 'center',
    marginTop: 10,
  },
  greeting: {
    fontSize: 16,
    color: '#888',
  },
  username: {
    fontSize: 24,
    fontWeight: 'bold',
  },
  headerIcons: {
    flexDirection: 'row',
    alignItems: 'center',
  },
  profileImage: {
    width: 40,
    height: 40,
    borderRadius: 20,
    marginLeft: 10,
  },
  searchBarContainer: {
    flexDirection: 'row',
    alignItems: 'center',
    marginVertical: 10,
    backgroundColor: '#f0f0f0',
    borderRadius: 8,
    paddingHorizontal: 10,
  },
  searchBar: {
    flex: 1,
    paddingVertical: 8,
  },
  searchIcon: {
    marginLeft: 5,
  },
  sectionTitle: {
    fontSize: 20,
    fontWeight: 'bold',
    marginTop: 20,
  },
  suggestions: {
    flexDirection: 'row',
    justifyContent: 'space-between',
    marginTop: 10,
  },
  suggestionItem: {
    width: '48%',
  },
  suggestionImage: {
    width: '100%',
    height: 120,
    borderRadius: 10,
  },
  suggestionTitle: {
    fontSize: 16,
    fontWeight: 'bold',
    marginTop: 5,
  },
  suggestionSubtitle: {
    fontSize: 14,
    color: '#888',
  },
  charts: {
    flexDirection: 'row',
    justifyContent: 'space-between',
    marginTop: 10,
  },
  chartItem: {
    width: '30%',
    padding: 15,
    borderRadius: 10,
    backgroundColor: '#e0e0e0',
    alignItems: 'center',
  },
  chartTitle: {
    fontSize: 16,
    fontWeight: 'bold',
  },
  chartSubtitle: {
    fontSize: 14,
    color: '#888',
  },
  
  trendingAlbums: {
    flexDirection: 'row',
    marginTop: 10,
  },
  albumItem: {
    marginRight: 15,
    width: 120,
  },
  albumImage: {
    width: '100%',
    height: 120,
    borderRadius: 10,
  },
  albumTitle: {
    fontSize: 16,
    fontWeight: 'bold',
    marginTop: 5,
  },
  albumSubtitle: {
    fontSize: 14,
    color: '#888',
  },
  popularArtists: {
    flexDirection: 'row',
    marginTop: 10,
  },
  artistItem: {
    alignItems: 'center',
    marginRight: 15,
  },
  artistImage: {
    width: 70,
    height: 70,
    borderRadius: 35,
  },
  artistName: {
    fontSize: 16,
    fontWeight: 'bold',
    marginTop: 5,
  },
  followButton: {
    marginTop: 5,
    paddingHorizontal: 15,
    paddingVertical: 5,
    borderRadius: 20,
    backgroundColor: '#000',
  },
  followText: {
    color: '#fff',
  },
});


