import React from 'react';
import { SafeAreaView, Text, AppRegistry } from 'react-native';

const Base = () => {
  return (
    <SafeAreaView>
      <Text>base app</Text>
    </SafeAreaView>
  );
};

AppRegistry.registerComponent('example', () => Base);
