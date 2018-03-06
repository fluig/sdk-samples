//
//  ComponentViewController.swift
//  Example
//
//  Created by Gregory Sholl e Santos on 06/03/18.
//  Copyright © 2018 fluig SDK. All rights reserved.
//

import UIKit

protocol ComponentViewDelegate {
    
    func showView(_ view: UIView)
}

class ComponentViewController: UIViewController {

    private var componentType: ComponentType?
    
    init(componentType: ComponentType) {
        super.init(nibName: nil, bundle: nil)
        
        self.componentType = componentType
    }
    
    override init(nibName nibNameOrNil: String?,
                  bundle nibBundleOrNil: Bundle?) {
        super.init(nibName: nibNameOrNil, bundle: nibBundleOrNil)
    }
    
    required init?(coder aDecoder: NSCoder) {
        super.init(coder: aDecoder)
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()

        
    }

}
