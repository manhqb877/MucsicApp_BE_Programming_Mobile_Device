import React from 'react';
import {
  View,
  Text,
  Image,
  StyleSheet,
  FlatList,
  TouchableOpacity,
  ScrollView,
} from 'react-native';

const artistData = {
  name: 'Ryan Young',
  followers: '65.1K Followers',
  profileImage: require('../assets/Artist_Profile/Image63.png'), // Hình ảnh profile
  popularSongs: [
    { id: '1', title: 'Let you free', plays: '68M', duration: '03:35', image: require('../assets/Artist_Profile/Image66.png') },
    { id: '2', title: 'Blinding Lights', plays: '93M', duration: '04:39', image: require('../assets/Artist_Profile/Image67.png')},
    { id: '3', title: 'Levitating', plays: '9M', duration: '07:48', image: require('../assets/Artist_Profile/Image68.png') },
    { id: '4', title: 'Astronaut in the Ocean', plays: '23M', duration: '03:36', image: require('../assets/Artist_Profile/Image69.png')},
    { id: '5', title: 'Dynamite', plays: '10M', duration: '06:22', image: require('../assets/Artist_Profile/Image70.png')},
  ],
  albums: [
    { id: '1', title: 'ME', image: require('../assets/Artist_Profile/Image71.png') },
    { id: '2', title: 'Magna nost', image: require('../assets/Artist_Profile/Image72.png') },
    { id: '3', title: 'Proident', image: require('../assets/Artist_Profile/Image77.png') },
  ],
  about: {
    description:
      'Do in cupidatat aute et in officia aute laboris est Lorem est nisi dolor consequat voluptate duis irure. Veniam quis amet irure cillum elit aliquip sunt cillum cillum do aliqua voluptate ad non magna elit.',
    image: require('../assets/Artist_Profile/Image73.png'),
  },
  fansAlsoLike: [
    { id: '1', name: 'Magna nost', artist: 'Jessica Gonzalez', image: require('../assets/Artist_Profile/Image74.png') },
    { id: '2', name: 'Exercitatio', artist: 'Brian Harris', image: require('../assets/Artist_Profile/Image75.png') },
    { id: '3', name: 'Tempor', artist: 'Tyler Anderson', image: require('../assets/Artist_Profile/Image76.png') },
  ],
};

export default function ArtistProfileScreen() {
  return (
    <ScrollView style={styles.container}>
      {/* Header */}
      <View style={styles.header}>
        <Image source={artistData.profileImage} style={styles.profileImage} />
        <Text style={styles.artistName}>{artistData.name}</Text>
        <Text style={styles.followers}>{artistData.followers}</Text>
        <View style={styles.actions}>
          <TouchableOpacity style={styles.followButton}>
            <Text style={styles.followText}>Follow</Text>
          </TouchableOpacity>
          <TouchableOpacity style={styles.iconButton}>
            <Text style={styles.icon}>•••</Text>
          </TouchableOpacity>
          <TouchableOpacity style={styles.iconButton}>
            <Text style={styles.icon}>▶</Text>
          </TouchableOpacity>
        </View>
      </View>

      {/* Popular Songs */}
      <Text style={styles.sectionTitle}>Popular</Text>
{artistData.popularSongs.map((song) => (
  <View key={song.id} style={styles.songRow}>
    <Image source={song.image} style={styles.songImage} /> {/* Thêm hình ảnh */}
    <View style={styles.songDetails}>
      <Text style={styles.songTitle}>{song.title}</Text>
      <Text style={styles.songPlays}>{`${song.plays} • ${song.duration}`}</Text>
    </View>
  </View>
))}

      {/* Albums */}
      <Text style={styles.sectionTitle}>Albums</Text>
      <FlatList
        horizontal
        data={artistData.albums}
        keyExtractor={(item) => item.id}
        renderItem={({ item }) => (
          <View style={styles.albumCard}>
            <Image source={item.image} style={styles.albumImage} />
            <Text style={styles.albumTitle}>{item.title}</Text>
          </View>
        )}
        showsHorizontalScrollIndicator={false}
      />

      {/* About */}
      <Text style={styles.sectionTitle}>About</Text>
      <Image source={artistData.about.image} style={styles.aboutImage} />
      <Text style={styles.aboutDescription}>{artistData.about.description}</Text>
      <TouchableOpacity>
        <Text style={styles.viewMore}>View more</Text>
      </TouchableOpacity>

      {/* Fans Also Like */}
      <Text style={styles.sectionTitle}>Fans also like</Text>
      <FlatList
        horizontal
        data={artistData.fansAlsoLike}
        keyExtractor={(item) => item.id}
        renderItem={({ item }) => (
          <View style={styles.fanCard}>
            <Image source={item.image} style={styles.fanImage} />
            <Text style={styles.fanName}>{item.name}</Text>
            <Text style={styles.fanArtist}>{item.artist}</Text>
          </View>
        )}
        showsHorizontalScrollIndicator={false}
      />
    </ScrollView>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#fff',
    padding: 16,
  },
  header: {
    alignItems: 'center',
    marginBottom: 16,
  },
  profileImage: {
    width: 120,
    height: 120,
    borderRadius: 60,
    marginBottom: 8,
  },
  artistName: {
    fontSize: 24,
    fontWeight: 'bold',
  },
  followers: {
    color: '#666',
    fontSize: 14,
  },
  actions: {
    flexDirection: 'row',
    marginTop: 16,
  },
  followButton: {
    backgroundColor: '#1DB954',
    borderRadius: 20,
    paddingHorizontal: 24,
    paddingVertical: 8,
    marginRight: 8,
  },
  followText: {
    color: '#fff',
    fontWeight: 'bold',
  },
  iconButton: {
    marginHorizontal: 8,
    justifyContent: 'center',
    alignItems: 'center',
  },
  icon: {
    fontSize: 18,
    color: '#666',
  },
  sectionTitle: {
    fontSize: 18,
    fontWeight: 'bold',
    marginVertical: 8,
  },
  songRow: {
    flexDirection: 'row',
    alignItems: 'center',
    marginVertical: 8,
  },
  songImage: {
    width: 50,
    height: 50,
    borderRadius: 8,
    marginRight: 16,
  },
  songDetails: {
    flex: 1,
  },
  songTitle: {
    fontSize: 16,
    color: '#000',
    fontWeight: 'bold',
  },
  songPlays: {
    fontSize: 14,
    color: '#666',
  },
  albumCard: {
    marginRight: 16,
  },
  albumImage: {
    width: 120,
    height: 120,
    borderRadius: 8,
    marginBottom: 8,
  },
  albumTitle: {
    fontSize: 14,
    textAlign: 'center',
  },
  aboutImage: {
    width: '100%',
    height: 180,
    borderRadius: 8,
    marginBottom: 8,
  },
  aboutDescription: {
    fontSize: 14,
    color: '#666',
    marginBottom: 8,
  },
  viewMore: {
    color: '#1DB954',
    fontWeight: 'bold',
    fontSize: 14,
  },
  fanCard: {
    marginRight: 16,
    alignItems: 'center',
  },
  fanImage: {
    width: 100,
    height: 100,
    borderRadius: 8,
    marginBottom: 8,
  },
  fanName: {
    fontSize: 14,
    fontWeight: 'bold',
  },
  fanArtist: {
    color: '#666',
    fontSize: 12,
  },
});
