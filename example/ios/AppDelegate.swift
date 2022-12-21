//
//  AppDelegate.swift
//  example
//
//  Created by 邵瑾瑜 on 2022/12/21.
//

import Foundation
import MultiBundle
import React

@UIApplicationMain
class AppDelegate: UIResponder, UIApplicationDelegate {
  public static let DEBUG: Bool = true
  // 默认模块
  let DEFAULT_MODULE = DEBUG ? "example" : "gfwmappzj"
  var window: UIWindow?
  var bridge: RCTBridge!
  
  func application(_ application: UIApplication, didFinishLaunchingWithOptions launchOptions: [UIApplication.LaunchOptionsKey : Any]? = nil) -> Bool {
    RCTDevSettingsSetEnabled(AppDelegate.DEBUG)
    RCTDevLoadingView.setEnabled(AppDelegate.DEBUG)
    
    var commonBundleUrl: URL
    
    if AppDelegate.DEBUG {
      commonBundleUrl = RCTBundleURLProvider.sharedSettings().jsBundleURL(forBundleRoot: "index")
    } else {
      // 默认加载主包
      commonBundleUrl = Bundle.main.url(forResource: "buz1.ios", withExtension: "bundle")!
    }
    
    bridge = RCTBridge.init(bundleURL: commonBundleUrl, moduleProvider: nil, launchOptions: launchOptions)
    RNBundleLoader.setBridge(bridge)
    
    if !AppDelegate.DEBUG {
    } else {
      initView()
    }
    
    return true
  }
  
  @objc func initView() -> Void {
      if !AppDelegate.DEBUG {
      }
      
      let rootView = RCTRootView(bridge: self.bridge, moduleName: DEFAULT_MODULE, initialProperties: nil)

      if #available(iOS 13.0, *) {
        rootView.backgroundColor = UIColor.systemBackground
      } else {
        rootView.backgroundColor = UIColor.white
      }

      self.window = UIWindow(frame: UIScreen.main.bounds)
      let rootViewController = UIViewController()
      rootViewController.view = rootView
      let navContoller = UINavigationController.init(rootViewController: rootViewController)
      navContoller.setNavigationBarHidden(true, animated: false)
      self.window?.rootViewController = navContoller
      self.window?.makeKeyAndVisible()
    }
}
