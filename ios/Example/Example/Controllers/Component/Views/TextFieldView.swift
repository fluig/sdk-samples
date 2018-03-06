//
//  TextFieldView.swift
//  Example
//
//  Created by Gregory Sholl e Santos on 06/03/18.
//  Copyright © 2018 fluig SDK. All rights reserved.
//

import UIKit
import fluigSDKUi

class TextFieldView: UIView {

    private weak var componentView: ComponentView?
    
    init() {
        super.init(frame: .zero)
        setupView()
    }
    
    required init?(coder aDecoder: NSCoder) {
        super.init(coder: aDecoder)
        setupView()
    }
    
    private func setupView() {
        backgroundColor = .white
        translatesAutoresizingMaskIntoConstraints = false
        
        let componentView = ComponentView(provider: self)
        addSubview(componentView)
        
        NSLayoutConstraint.activate(
            [componentView.topAnchor.constraint(equalTo: topAnchor),
             componentView.leadingAnchor.constraint(equalTo: leadingAnchor),
             componentView.trailingAnchor.constraint(equalTo: trailingAnchor),
             componentView.bottomAnchor.constraint(equalTo: bottomAnchor)]
        )
        
        self.componentView = componentView
    }
}

extension TextFieldView: ComponentInfoProvider {
    
    func addComponent(to subview: inout UIView) {
        let textField = FluigSDKTextField()
        textField.placeholder = "Placeholder"
        textField.icon = UIImage(named: "icnAccount")
        textField.textFieldState = .valid
        textField.translatesAutoresizingMaskIntoConstraints = false
        
        subview.addSubview(textField)
        
        NSLayoutConstraint.activate(
            [textField.topAnchor.constraint(equalTo: subview.topAnchor),
             textField.leadingAnchor.constraint(equalTo: subview.leadingAnchor),
             textField.trailingAnchor.constraint(equalTo: subview.trailingAnchor),
             textField.heightAnchor.constraint(equalToConstant: 50.0),
             textField.bottomAnchor.constraint(equalTo: subview.bottomAnchor)]
        )
    }
    
    func provideComponentText() -> String {
        return """
        textField.placeholder = "Placeholder"
        textField.icon = UIImage(named: "icnAccount")
        textField.textFieldState = .valid
        """
    }
}
