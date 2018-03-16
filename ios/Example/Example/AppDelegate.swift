//
//  AppDelegate.swift
//  Example
//
//  Created by Gregory Sholl e Santos on 27/02/18.
//  Copyright © 2018 fluig SDK. All rights reserved.
//

import UIKit

@UIApplicationMain
class AppDelegate: UIResponder, UIApplicationDelegate {

    var window: UIWindow?

    func application(_ application: UIApplication,
                     didFinishLaunchingWithOptions launchOptions: [UIApplicationLaunchOptionsKey: Any]?) -> Bool {
        
        let main = MainViewController()
        let navigationController = ExampleNavigationController(rootViewController: main)
        
        window = UIWindow(frame: UIScreen.main.bounds)
        window?.makeKeyAndVisible()
        window?.rootViewController = navigationController
        
        return true
    }
}

private class ExampleNavigationController: UINavigationController {
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        navigationBar.isOpaque = true
        navigationBar.tintColor = .white
        navigationBar.barTintColor = UIColor.app.blue
        navigationBar.titleTextAttributes = [.foregroundColor: UIColor.white]
    }
    
    private var rotationDelegate: RotationDelegate? {
        var delegate = topViewController as? RotationDelegate
        if delegate == nil {
            delegate = presentedViewController as? RotationDelegate
        }
        return delegate
    }
    
    override var shouldAutorotate: Bool {
        return rotationDelegate?.enableRotation ?? false
    }
    
    override var supportedInterfaceOrientations: UIInterfaceOrientationMask {
        return (rotationDelegate?.enableRotation ?? false) ?
            .allButUpsideDown : .portrait
    }
}
