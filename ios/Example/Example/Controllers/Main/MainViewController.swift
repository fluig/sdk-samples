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

// MARK: - Inits & Lifecycle

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
        setupEulaNotification()
        
        presenter = MainPresenter(view: self)
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
        let viewController = ComponentViewController(componentType: componentType)
        navigationController?.pushViewController(viewController, animated: true)
    }
    
    func showLoginFlow() {
        let logo = UIImage(named: "loginLogo")
        let video = Bundle.main.url(forResource: "video_background",
                                    withExtension: "mp4")
        let pageTitle = L10n.loginTitle
        let pageTips = [L10n.loginTipInfo, L10n.loginTipUrl]
        let successViewController = SuccessViewController(nibName: nil, bundle: nil)
        
        let configuration = LoginFlowConfiguration(logoImage: logo,
                                                   backgroundVideoUrl: video,
                                                   emailRequestPageTitle: pageTitle,
                                                   emailRequestPageTips: pageTips,
                                                   onSuccessReplaceRootWith: successViewController)
        
        LoginFlow(configuration: configuration).start(from: self)
    }
    
    func showEulaFlow() {
        let terms = Bundle.main.url(forResource: "eula", withExtension: "html")
        
        let configuration = EulaFlowConfiguration(termsURL: terms,
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

// MARK: - Layout

extension MainViewController {
    
    private func setupView() {
        setupNavigationBar()
        
        tableView.tableFooterView = UIView()
        tableView.addSubview(refreshControl!)
        
        list = ListType.allValues
    }
    
    private func setupNavigationBar() {
        title = "Example"
        navigationItem.backBarButtonItem = UIBarButtonItem(title: "",
                                                           style: .plain,
                                                           target: nil,
                                                           action: nil)
    }
}

// MARK: - Notification

extension MainViewController {
    
    private func setupEulaNotification() {
        NotificationCenter.default.addObserver(self,
                                               selector: #selector(onEulaAccepted),
                                               name: .fluigSdkDidAcceptEula,
                                               object: nil)
        NotificationCenter.default.addObserver(self,
                                               selector: #selector(onEulaDeclined),
                                               name: .fluigSdkDidNotAcceptEula,
                                               object: nil)
    }
    
    @objc
    private func onEulaAccepted() {
        let successViewController = SuccessViewController(flowName: "EULA")
        navigationController?.pushViewController(successViewController,
                                                 animated: true)
    }
    
    @objc
    private func onEulaDeclined() {
    }
}
