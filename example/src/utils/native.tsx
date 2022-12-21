import { NativeModules } from 'react-native';

export const JSBridge = NativeModules.JSBridge
  ? NativeModules.JSBridge
  : new Proxy(
      {},
      {
        get() {
          throw new Error();
        },
      },
    );

export function openComponentForBundle(
  bundlePath: string,
  moduleName: string,
  params?: Record<string, any>,
) {
  console.log(JSBridge);

  JSBridge?.openComponentForBundle(bundlePath, moduleName);
}
