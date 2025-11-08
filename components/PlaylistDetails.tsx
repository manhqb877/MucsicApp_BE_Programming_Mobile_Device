import React from 'react';
import { View, Text, Image, FlatList, StyleSheet, TouchableOpacity } from 'react-native';
import { NavigationProp } from '@react-navigation/native';

const playlistData = {
  title: 'Top 50 - Canada',
  subtitle: 'Daily chart-toppers update',
  likes: '1,234',
  duration: '05:10:18',
  coverImage: require('../assets/playlistdetails/Container_31.png'), 
  songs: [
    {
      id: '1',
      title: 'FLOWER',
      artist: 'Jessica Gonzalez',
      plays: '2.1M',
      duration: '3:36',
      coverImage: require('../assets/playlistdetails/Image_51.png'),
      audio: 'https://www.soundhelix.com/examples/mp3/SoundHelix-Song-2.mp3' 
    },
    {
      id: '2',
      title: 'Shape of You',
      artist: 'Anthony Taylor',
      plays: '68M',
      duration: '3:35',
      coverImage: require('../assets/playlistdetails/Image_52.png'), 
      audio: 'https://www.soundhelix.com/examples/mp3/SoundHelix-Song-2.mp3'
    },
    {
      id: '3',
      title: 'Blinding Lights',
      artist: 'Ashley Scott',
      plays: '68M',
      duration: '3:35',
      coverImage: require('../assets/playlistdetails/Image_53.png'), 
      audio: 'https://www.soundhelix.com/examples/mp3/SoundHelix-Song-2.mp3'
    },
    {
      id: '4',
      title: 'Levitating',
      artist: 'Anthony Taylor',
      plays: '9M',
      duration: '7:48',
      coverImage: require('../assets/playlistdetails/Image_54.png'), 
      audio: 'https://www.soundhelix.com/examples/mp3/SoundHelix-Song-2.mp3'
    },
    {
      id: '5',
      title: 'Astronaut in the Ocean',
      artist: 'Pedro Moreno',
      plays: '23M',
      duration: '3:36',
      coverImage: require('../assets/playlistdetails/Image_55.png'), 
      audio: 'https://www.soundhelix.com/examples/mp3/SoundHelix-Song-2.mp3'
    },
    {
      id: '6',
      title: 'Dynamite',
      artist: 'Elena Jimenez',
      plays: '10M',
      duration: '6:22',
      coverImage: require('../assets/playlistdetails/Image_56.png'), 
      audio: 'https://www.soundhelix.com/examples/mp3/SoundHelix-Song-2.mp3'
    },
    {
      id: '7',
      title: 'Peaches',
      artist: 'John Smith',
      plays: '81M',
      duration: '5:15',
      coverImage: require('../assets/playlistdetails/Image_57.png'), 
      audio: 'https://www.soundhelix.com/examples/mp3/SoundHelix-Song-2.mp3'
    },
    
    
    
   
  ],
};

const PlaylistDetails = ({ navigation }: { navigation: NavigationProp<any> }) => {
  const renderSong = ({ item }:  { item: typeof playlistData.songs[0] })  => (
    <View style={styles.songContainer}>
      <Image source={item.coverImage} style={styles.songImage} />
      <View style={styles.songDetails}>
        <TouchableOpacity onPress={() => navigation.navigate('PlayerScreen', {song : item})}><Text style={styles.songTitle}>{item.title}</Text></TouchableOpacity>
        <Text style={styles.songSubtitle}>
          {item.artist} • {item.plays}
        </Text>
      </View>
      <Text style={styles.songDuration}>{item.duration}</Text>
    </View>
  );

  return (
    <View style={styles.container}>
      {/* Header Section */}
      <View style={styles.header}>
        <Image source={playlistData.coverImage} style={styles.coverImage} />
        <View style={styles.headerDetails}>
          <Text style={styles.playlistTitle}>{playlistData.title}</Text>
          <Text style={styles.playlistSubtitle}>{playlistData.subtitle}</Text>
          <Text style={styles.playlistStats}>
            {playlistData.likes} • {playlistData.duration}
          </Text>
        </View>
      </View>

      {/* Songs List */}
      <FlatList
        data={playlistData.songs}
        renderItem={renderSong}
        keyExtractor={(item) => item.id}
        style={styles.songList}
      />

      {/* Now Playing Footer */}
      <View style={styles.footer}>
        <Image
          source={playlistData.songs[0].coverImage }
          style={styles.footerImage}
        />
        <View style={styles.footerDetails}>
          <Text style={styles.footerSongTitle}>{playlistData.songs[0].title}</Text>
          <Text style={styles.footerSongArtist}>{playlistData.songs[0].artist}</Text>
        </View>
        <TouchableOpacity>
          <Text style={styles.footerPlay}>▶</Text>
        </TouchableOpacity>
      </View>
    </View>
  );
};

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#fff',
  },
  header: {
    flexDirection: 'row',
    padding: 16,
    alignItems: 'center',
  },
  coverImage: {
    width: 100,
    height: 100,
    borderRadius: 8,
  },
  headerDetails: {
    marginLeft: 16,
    flex: 1,
  },
  playlistTitle: {
    fontSize: 20,
    fontWeight: 'bold',
  },
  playlistSubtitle: {
    fontSize: 14,
    color: '#777',
  },
  playlistStats: {
    fontSize: 12,
    color: '#555',
    marginTop: 4,
  },
  songList: {
    flex: 1,
  },
  songContainer: {
    flexDirection: 'row',
    alignItems: 'center',
    padding: 16,
    borderBottomWidth: 1,
    borderBottomColor: '#eee',
  },
  songImage: {
    width: 50,
    height: 50,
    borderRadius: 4,
  },
  songDetails: {
    marginLeft: 16,
    flex: 1,
  },
  songTitle: {
    fontSize: 16,
    fontWeight: 'bold',
  },
  songSubtitle: {
    fontSize: 14,
    color: '#777',
  },
  songDuration: {
    fontSize: 14,
    color: '#555',
  },
  footer: {
    flexDirection: 'row',
    alignItems: 'center',
    padding: 16,
    borderTopWidth: 1,
    borderTopColor: '#eee',
  },
  footerImage: {
    width: 50,
    height: 50,
    borderRadius: 4,
  },
  footerDetails: {
    marginLeft: 16,
    flex: 1,
  },
  footerSongTitle: {
    fontSize: 16,
    fontWeight: 'bold',
  },
  footerSongArtist: {
    fontSize: 14,
    color: '#777',
  },
  footerPlay: {
    fontSize: 24,
    color: '#000',
  },
});

export default PlaylistDetails;
