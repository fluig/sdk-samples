//
//  ComponentView.swift
//  Example
//
//  Created by Gregory Sholl e Santos on 06/03/18.
//  Copyright © 2018 fluig SDK. All rights reserved.
//

import UIKit

protocol ComponentInfoProvider {
    
    func provideComponent() -> UIView
    
    func provideComponentText() -> String
}

class ComponentView: UIView {
    
    private var containerView = UIView()
    
    private var provider: ComponentInfoProvider?
    
    init(provider: ComponentInfoProvider) {
        super.init(frame: .zero)
        self.provider = provider
        setupView()
    }
    
    required init?(coder aDecoder: NSCoder) {
        super.init(coder: aDecoder)
        setupView()
    }
}

// MARK: - Layout

extension ComponentView {
    
    private func setupView() {
        backgroundColor = .white
        translatesAutoresizingMaskIntoConstraints = false
        
        setupContainerView()
        setupTextView()
    }
    
    private func setupContainerView() {
        containerView.translatesAutoresizingMaskIntoConstraints = false
        
        guard let component = provider?.provideComponent() else { return }
        
        containerView.addSubview(component)
        
        NSLayoutConstraint.activate([
            component.topAnchor.constraint(equalTo: containerView.topAnchor),
            component.leadingAnchor.constraint(equalTo: containerView.leadingAnchor),
            component.trailingAnchor.constraint(equalTo: containerView.trailingAnchor),
            component.bottomAnchor.constraint(equalTo: containerView.bottomAnchor)
        ])
        
        addSubview(containerView)
        
        NSLayoutConstraint.activate([
            containerView.topAnchor.constraint(equalTo: topAnchor,
                                               constant: 16.0),
            containerView.leadingAnchor.constraint(equalTo: leadingAnchor,
                                                   constant: 16.0),
            containerView.trailingAnchor.constraint(equalTo: trailingAnchor,
                                                    constant: -16.0)
        ])
    }
    
    private func setupTextView() {
        let textView = UITextView()
        textView.text = provider?.provideComponentText()
        textView.textColor = .darkGray
        textView.font = UIFont(name: "Menlo", size: 17.0)
        textView.isEditable = false
        textView.translatesAutoresizingMaskIntoConstraints = false
        
        addSubview(textView)
        
        NSLayoutConstraint.activate([
            textView.topAnchor.constraint(equalTo: containerView.bottomAnchor,
                                          constant: 16.0),
            textView.leadingAnchor.constraint(equalTo: leadingAnchor,
                                              constant: 16.0),
            textView.trailingAnchor.constraint(equalTo: trailingAnchor,
                                               constant: -16.0),
            textView.bottomAnchor.constraint(equalTo: bottomAnchor,
                                             constant: 16.0)
        ])
    }
}
