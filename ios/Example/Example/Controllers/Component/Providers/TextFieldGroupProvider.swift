//
//  TextFieldGroupProvider.swift
//  Example
//
//  Created by Gregory Sholl e Santos on 07/03/18.
//  Copyright © 2018 fluig SDK. All rights reserved.
//

import UIKit
import fluigSDKUi

struct TextFieldGroupProvider: ComponentInfoProvider {
    
    func provideComponent() -> UIView {
        let group = FluigSDKTextFieldGroup()
        group.addArranged(textFields: createTextFields())
        group.translatesAutoresizingMaskIntoConstraints = false
        
        return group
    }
    
    func provideComponentText() -> String {
        return """
        group.addArranged(textFields: [firsttextField, secondTextField])
        """
    }
    
    private func createTextFields() -> [FluigSDKTextField] {
        return [0, 1, 2].map { element -> FluigSDKTextField in
            let textField = FluigSDKTextField()
            textField.placeholder = "Text field \(element)"
            textField.translatesAutoresizingMaskIntoConstraints = false
            
            NSLayoutConstraint.activate([
                textField.heightAnchor.constraint(equalToConstant: 50.0)
            ])
            
            return textField
        }
    }
}
