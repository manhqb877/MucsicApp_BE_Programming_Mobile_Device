import React from "react";
import {View, Text, StyleSheet, FlatList, Image, TouchableOpacity } from "react-native";
import { Ionicons } from "@expo/vector-icons";

const data = [
  {
    id: "1",
    title: "FLOWER",
    artist: "Jessica Gonzalez",
    plays: "2,1M",
    duration: "3:36",
    cover: "https://cdn-thumbs.imagevenue.com/2e/39/3a/ME19JY20_t.png",
    liked: true,
  },
  {
    id: "2",
    title: "Shape of You",
    artist: "Anthony Taylor",
    plays: "68M",
    duration: "3:35",
    cover: "https://cdn-thumbs.imagevenue.com/66/78/b3/ME19JY21_t.png",
    liked: true,
  },
  {
    id: "3",
    title: "Blinding Lights",
    artist: "Ashley Scott",
    plays: "",
    duration: "",
    cover: "https://cdn-thumbs.imagevenue.com/7f/c3/74/ME19JY22_t.png",
    liked: false,
  },
  {
    id: "4",
    title: "Levitating",
    artist: "Anthony Taylor",
    plays: "9M",
    duration: "7:48",
    cover: "https://cdn-thumbs.imagevenue.com/cc/ac/f7/ME19JY23_t.png",
    liked: true,
  },
  {
    id: "5",
    title: "Astronaut in the Ocean",
    artist: "Pedro Moreno",
    plays: "23M",
    duration: "3:36",
    cover: "https://cdn-thumbs.imagevenue.com/96/7d/6d/ME19JY24_t.png",
    liked: true,
  },
  {
    id: "6",
    title: "Dynamite",
    artist: "Elena Jimenez",
    plays: "10M",
    duration: "6:22",
    cover: "https://cdn-thumbs.imagevenue.com/1e/49/e2/ME19JY25_t.png",
    liked: true,
  },
  {
    id: "7",
    title: "Stay",
    artist: "John Smith",
    plays: "81M",
    duration: "5:15",
    cover: "https://cdn-thumbs.imagevenue.com/18/78/5e/ME19JY71_t.png",
    liked: false,
  },
  {
    id: "8",
    title: "Peaches",
    artist: "Sophia Cruz",
    plays: "45M",
    duration: "4:12",
    cover: "https://cdn-thumbs.imagevenue.com/ea/eb/4e/ME19JY72_t.png",
    liked: true,
  },
  {
    id: "9",
    title: "Good 4 U",
    artist: "Liam Martinez",
    plays: "12M",
    duration: "3:58",
    cover: "https://cdn-thumbs.imagevenue.com/ec/2a/8c/ME19JY73_t.png",
    liked: false,
  },
  {
    id: "10",
    title: "Montero (Call Me By Your Name)",
    artist: "Olivia Davis",
    plays: "88M",
    duration: "5:03",
    cover: "https://cdn-thumbs.imagevenue.com/db/a6/e6/ME19JY74_t.png",
    liked: true,
  },
  {
    id: "11",
    title: "Drivers License",
    artist: "Emma Wilson",
    plays: "1.2M",
    duration: "6:45",
    cover: "https://cdn-thumbs.imagevenue.com/2a/b4/eb/ME19JY77_t.png",
    liked: false,
  }
];

const LibraryScreen = () => {
  const renderItem = ({ item }: { item: typeof data[0] }) => (
    <View style={styles.songRow}>
      <Image source={{ uri: item.cover }} style={styles.coverImage} />
      <View style={styles.songDetails}>
        <Text style={styles.songTitle}>{item.title}</Text>
        <Text style={styles.songMeta}>
          {item.artist} {item.plays && `\u2022 ${item.plays}`}{" "}
          {item.duration && `\u2022 ${item.duration}`}
        </Text>
      </View>
      {item.liked ? (
        <Ionicons name="heart" size={20} color="dodgerblue" />
      ) : (
        <Ionicons name="chevron-forward" size={20} color="gray" />
      )}
    </View>
  );

  return (
    <View style={styles.container}>
      <View style={styles.header}>
        <Text style={styles.headerTitle}>Your Library</Text>
        <Ionicons name="search" size={24} color="black" />
      </View>

      <View style={styles.filterRow}>
        {["Playlists", "New tag", "Songs", "Albums", "Artists"].map(
          (filter) => (
            <TouchableOpacity key={filter} style={styles.filterButton}>
              <Text style={styles.filterText}>{filter}</Text>
            </TouchableOpacity>
          )
        )}
      </View>

      <View style={styles.userRow}>
        <Image
          source={{ uri: "https://cdn-thumbs.imagevenue.com/c5/19/15/ME19JY26_t.png" }}
          style={styles.userAvatar}
        />
        <View style={styles.userInfo}>
          <Text style={styles.userName}>Mer Watson</Text>
          <Text style={styles.userMeta}>1.234K Followers</Text>
        </View>
        <TouchableOpacity style={styles.followButton}>
          <Text style={styles.followButtonText}>Follow</Text>
        </TouchableOpacity>
      </View>

      <FlatList
        data={data}
        keyExtractor={(item) => item.id}
        renderItem={renderItem}
        contentContainerStyle={styles.songList}
      />
    </View>
  );
};

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: "#fff",
    padding: 16,
    marginTop: 40
  },
  header: {
    flexDirection: "row",
    justifyContent: "space-between",
    alignItems: "center",
    marginBottom: 16,
  },
  headerTitle: {
    fontSize: 24,
    fontWeight: "bold",
  },
  filterRow: {
    flexDirection: "row",
    marginBottom: 16,
  },
  filterButton: {
    backgroundColor: "#f0f0f0",
    borderRadius: 16,
    paddingHorizontal: 12,
    paddingVertical: 8,
    marginRight: 8,
  },
  filterText: {
    fontSize: 14,
    color: "#333",
  },
  userRow: {
    flexDirection: "row",
    alignItems: "center",
    marginBottom: 16,
  },
  userAvatar: {
    width: 50,
    height: 50,
    borderRadius: 25,
    marginRight: 12,
  },
  userInfo: {
    flex: 1,
  },
  userName: {
    fontSize: 16,
    fontWeight: "bold",
  },
  userMeta: {
    fontSize: 12,
    color: "gray",
  },
  followButton: {
    backgroundColor: "black",
    paddingHorizontal: 16,
    paddingVertical: 8,
    borderRadius: 16,
  },
  followButtonText: {
    color: "white",
    fontSize: 14,
    fontWeight: "bold",
  },
  songList: {
    marginTop: 8,
  },
  songRow: {
    flexDirection: "row",
    alignItems: "center",
    marginBottom: 16,
  },
  coverImage: {
    width: 50,
    height: 50,
    borderRadius: 8,
    marginRight: 12,
  },
  songDetails: {
    flex: 1,
  },
  songTitle: {
    fontSize: 16,
    fontWeight: "bold",
  },
  songMeta: {
    fontSize: 12,
    color: "gray",
  },
});

export default LibraryScreen;
