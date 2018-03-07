//
//  TextFieldProvider.swift
//  Example
//
//  Created by Gregory Sholl e Santos on 07/03/18.
//  Copyright © 2018 fluig SDK. All rights reserved.
//

import UIKit
import fluigSDKUi

struct TextFieldProvider: ComponentInfoProvider {
    
    func provideComponent() -> UIView {
        let textField = FluigSDKTextField()
        textField.placeholder = "Placeholder"
        textField.icon = UIImage(named: "icnAccount")
        textField.textFieldState = .valid
        textField.translatesAutoresizingMaskIntoConstraints = false
        
        NSLayoutConstraint.activate([
            textField.heightAnchor.constraint(equalToConstant: 50.0)
            ])
        
        return textField
    }
    
    func provideComponentText() -> String {
        return """
        textField.placeholder = "Placeholder"
        textField.icon = UIImage(named: "icnAccount")
        textField.textFieldState = .valid
        """
    }
}
