//
//  ItemType.swift
//  Example
//
//  Created by Gregory Sholl e Santos on 01/03/18.
//  Copyright © 2018 fluig SDK. All rights reserved.
//

import Foundation

protocol ItemType {
    var rawValue: String { get }
}

enum ListType: String, ItemType, EnumCollection {
    case flows = "list_flows"
    case components = "list_components"
}

enum FlowType: String, ItemType, EnumCollection {
    case login = "flow_login"
    case eula = "flow_eula"
}

enum ComponentType: String, ItemType, EnumCollection {
    case button = "component_button"
    case textField = "component_textField"
    case textFieldGroup = "component_textFieldGroup"
    case mediaView = "component_mediaView"
    case profilePic = "component_profilePic"
}

protocol EnumCollection: Hashable {}

extension EnumCollection {
    private static func cases() -> AnySequence<Self> {
        return AnySequence { () -> AnyIterator<Self> in
            var raw = 0
            return AnyIterator {
                let current: Self = withUnsafePointer(to: &raw) {
                    $0.withMemoryRebound(to: self, capacity: 1) { $0.pointee }
                }
                guard current.hashValue == raw else { return nil }
                raw += 1
                return current
            }
        }
    }
    
    static var allValues: [Self] {
        return Array(Self.cases())
    }
}
