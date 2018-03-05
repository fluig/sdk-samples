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
        let navigationController = UINavigationController(rootViewController: main)
        
        window = UIWindow(frame: UIScreen.main.bounds)
        window?.makeKeyAndVisible()
        window?.rootViewController = navigationController
        
        return true
    }
}
