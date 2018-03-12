//
//  UIViewController+Extensions.swift
//  Example
//
//  Created by Gregory Sholl e Santos on 12/03/18.
//  Copyright © 2018 fluig SDK. All rights reserved.
//

import UIKit

extension UIViewController {

    func setupNavigationBar() {
        title = "Example"
        navigationItem.backBarButtonItem = UIBarButtonItem(title: "",
                                                           style: .plain,
                                                           target: nil,
                                                           action: nil)
    }
}
