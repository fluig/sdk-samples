//
//  SuccessViewController.swift
//  Example
//
//  Created by Gregory Sholl e Santos on 05/03/18.
//  Copyright © 2018 fluig SDK. All rights reserved.
//

import UIKit

class SuccessViewController: UIViewController {
    
    private var flowName: String?
    
    init(flowName: String) {
        super.init(nibName: nil, bundle: nil)
        
        self.flowName = flowName
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
        
        setupView()
    }
}

// MARK: - Layout

extension SuccessViewController {
    
    private func setupView() {
        setupNavigationBar()
        let labels = setupLabels()
        setupStackView(labels)
    }
    
    private func setupLabels() -> [UILabel] {
        var labels = [UILabel]()
        
        let successLabel = UILabel()
        successLabel.text = L10n.success
        successLabel.textAlignment = .center
        successLabel.translatesAutoresizingMaskIntoConstraints = false
        labels.append(successLabel)
        
        if let flow = flowName {
            let flowCompletedLabel = UILabel()
            flowCompletedLabel.numberOfLines = 0
            flowCompletedLabel.text = L10n.successFlowSource(flow)
            flowCompletedLabel.textAlignment = .center
            flowCompletedLabel.translatesAutoresizingMaskIntoConstraints = false
            labels.append(flowCompletedLabel)
        }
        return labels
    }
    
    private func setupStackView(_ views: [UIView]) {
        let stackView = UIStackView()
        stackView.axis = .vertical
        stackView.spacing = 16
        stackView.alignment = .fill
        stackView.distribution = .equalSpacing
        stackView.translatesAutoresizingMaskIntoConstraints = false
        _ = views.map { stackView.addArrangedSubview($0) }
        
        view.backgroundColor = .white
        view.addSubview(stackView)
        
        if #available(iOS 11.0, *) {
            let guide = view.safeAreaLayoutGuide
            NSLayoutConstraint.activate(
                [stackView.centerXAnchor.constraint(equalTo: guide.centerXAnchor),
                 stackView.centerYAnchor.constraint(equalTo: guide.centerYAnchor),
                 stackView.leadingAnchor.constraint(greaterThanOrEqualTo: guide.leadingAnchor,
                                                    constant: 16.0),
                 stackView.trailingAnchor.constraint(lessThanOrEqualTo: guide.trailingAnchor,
                                                     constant: 16.0)]
            )
        } else {
            NSLayoutConstraint.activate(
                [stackView.centerXAnchor.constraint(equalTo: view.centerXAnchor),
                 stackView.centerYAnchor.constraint(equalTo: view.centerYAnchor),
                 stackView.leadingAnchor.constraint(greaterThanOrEqualTo: view.leadingAnchor,
                                                    constant: 16.0),
                 stackView.trailingAnchor.constraint(lessThanOrEqualTo: view.trailingAnchor,
                                                     constant: 16.0)]
            )
        }
    }
}
