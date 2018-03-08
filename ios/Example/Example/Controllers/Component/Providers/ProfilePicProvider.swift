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
        let profilePic = FluigSDKProfilePic()
        profilePic.image = nil
        
        return profilePic
    }
    
    func provideComponentText() -> String {
        return """
        """
    }
}
