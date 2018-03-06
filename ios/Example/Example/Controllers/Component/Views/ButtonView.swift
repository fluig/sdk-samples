//
//  ComponentView+Subclasses.swift
//  Example
//
//  Created by Gregory Sholl e Santos on 06/03/18.
//  Copyright © 2018 fluig SDK. All rights reserved.
//

import UIKit
import fluigSDKUi

class ButtonView: UIView {
    
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

extension ButtonView: ComponentInfoProvider {
    
    func addComponent(to subview: inout UIView) {
        let button = FluigSDKButton()
        button.setTitle("OK", for: .normal)
        button.backgroundColor = .blue
        button.backgroundColorEnd = .magenta
        button.translatesAutoresizingMaskIntoConstraints = false
        
        subview.addSubview(button)
        
        NSLayoutConstraint.activate(
            [button.topAnchor.constraint(equalTo: subview.topAnchor),
             button.leadingAnchor.constraint(equalTo: subview.leadingAnchor),
             button.trailingAnchor.constraint(equalTo: subview.trailingAnchor),
             button.heightAnchor.constraint(equalToConstant: 50.0),
             button.bottomAnchor.constraint(equalTo: subview.bottomAnchor)]
        )
    }
    
    func provideComponentText() -> String {
        return """
        button.setTitle("OK", for: .normal)
        button.backgroundColor = .blue
        button.backgroundColorEnd = .magenta
        """
    }
}
