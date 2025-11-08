import React from "react";
import { View, Text, StyleSheet, FlatList, Image } from "react-native";

import { RouteProp } from '@react-navigation/native';

type PlaylistScreenRouteProp = RouteProp<{ params: { playlistName: string; playlistSongs: { id: string; cover: string; title: string; artist: string; plays?: number; duration?: string }[] } }, 'params'>;

const PlaylistScreen = ({ route }: { route: PlaylistScreenRouteProp }) => {
  const { playlistName, playlistSongs } = route.params;

  const renderSong = ({ item }: { item: { id: string; cover: string; title: string; artist: string; plays?: number; duration?: string } }) => (
    <View style={styles.songRow}>
      <Image source={{ uri: item.cover }} style={styles.coverImage} />
      <View style={styles.songDetails}>
        <Text style={styles.songTitle}>{item.title}</Text>
        <Text style={styles.songMeta}>
          {item.artist} {item.plays && `\u2022 ${item.plays}`}{" "}
          {item.duration && `\u2022 ${item.duration}`}
        </Text>
      </View>
    </View>
  );

  return (
    <View style={styles.container}>
      <Text style={styles.title}>{playlistName}</Text>
      <FlatList
        data={playlistSongs}
        keyExtractor={(item) => item.id}
        renderItem={renderSong}
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
  },
  title: {
    fontSize: 24,
    fontWeight: "bold",
    marginBottom: 16,
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

export default PlaylistScreen;
