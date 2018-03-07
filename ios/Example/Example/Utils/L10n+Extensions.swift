//
//  L10n+Extensions.swift
//  Example
//
//  Created by Gregory Sholl e Santos on 07/03/18.
//  Copyright © 2018 fluig SDK. All rights reserved.
//

import Foundation

extension L10n {

  public static func get(_ key: String, _ args: CVarArg...) -> String {
    let format = NSLocalizedString(key,
                                   tableName: "Localizable",
                                   bundle: Bundle(for: BundleTokenExtension.self),
                                   comment: "")
    return String(format: format, locale: Locale.current, arguments: args)
  }
}

private final class BundleTokenExtension {}
