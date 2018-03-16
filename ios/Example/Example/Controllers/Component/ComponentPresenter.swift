//
//  ComponentPresenter.swift
//  Example
//
//  Created by Gregory Sholl e Santos on 06/03/18.
//  Copyright © 2018 fluig SDK. All rights reserved.
//

import Foundation

// MARK: - Protocol

protocol ComponentPresenterDelegate {
    
    func obtainCorrectView(with componentType: ComponentType)
}

// MARK: - Initializers & Properties

class ComponentPresenter {
    
    private weak var view: ComponentViewDelegate?
    
    init(view: ComponentViewDelegate) {
        self.view = view
    }
}

// MARK: - Delegate

extension ComponentPresenter: ComponentPresenterDelegate {
    
    func obtainCorrectView(with componentType: ComponentType) {
        switch componentType {
        case .button:
            view?.showView(ComponentView(provider: ButtonProvider()))
        case .textField:
            view?.showView(ComponentView(provider: TextFieldProvider()))
        case .textFieldGroup:
            view?.showView(ComponentView(provider: TextFieldGroupProvider()))
        case .mediaView:
            view?.showView(MediaView())
        case .profilePic:
            view?.showView(ComponentView(provider: ProfilePicProvider()))
        }
    }
}
