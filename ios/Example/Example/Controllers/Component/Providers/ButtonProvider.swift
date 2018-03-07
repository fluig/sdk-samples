//
//  ButtonProvider.swift
//  Example
//
//  Created by Gregory Sholl e Santos on 07/03/18.
//  Copyright © 2018 fluig SDK. All rights reserved.
//

import UIKit
import fluigSDKUi

struct ButtonProvider: ComponentInfoProvider {
    
    func provideComponent() -> UIView {
        let button = FluigSDKButton()
        button.setTitle("OK", for: .normal)
        button.backgroundColor = .blue
        button.backgroundColorEnd = .magenta
        button.translatesAutoresizingMaskIntoConstraints = false
        
        NSLayoutConstraint.activate([
            button.heightAnchor.constraint(equalToConstant: 50.0)
        ])
        
        return button
    }
    
    func provideComponentText() -> String {
        return """
        button.setTitle("OK", for: .normal)
        button.backgroundColor = .blue
        button.backgroundColorEnd = .magenta
        """
    }
}
