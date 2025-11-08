import React, { useState, useEffect } from 'react';
import {
  View,
  Text,
  Image,
  TouchableOpacity,
  StyleSheet,
} from 'react-native';
import Slider from '@react-native-community/slider';
import { Audio } from 'expo-av';

import { RouteProp } from '@react-navigation/native';
import { StackNavigationProp } from '@react-navigation/stack';

type RootStackParamList = {
  Player: { song: { audio: string; title: string; artist: string; coverImage: any; plays: string; duration: string; } };
};

type PlayerScreenProps = {
  route: RouteProp<RootStackParamList, 'Player'>;
  navigation: StackNavigationProp<RootStackParamList, 'Player'>;
};

const PlayerScreen: React.FC<PlayerScreenProps> = ({ route }) => {
  const { song } = route.params; // Nhận bài hát từ tham số điều hướng
  const [sound, setSound] = useState<null | Audio.Sound>(null);
  const [isPlaying, setIsPlaying] = useState(false);
  const [currentPosition, setCurrentPosition] = useState(0);
  const [duration, setDuration] = useState(0);

  // Load audio khi màn hình mở
  useEffect(() => {
    loadAudio();
    return () => {
      if (sound) {
        sound.unloadAsync();
      }
    };
  }, []);

  const loadAudio = async () => {
    try {
      const { sound: newSound } = await Audio.Sound.createAsync(
        { uri: song.audio },
        { shouldPlay: false }
      );
      setSound(newSound);
      const status = await newSound.getStatusAsync();
      if (status.isLoaded) {
        setDuration(status.durationMillis || 0);
      }
    } catch (error) {
      console.error('Error loading audio', error);
    }
  };

  const togglePlayPause = async () => {
    if (sound) {
      if (isPlaying) {
        sound.pauseAsync();
      } else {
        await sound.playAsync();
        sound.setOnPlaybackStatusUpdate((status) => {
          if (status.isLoaded && status.isPlaying) {
            setCurrentPosition(status.positionMillis);
          }
        });
      }
      setIsPlaying(!isPlaying);
    }
  };

  const formatTime = (millis: number): string => {
    const minutes = Math.floor(millis / 60000);
    const seconds = Math.floor((millis % 60000) / 1000);
    return `${minutes}:${seconds < 10 ? '0' : ''}${seconds}`;
  };

  return (
    <View style={styles.container}>
      <Image source={song.coverImage} style={styles.coverImage} />
      <Text style={styles.songTitle}>{song.title}</Text>
      <Text style={styles.songArtist}>{song.artist}</Text>
      <Text style={styles.songPlays}>{song.plays} plays</Text>

      <Slider
        style={styles.slider}
        minimumValue={0}
        maximumValue={1}
        value={duration ? currentPosition / duration : 0}
        onSlidingComplete={async (value) => {
          if (sound) {
            const position = value * duration;
            sound.setPositionAsync(position);
            setCurrentPosition(position);
          }
        }}
        minimumTrackTintColor="#1DB954"
        maximumTrackTintColor="#fff"
        thumbTintColor="#1DB954"
      />

      <View style={styles.timeContainer}>
        <Text style={styles.timeText}>{formatTime(currentPosition)}</Text>
        <Text style={styles.timeText}>{formatTime(duration)}</Text>
      </View>

      <TouchableOpacity style={styles.playButton} onPress={togglePlayPause}>
        <Text style={styles.playButtonText}>
          {isPlaying ? 'Pause' : 'Play'}
        </Text>
      </TouchableOpacity>
    </View>
  );
};

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#121212',
    alignItems: 'center',
    padding: 20,
  },
  coverImage: {
    width: 300,
    height: 300,
    borderRadius: 10,
    marginBottom: 20,
  },
  songTitle: {
    fontSize: 24,
    color: '#fff',
    fontWeight: 'bold',
  },
  songArtist: {
    fontSize: 18,
    color: '#ccc',
  },
  songPlays: {
    fontSize: 14,
    color: '#999',
    marginBottom: 20,
  },
  slider: {
    width: '100%',
    height: 40,
  },
  timeContainer: {
    flexDirection: 'row',
    justifyContent: 'space-between',
    width: '100%',
    marginBottom: 20,
  },
  timeText: {
    color: '#ccc',
  },
  playButton: {
    backgroundColor: '#1DB954',
    paddingVertical: 15,
    paddingHorizontal: 40,
    borderRadius: 50,
  },
  playButtonText: {
    color: '#fff',
    fontSize: 18,
    fontWeight: 'bold',
  },
});

export default PlayerScreen;
