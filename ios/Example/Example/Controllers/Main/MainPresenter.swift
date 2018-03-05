//
//  MainPresenter.swift
//  Example
//
//  Created by Gregory Sholl e Santos on 05/03/18.
//  Copyright © 2018 fluig SDK. All rights reserved.
//

import Foundation

protocol MainPresenterDelegate {
    func obtainNextStep(with itemType: ItemType)
}

class MainPresenter {
    
    private weak var view: MainViewDelegate?
    
    init(view: MainViewDelegate) {
        self.view = view
    }
    
    private func showList(_ listType: ListType) {
        switch listType {
        case .flows:
            view?.showList(FlowType.allValues)
        case .components:
            view?.showList(ComponentType.allValues)
        }
    }
    
    private func showFlow(_ flowType: FlowType) {
        switch flowType {
        case .login:
            view?.showLoginFlow()
        case .eula:
            view?.showEulaFlow()
        }
    }
}

extension MainPresenter: MainPresenterDelegate {
    
    func obtainNextStep(with itemType: ItemType) {
        if let listType = itemType as? ListType {
            showList(listType)
            
        } else if let flowType = itemType as? FlowType {
            showFlow(flowType)
            
        } else if let componentType = itemType as? ComponentType {
            view?.showComponent(componentType)
            
        } else {
            view?.showError("")
        }
    }
}
