import React
import UIKit

@objc(JSBridge)
public class JSBridge: NSObject {
  
  override init() {
    super.init()
  }

  
  @objc(openComponentForBundle:moduleName:)
  func openComponentForBundle(_ bundlePath: String, moduleName: String) -> Void {
    DispatchQueue.main.async {
      let controller: UIViewController = RNBundleController(bundlePath: bundlePath, moduleName: moduleName, params: [:])
      UIApplication.shared.delegate?.window??.rootViewController?.navigationController?.pushViewController(controller, animated: true)
    }
  }
}
