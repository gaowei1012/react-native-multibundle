import React from 'react';
import {
  AppRegistry,
  SafeAreaView,
  TouchableOpacity,
  Text,
} from 'react-native';
import { openComponentForBundle } from 'react-native-multibundle';

const Demo = () => {
  return (
    <SafeAreaView>
      <TouchableOpacity
        onPress={() => {
          openComponentForBundle('assets://base.ios.bundle', 'example');
        }}>
        <Text>打开子包</Text>
      </TouchableOpacity>
    </SafeAreaView>
  );
};

AppRegistry.registerComponent('example', () => Demo);
