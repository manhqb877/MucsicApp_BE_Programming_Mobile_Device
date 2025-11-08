import React, { useState } from 'react';
import {View, Text, TextInput, FlatList, Image, TouchableOpacity, StyleSheet} from 'react-native';
import Icon from 'react-native-vector-icons/Ionicons';

const SearchScreen = () => {
  const [searchQuery, setSearchQuery] = useState('');
  const data = [
    { id: '1', title: 'Me', artist: 'Jessica Gonzalez', plays: '2.1M', duration: '3:36', image: 'https://cdn-thumbs.imagevenue.com/4d/eb/58/ME19JY56_t.png' },
    { id: '2', title: 'Me Inc', artist: 'Anthony Taylor', plays: '600K', duration: '3:35', image: 'https://cdn-thumbs.imagevenue.com/2f/d0/3c/ME19JY58_t.png' },
    { id: '3', title: 'Dozz Me', artist: 'Brian Bailey', plays: '93M', duration: '4:39', image: 'https://cdn-thumbs.imagevenue.com/a7/a5/4b/ME19JY5A_t.png' },
    { id: '4', title: 'Eastss Me', artist: 'Anthony Taylor', plays: '9M', duration: '7:48', image: 'https://cdn-thumbs.imagevenue.com/6a/ba/82/ME19JY5B_t.png' },
    { id: '5', title: 'Me Ali', artist: 'Pedro Moreno', plays: '23M', duration: '3:36', image: 'https://cdn-thumbs.imagevenue.com/f6/3a/e9/ME19JY5C_t.png' },
    { id: '6', title: 'Me Quis A', artist: 'Elena Jimenez', plays: '10M', duration: '6:22', image: 'https://cdn-thumbs.imagevenue.com/7c/b6/4b/ME19JY5D_t.png' },
    { id: '7', title: 'Me Light', artist: 'John Smith', plays: '81M', duration: '5:15', image: 'https://cdn-thumbs.imagevenue.com/f2/af/8d/ME19JY5E_t.png' },
    { id: '8', title: 'Me Forever', artist: 'Sophia Cruz', plays: '45M', duration: '4:12', image: 'https://cdn-thumbs.imagevenue.com/8b/11/43/ME19JY75_t.png' },
    { id: '9', title: 'Me Anthem', artist: 'Liam Martinez', plays: '12M', duration: '3:58', image: 'https://cdn-thumbs.imagevenue.com/2a/b4/eb/ME19JY77_t.png' },
    { id: '10', title: 'Me Again', artist: 'Olivia Davis', plays: '88M', duration: '5:03', image: 'https://cdn-thumbs.imagevenue.com/db/a6/e6/ME19JY74_t.png' },
    { id: '11', title: 'Me Galaxy', artist: 'Emma Wilson', plays: '1.2M', duration: '6:45', image: 'https://cdn-thumbs.imagevenue.com/ec/2a/8c/ME19JY73_t.png' },
    { id: '12', title: 'Me Soul', artist: 'Noah Lee', plays: '74M', duration: '4:20', image: 'https://cdn-thumbs.imagevenue.com/ea/eb/4e/ME19JY72_t.png' },
    { id: '13', title: 'Me Beats', artist: 'Lucas Brown', plays: '3.8M', duration: '3:48', image: 'https://cdn-thumbs.imagevenue.com/18/78/5e/ME19JY71_t.png' },
    { id: '14', title: 'Me Fly', artist: 'Isabella White', plays: '27M', duration: '4:30', image: 'https://cdn-thumbs.imagevenue.com/f2/af/8d/ME19JY5E_t.png' },
    { id: '15', title: 'Me Rise', artist: 'James Taylor', plays: '52M', duration: '5:10', image: 'https://cdn-thumbs.imagevenue.com/6a/ba/82/ME19JY5B_t.png' }
  ];

  const filteredData = data.filter(item =>
    item.title.toLowerCase().includes(searchQuery.toLowerCase()) ||
    item.artist.toLowerCase().includes(searchQuery.toLowerCase())
  );

  const renderItem = ({ item }: { item: { id: string; title: string; artist: string; plays: string; duration: string; image: string } }) => (
    <View style={styles.itemContainer}>
      <Image source={{ uri: item.image }} style={styles.image} />
      <View style={styles.textContainer}>
        <Text style={styles.title}>{item.title}</Text>
        <Text style={styles.subtitle}>{item.artist} • {item.plays}</Text>
      </View>
      <Text style={styles.duration}>{item.duration}</Text>
      <TouchableOpacity>
        <Icon name="ellipsis-horizontal" size={20} color="gray" />
      </TouchableOpacity>
    </View>
  );

  return (
    <View style={styles.container}>
      <View style={styles.searchBarContainer}>
        <TextInput
          style={styles.searchBar}
          placeholder="Search"
          value={searchQuery}
          onChangeText={setSearchQuery}
        />
        <Icon name="search" size={20} color="gray" style={styles.searchIcon} />
      </View>
      <View style={styles.tabContainer}>
        <Text style={[styles.tab, styles.activeTab]}>All</Text>
        <Text style={styles.tab}>Tracks</Text>
        <Text style={styles.tab}>Albums</Text>
        <Text style={styles.tab}>Artists</Text>
      </View>
      <FlatList
        data={filteredData}
        keyExtractor={(item) => item.id}
        renderItem={renderItem}
      />
    </View>
  );
};

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: 'white',
    paddingHorizontal: 10,
    marginTop: 40,
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
  tabContainer: {
    flexDirection: 'row',
    justifyContent: 'space-around',
    marginBottom: 10,
  },
  tab: {
    color: 'gray',
    fontSize: 16,
  },
  activeTab: {
    color: 'blue',
    borderBottomWidth: 2,
    borderBottomColor: 'blue',
  },
  itemContainer: {
    flexDirection: 'row',
    alignItems: 'center',
    marginVertical: 10,
  },
  image: {
    width: 50,
    height: 50,
    borderRadius: 8,
  },
  textContainer: {
    flex: 1,
    marginLeft: 10,
  },
  title: {
    fontSize: 16,
    fontWeight: 'bold',
  },
  subtitle: {
    color: 'gray',
    marginTop: 4,
  },
  duration: {
    color: 'gray',
    marginRight: 10,
  },
});

export default SearchScreen;
