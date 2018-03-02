//
//  ItemType.swift
//  Example
//
//  Created by Gregory Sholl e Santos on 01/03/18.
//  Copyright © 2018 fluig SDK. All rights reserved.
//

import Foundation

protocol ItemType {}

enum ListType: String, ItemType {
    case flow = "mode_flow"
    case components = "mode_components"
}

enum FlowType: String, ItemType {
    case login = "flow_login"
    case eula = "flow_eula"
}

enum ComponentType: String, ItemType {
    case button = "component_button"
    case textField = "component_textField"
    case textFieldGroup = "component_textFieldGroup"
    case mediaView = "component_mediaView"
}
