#import <React/RCTBridgeModule.h>
#import <React/RCTEventEmitter.h>

@interface RCT_EXTERN_MODULE(JSBridge, NSObject)

RCT_EXTERN_METHOD(openComponentForBundle: (NSString)bundlePath moduleName:(NSString)moduleName)

@end
