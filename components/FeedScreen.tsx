import React from 'react';
import { View, Text, Image, StyleSheet, FlatList, TouchableOpacity } from 'react-native';

const feedData = [
  {
    id: '1',
    user: 'Jessica Gonzalez',
    avatar: require('../assets/feed_screen/Avatar_4.png'),
    trackTitle: 'Flower',
    postedTime: '3d',
    image: require('../assets/feed_screen/Image_93.png'), 
    listens: 125,
    duration: '05:15',
    likes: 20,
    comments: 3,
    shares: 1,
  },
  {
    id: '2',
    user: 'William King',
    avatar: require('../assets/feed_screen/Avatar_5.png'),
    trackTitle: 'Me',
    postedTime: '5d',
    image: require('../assets/feed_screen/Image_94.png'), 
    listens: 245,
    duration: '05:15',
    likes: 45,
    comments: 9,
    shares: 2,
  },
  {
    id: '3',
    user: 'John Doe',
    avatar: require('../assets/feed_screen/Avatar_9.png'),
    trackTitle: 'Shape of You',
    postedTime: '5d',
    image: require('../assets/feed_screen/Image_47.png'), 
    listens: 245,
    duration: '04:15',
    likes: 45,
    comments: 9,
    shares: 2,
  },
];

const FeedScreen = () => {
  const renderItem = ({ item }: { item: typeof feedData[0] }) => (
    <View style={styles.card}>
      <View style={styles.header}>
        <Image
          source={item.avatar}
          style={styles.avatar}
        />
        <View style={styles.userInfo}>
          <Text style={styles.userName}>{item.user}</Text>
          <Text style={styles.postedTime}>{`Posted a track • ${item.postedTime}`}</Text>
        </View>
      </View>
      <Image source={item.image} style={styles.trackImage} />
      <View style={styles.details}>
        <Text style={styles.trackTitle}>{item.trackTitle}</Text>
        <Text style={styles.userName}>{item.user}</Text>
        <View style={styles.stats}>
          <Text style={styles.stat}>{`▶ ${item.listens}`}</Text>
          <Text style={styles.stat}>{`• ${item.duration}`}</Text>
        </View>
      </View>
      <View style={styles.actions}>
        <Text style={styles.action}>{`❤️ ${item.likes}`}</Text>
        <Text style={styles.action}>{`💬 ${item.comments}`}</Text>
        <Text style={styles.action}>{`🔄 ${item.shares}`}</Text>
      </View>
    </View>
  );

  return (
    <FlatList
      data={feedData}
      renderItem={renderItem}
      keyExtractor={(item) => item.id}
      style={styles.container}
    />
  );
};

const styles = StyleSheet.create({
  container: {
    backgroundColor: '#f9f9f9',
    flex: 1,
    padding: 10,
    marginTop: 40
  },
  card: {
    backgroundColor: '#fff',
    marginBottom: 20,
    borderRadius: 10,
    overflow: 'hidden',
    shadowColor: '#000',
    shadowOffset: { width: 0, height: 2 },
    shadowOpacity: 0.1,
    shadowRadius: 8,
    elevation: 2,
  },
  header: {
    flexDirection: 'row',
    alignItems: 'center',
    padding: 10,
  },
  avatar: {
    width: 40,
    height: 40,
    borderRadius: 20,
    marginRight: 10,
  },
  userInfo: {
    flex: 1,
  },
  userName: {
    fontWeight: 'bold',
    fontSize: 16,
  },
  postedTime: {
    color: '#888',
    fontSize: 14,
  },
  trackImage: {
    width: '100%',
    height: 200,
  },
  details: {
    padding: 10,
  },
  trackTitle: {
    fontWeight: 'bold',
    fontSize: 18,
  },
  stats: {
    flexDirection: 'row',
    marginTop: 5,
  },
  stat: {
    marginRight: 10,
    fontSize: 14,
    color: '#666',
  },
  actions: {
    flexDirection: 'row',
    justifyContent: 'space-between',
    padding: 10,
    borderTopWidth: 1,
    borderColor: '#f0f0f0',
  },
  action: {
    fontSize: 14,
    color: '#666',
  },
});

export default FeedScreen;
