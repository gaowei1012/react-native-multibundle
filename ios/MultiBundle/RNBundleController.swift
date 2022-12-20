
import React

class RNBundleController: UIViewController {
  var bundlePath: String
  var moduleName: String
  var params: Dictionary<String, Any>
  
  init(bundlePath: String, moduleName: String, params: Dictionary<String, Any>) {
    self.bundlePath = bundlePath;
    self.moduleName = moduleName
    self.params = params
    super.init(nibName:nil, bundle:nil)
  }
  
  required init?(coder: NSCoder) {
    fatalError("init(coder:) has not been implemented")
  }
  
  override func viewDidLoad() {
    super.viewDidLoad()
    initView()
  }
  
  func initView() -> Void {
    RNBundleLoader.load(bundlePath)
    let rctBridge = RNBundleLoader.getBridge()
    let view = RCTRootView(bridge: rctBridge, moduleName: self.moduleName, initialProperties: self.params)
    self.view = view
  }
  
}
