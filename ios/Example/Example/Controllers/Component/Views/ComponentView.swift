//
//  ComponentView.swift
//  Example
//
//  Created by Gregory Sholl e Santos on 06/03/18.
//  Copyright © 2018 fluig SDK. All rights reserved.
//

import UIKit

protocol ComponentInfoProvider: NSObjectProtocol {
    
    func addComponent(to subview: inout UIView)
    
    func provideComponentText() -> String
}

class ComponentView: UIView {
    init(provider: ComponentInfoProvider) {
        super.init(frame: .zero)
        self.provider = provider
    }

}
