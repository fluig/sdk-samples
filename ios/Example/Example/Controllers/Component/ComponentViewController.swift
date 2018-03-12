//
//  ComponentViewController.swift
//  Example
//
//  Created by Gregory Sholl e Santos on 06/03/18.
//  Copyright © 2018 fluig SDK. All rights reserved.
//

import UIKit

protocol ComponentViewDelegate: NSObjectProtocol {
    
    func showView(_ view: UIView)
}

class ComponentViewController: UIViewController {

    private var componentType: ComponentType?
    
    private var presenter: ComponentPresenterDelegate?
    
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

        setupNavigationBar()

        guard let component = componentType else { return }
        
        presenter = ComponentPresenter(view: self)
        presenter?.obtainCorrectView(with: component)
    }
}

extension ComponentViewController: ComponentViewDelegate {
    
    func showView(_ view: UIView) {
        self.view.subviews.forEach { $0.removeFromSuperview() }
        self.view.addSubview(view)
        
        if #available(iOS 11.0, *) {
            let guide = self.view.safeAreaLayoutGuide
            NSLayoutConstraint.activate(
                [view.topAnchor.constraint(equalTo: guide.topAnchor),
                 view.leadingAnchor.constraint(equalTo: guide.leadingAnchor),
                 view.trailingAnchor.constraint(equalTo: guide.trailingAnchor),
                 view.bottomAnchor.constraint(equalTo: guide.bottomAnchor)]
            )
        } else {
            NSLayoutConstraint.activate(
                [view.topAnchor.constraint(equalTo: self.view.topAnchor),
                 view.leadingAnchor.constraint(equalTo: self.view.leadingAnchor),
                 view.trailingAnchor.constraint(equalTo: self.view.trailingAnchor),
                 view.bottomAnchor.constraint(equalTo: self.view.bottomAnchor)]
            )
        }
    }
}
