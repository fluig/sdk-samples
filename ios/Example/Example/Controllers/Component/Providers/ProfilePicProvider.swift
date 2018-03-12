//
//  File.swift
//  Example
//
//  Created by Gregory Sholl e Santos on 08/03/18.
//  Copyright © 2018 fluig SDK. All rights reserved.
//

import UIKit
import fluigSDKUi

struct ProfilePicProvider: ComponentInfoProvider {
    
    func provideComponent() -> UIView {
        let container = UIView()
        container.translatesAutoresizingMaskIntoConstraints = false
        
        let profilePic = FluigSDKProfilePic()
        profilePic.translatesAutoresizingMaskIntoConstraints = false
        profilePic.image = UIImage(named: "doge.jpg")
        profilePic.gradientColor = .black
        profilePic.gradientColorEnd = .red
        
        container.addSubview(profilePic)
        
        NSLayoutConstraint.activate([
            profilePic.topAnchor.constraint(equalTo: container.topAnchor),
            profilePic.bottomAnchor.constraint(equalTo: container.bottomAnchor),
            profilePic.centerXAnchor.constraint(equalTo: container.centerXAnchor),
            profilePic.widthAnchor.constraint(equalToConstant: 100.0),
            profilePic.heightAnchor.constraint(equalToConstant: 100.0)
        ])
        
        return container
    }
    
    func provideComponentText() -> String {
        return """
        profilePic.image = UIImage(named: "doge.jpg")
        profilePic.gradientColor = .black
        profilePic.gradientColorEnd = .red
        """
    }
}
