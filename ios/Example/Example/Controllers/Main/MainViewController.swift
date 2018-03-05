//
//  MainViewController.swift
//  Example
//
//  Created by Gregory Sholl e Santos on 02/03/18.
//  Copyright © 2018 fluig SDK. All rights reserved.
//

import UIKit
import fluigSDKFlows

protocol MainViewDelegate: NSObjectProtocol {
    
    func showErrorMessage(_ message: String)
    
    func showList(_ list: [ItemType])
    
    func showComponent(_ componentType: ComponentType)
    
    func showLoginFlow()
    
    func showEulaFlow()
}

// MARK: - MainViewController

class MainViewController: UITableViewController {
    
    override lazy var refreshControl: UIRefreshControl? = {
        let refreshControl = UIRefreshControl()
        refreshControl.addTarget(self,
                                 action: #selector(refreshControlDidChangeValue(_:)),
                                 for: .valueChanged)
        return refreshControl
    }()
    
    private var list: [ItemType] = [] {
        didSet {
            tableView.reloadData()
        }
    }
    
    private var presenter: MainPresenterDelegate?
    
    override func viewDidLoad() {
        super.viewDidLoad()

        setupView()
        
        presenter = MainPresenter(view: self)
    }
    
    private func setupView() {
        title = "Example"
        
        tableView.tableFooterView = UIView()
        tableView.addSubview(refreshControl!)
        
        list = ListType.allValues
    }
}

// MARK: - Actions

extension MainViewController {
    
    @objc func refreshControlDidChangeValue(_ refreshControl: UIRefreshControl) {
        list = ListType.allValues
        
        refreshControl.endRefreshing()
    }
}

// MARK: - MainViewDelegate

extension MainViewController: MainViewDelegate {
    
    func showErrorMessage(_ message: String) {
        let alert = UIAlertController(title: L10n.error,
                                      message: message,
                                      preferredStyle: .alert)
        alert.addAction(UIAlertAction(title: "OK", style: .default))
        present(alert, animated: true)
    }
    
    func showList(_ list: [ItemType]) {
        self.list = list
    }
    
    func showComponent(_ componentType: ComponentType) {
        
    }
    
    func showLoginFlow() {
        let logo: UIImage? = nil
        let video: URL? = nil
        let pageTitle: String = ""
        let pageTips: [String] = []
        let successViewController: UIViewController? = nil
        
        let configuration = LoginFlowConfiguration(logoImage: logo,
                                                   backgroundVideoUrl: video,
                                                   emailRequestPageTitle: pageTitle,
                                                   emailRequestPageTips: pageTips,
                                                   onSuccessReplaceRootWith: successViewController)
        
        LoginFlow(configuration: configuration).start(from: self)
    }
    
    func showEulaFlow() {
        let configuration = EulaFlowConfiguration(termsURL: nil,
                                                  appName: "Example",
                                                  backgroundColor: UIColor.app.blue)
        
        EulaFlow(configuration: configuration).start(from: self)
    }
}

// MARK: - UITableViewDataSource & UITableViewDelegate

extension MainViewController {
    
    override func tableView(_ tableView: UITableView,
                            numberOfRowsInSection section: Int) -> Int {
        return list.count
    }
    
    override func tableView(_ tableView: UITableView,
                            cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        
        guard indexPath.row < list.count else { return UITableViewCell() }
        
        let itemType = list[indexPath.row]
        
        let cell = UITableViewCell(style: .default, reuseIdentifier: nil)
        cell.textLabel?.text = L10n.get(itemType.rawValue)
        cell.separatorInset = UIEdgeInsets(top: 0, left: 0, bottom: 0, right: 0)
        
        return cell
    }
    
    override func tableView(_ tableView: UITableView,
                            didSelectRowAt indexPath: IndexPath) {
        
        guard indexPath.row < list.count else { return }
        
        let itemType = list[indexPath.row]
        presenter?.obtainNextStep(with: itemType)
    }
}

